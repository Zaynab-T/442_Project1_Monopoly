package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

/**
 * GainMoneyCardTest is a test class that extends TestCase to test the functionality of the MoneyCard class, specifically for cards that grant players money.
 * It sets up a game environment with a GameMaster and a specific game board configuration, and includes tests for the card's action and its interaction with the user interface.
 */
public class GainMoneyCardTest extends TestCase {
    Card gainMoneyCard;
    GameMaster gameMaster;

    /**
     * Executes setUp.
     */
    protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCGainMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gainMoneyCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
		gameMaster.getGameBoard().addCard(gainMoneyCard);
    }
    
    /**
     * Executes testGainMoneyCardAction.
     */
    public void testGainMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
		Card card = gameMaster.drawCCCard();
		assertEquals(gainMoneyCard, card);
		card.applyAction();
		assertEquals(origMoney + 50, gameMaster.getCurrentPlayer().getMoney());
    }
    
    /**
     * Executes testGainMoneyCardUI.
     */
    public void testGainMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}
