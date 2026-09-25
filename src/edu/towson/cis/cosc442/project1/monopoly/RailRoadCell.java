package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a railroad cell on the Monopoly board. 
 * This class extends the abstract Cell class and adds specific attributes and behaviors related to railroads, such as base rent, price, and rent calculation based on ownership.
 */
public class RailRoadCell extends Cell {
	static private int baseRent;
	static public String COLOR_GROUP = "RAILROAD";
	static private int price;

	/**
	 * Sets the base rent value for all railroad cells.
	 * @param baseRent the base rent amount to be set
	 */
	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	/**
	 * Sets the purchase price for all railroad cells.
	 * @param price the price amount to be set
	 */
	public static void setPrice(int price) {
		RailRoadCell.price = price;
	}
	
	/**
	 * Returns the purchase price of the railroad cell.
	 * @return the purchase price of this railroad cell
	 */
	public int getPrice() {
		return RailRoadCell.price;
	}

	/**
	 * Calculates and returns the rent owed based on the number of railroads owned by the owner.
	 * @return the calculated rent amount based on ownership
	 */
	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, theOwner.numberOfRR() - 1);
	}
	
	/**
	 * Executes the action when a player lands on the railroad cell, charging rent if owned by another player.
	 */
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				currentPlayer.payRentTo(theOwner, getRent());
			}
		}
	}
}
