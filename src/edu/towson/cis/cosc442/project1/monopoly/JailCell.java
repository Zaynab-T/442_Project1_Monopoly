package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the Jail cell in the Monopoly game.
 * This class extends the Cell class and defines the behavior and properties of the Jail cell.
 * Players landing on this cell may be subject to specific game rules, such as paying bail or being sent to jail.
 */
public class JailCell extends Cell {
	public static int BAIL = 50;
	
	/**
	 * Constructs a JailCell instance and sets its name to "Jail".
	 */
	public JailCell() {
		setName("Jail");
	}
	
	/**
	 * Performs the action associated with the Jail cell when a player lands on it, currently with no implemented behavior.
	 */
	public void playAction() {
		
	}
}
