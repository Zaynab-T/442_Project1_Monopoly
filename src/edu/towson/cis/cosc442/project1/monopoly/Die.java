package edu.towson.cis.cosc442.project1.monopoly;

/**
 * The Die class represents a standard six-sided die used in the Monopoly game.
 * It provides a method to simulate rolling the die and obtaining a random result between 1 and 6.
 */
public class Die {
	/**
	 * Executes getRoll.
	 * @return the result
	 */
	public int getRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
