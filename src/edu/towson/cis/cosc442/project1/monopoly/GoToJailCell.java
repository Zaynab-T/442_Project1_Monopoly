package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the "Go to Jail" cell in the Monopoly game.
 * This class extends the Cell class and defines the behavior of sending a player to jail when they land on this cell.
 */
public class GoToJailCell extends Cell {
	
	/**
	 * Constructs a GoToJailCell and sets its name to "Go to Jail".
	 */
	public GoToJailCell() {
		setName("Go to Jail");
	}

	/**
	 * Executes the action of sending the current player to jail.
	 */
	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
	}
}
