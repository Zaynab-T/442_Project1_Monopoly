package edu.towson.cis.cosc442.project1.monopoly;

/**
 * This abstract class represents a cell on the Monopoly board. 
 * Each cell has a name, an owner (if applicable), and an availability status.
 * Subclasses of Cell will implement specific behaviors for different types of cells.
 */
public abstract class Cell {
	private boolean available = true;
	private String name;
	protected Player theOwner;

	/**
	 * Returns the name of this cell.
	 * @return The name of the cell.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the player who owns this cell.
	 * @return The owner of the cell, or null if none.
	 */
	public Player getTheOwner() {
		return theOwner;
	}
	
	/**
	 * Returns the price of this cell, defaulting to 0.
	 * @return The price of the cell.
	 */
	public int getPrice() {
		return 0;
	}

	/**
	 * Indicates whether this cell is currently available.
	 * @return True if the cell is available, false otherwise.
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Performs the action triggered when a player lands on this cell.
	 */
	public abstract void playAction();

	/**
	 * Sets the availability status of this cell.
	 * @param available The new availability state to set.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Sets the name of this cell.
	 * @param name The new name to assign to the cell.
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Assigns the owner of this cell.
	 * @param owner The player to set as the owner of the cell.
	 */
	public void setTheOwner(Player owner) {
		this.theOwner = owner;
	}
    
    /**
     * Returns a string representation of this cell.
     * @return The name of the cell as its string representation.
     */
    public String toString() {
        return name;
    }
}
