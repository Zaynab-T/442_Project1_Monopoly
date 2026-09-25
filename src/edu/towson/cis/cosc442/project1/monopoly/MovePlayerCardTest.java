package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

/**
 * MovePlayerCardTest is a test class for the MovePlayerCard functionality in the Monopoly game.
 * It verifies that the MovePlayerCard correctly moves players to specified cells and updates the game state accordingly.
 */
public class MovePlayerCardTest extends TestCase {
    GameMaster gameMaster;
    Card movePlayerCard;
    
    /**
     * Initializes the game master, game board, player count, GUI, and adds a MovePlayerCard to the game board before each test.
     */
    protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCMovePlayer());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		movePlayerCard = new MovePlayerCard("Blue 1", Card.TYPE_CC);
		gameMaster.getGameBoard().addCard(movePlayerCard);
    }
    
    /**
     * Verifies that the label of the MovePlayerCard is correctly set to 'Go to Blue 1'.
     */
    public void testJailCardLabel() {
        assertEquals("Go to Blue 1", movePlayerCard.getLabel());
    }
    
    /**
     * Tests that drawing and applying the MovePlayerCard correctly moves the current player to the 'Blue 1' cell.
     */
    public void testMovePlayerCardAction() {
		Card card = gameMaster.drawCCCard();
		assertEquals(movePlayerCard, card);
		card.applyAction();
		Cell cell = gameMaster.getCurrentPlayer().getPosition();
		assertEquals(gameMaster.getGameBoard().queryCell("Blue 1"), cell);
    }
    
    /**
     * Checks the GUI button states and player position and money after moving the player and drawing the MovePlayerCard.
     */
    public void testMovePlayerCardUI() {
        gameMaster.movePlayer(0, 2);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		Cell cell = gameMaster.getCurrentPlayer().getPosition();
		assertEquals(gameMaster.getGameBoard().queryCell("Blue 1"), cell);
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
		assertEquals(1700, gameMaster.getCurrentPlayer().getMoney());
    }
}
