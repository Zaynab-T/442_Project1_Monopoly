package edu.towson.cis.cosc442.project1.monopoly;

/**
 * GameBoardCCGainMoney is a subclass of GameBoard that initializes a Monopoly game board with two blue properties, a community chest cell, a jail cell, and a chance card cell.
 * This class sets up the board with predefined names, colors, prices, rents, and house prices for the various cells, as well as community chest and chance cards that provide money gain to players.
 */
public class GameBoardCCGainMoney extends GameBoard {
    /**
     * Initializes the game board with properties, cells, and cards configured for a Monopoly game featuring Community Chest money gain cards.
     */
    public GameBoardCCGainMoney() {
		super();
		PropertyCell blue1 = new PropertyCell();
		PropertyCell blue2 = new PropertyCell();
		CardCell cc1 = new CardCell(Card.TYPE_CC, "Community Chest 1");
		JailCell jail = new JailCell();
		CardCell chance1 = new CardCell(Card.TYPE_CHANCE, "Chance 1");
		
		Card ccCard1 = new MoneyCard("Win $50", 50, Card.TYPE_CC);
        Card chanceCard1 = new MoneyCard("Win $30", 30, Card.TYPE_CHANCE);
		
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
        addCard(chanceCard1);
		
		addCell(cc1);
		addCell(blue1);
		addCell(jail);
		addCell(blue2);
		addCell(chance1);
		
    }
}
