package edu.towson.cis.cosc442.project1.monopoly;

/**
 * GameBoardCCLoseMoney is a subclass of GameBoard that initializes a Monopoly game board with specific cells and cards configured to include Community Chest and Chance cards that cause players to lose money.
 * This class sets up the board with predefined names, colors, prices, rents, and house prices for the various cells.
 */
public class GameBoardCCLoseMoney extends GameBoard {
    /**
     * Initializes a game board with specific cells and cards configured to include Community Chest and Chance cards that cause players to lose money.
     */
    public GameBoardCCLoseMoney() {
		super();
		PropertyCell blue1 = new PropertyCell();
		PropertyCell blue2 = new PropertyCell();
        CardCell cc1 = new CardCell(Card.TYPE_CC, "Community Chest 1");
        JailCell jail = new JailCell();
        CardCell chance1 = new CardCell(Card.TYPE_CHANCE, "Chance 1");
        
        Card ccCard1 = new MoneyCard("Pay $20", -20, Card.TYPE_CC);
        new MoneyCard("Pay $30", -30, Card.TYPE_CHANCE);
		
		blue1.setName("Blue 1");
		blue2.setName("Blue 2");
		
		blue1.setColorGroup("blue");
		blue2.setColorGroup("blue");
		
		blue1.setPrice(100);
		blue2.setPrice(100);
		
		blue1.setRent(10);
		blue2.setRent(10);
		
		blue1.setHousePrice(50);
		blue2.setHousePrice(50);
		
		addCard(ccCard1);
		
		addCell(cc1);
		addCell(blue1);
		addCell(jail);
		addCell(blue2);
		addCell(chance1);
		
    }
}
