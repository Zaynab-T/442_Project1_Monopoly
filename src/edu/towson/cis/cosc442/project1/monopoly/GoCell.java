package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the 'Go' cell in the Monopoly game.
 * This class extends the Cell class and defines the behavior and properties of the 'Go' cell.
 * Players landing on this cell may receive a monetary bonus or other game benefits as defined by the game rules.
 */
public class GoCell extends Cell {
	/**
	 * Constructs a GoCell object representing the 'Go' cell and sets it as unavailable.
	 */
	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	/**
	 * Executes the action associated with landing on the 'Go' cell, which is currently empty.
	 */
	public void playAction() {
	}
	
	/**
	 * Overrides the name of the cell but is intentionally left empty to prevent changing the 'Go' cell's name.
	 * @param name The new name to set for the cell, which is ignored in this implementation.
	 */
	void setName(String name) {
	}
}
