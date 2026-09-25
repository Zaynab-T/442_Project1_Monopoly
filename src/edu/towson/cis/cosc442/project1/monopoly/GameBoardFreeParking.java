
package edu.towson.cis.cosc442.project1.monopoly;

/**
 * GameBoardFreeParking is a subclass of GameBoard that initializes a Monopoly game board with a specific configuration of cells, including Jail, Free Parking, and Go To Jail cells.
 * This class sets up the board with predefined names for these special cells.
 */
public class GameBoardFreeParking extends GameBoard {
	/**
	 * Initializes a GameBoardFreeParking instance with Jail, Free Parking, and Go To Jail cells added.
	 */
	public GameBoardFreeParking() {
		super();
		JailCell jail = new JailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		GoToJailCell goToJail = new GoToJailCell();
		addCell(jail);
		addCell(freeParking);
		addCell(goToJail);

	}
}
