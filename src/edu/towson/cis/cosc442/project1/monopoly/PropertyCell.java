package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a purhcasable property cell on the Monopoly board. 
 * This class extends the abstract Cell class and adds specific attributes and behaviors related to properties, such as color group, house price, number of houses, rent, and selling price.
 */
public class PropertyCell extends Cell {
	private String colorGroup;
	private int housePrice;
	private int numHouses;
	private int rent;
	private int sellPrice;

	/**
	 * Returns the color group of this property cell.
	 * @return The color group of the property.
	 */
	public String getColorGroup() {
		return colorGroup;
	}

	/**
	 * Returns the price of a house on this property.
	 * @return The price for building a house on this property.
	 */
	public int getHousePrice() {
		return housePrice;
	}

	/**
	 * Returns the number of houses currently built on this property.
	 * @return The number of houses on the property.
	 */
	public int getNumHouses() {
		return numHouses;
	}
    
    /**
     * Returns the selling price of this property.
     * @return The selling price of the property.
     */
    public int getPrice() {
		return sellPrice;
	}

	/**
	 * Calculates and returns the rent to be paid for landing on this property, considering monopolies and houses.
	 * @return The rent amount to charge the player landing on this property.
	 */
	public int getRent() {
		int rentToCharge = rent;
		String [] monopolies = theOwner.getMonopolies();
		rentToCharge = caclulateMonopoliesRent(rentToCharge, monopolies);
		if(numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	/**
	 * Calculates the rent to charge based on whether the owner has a monopoly on the color group.
	 * @param rentToCharge The initial rent amount before monopoly adjustment.
	 * @param monopolies An array of color groups on which the owner has a monopoly.
	 * @return The adjusted rent amount after monopoly consideration.
	 */
	private int caclulateMonopoliesRent(int rentToCharge, String[] monopolies) {
		for(int i = 0; i < monopolies.length; i++) {
			if(monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		return rentToCharge;
	}

	/**
	 * Executes the action for when a player lands on this property, including paying rent if applicable.
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

	/**
	 * Sets the color group for this property cell.
	 * @param colorGroup The color group to assign to the property.
	 */
	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}

	/**
	 * Sets the price of a house for this property.
	 * @param housePrice The new house price to set.
	 */
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	/**
	 * Sets the number of houses currently built on this property.
	 * @param numHouses The number of houses to set on the property.
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/**
	 * Sets the selling price of this property.
	 * @param sellPrice The price to set for selling the property.
	 */
	public void setPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/**
	 * Sets the base rent amount for this property.
	 * @param rent The rent amount to set for the property.
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
}
