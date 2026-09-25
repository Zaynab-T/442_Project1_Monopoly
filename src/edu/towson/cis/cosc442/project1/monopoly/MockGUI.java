package edu.towson.cis.cosc442.project1.monopoly;

/**
 * MockGUI is a mock implementation of the MonopolyGUI interface for testing purposes.
 * It simulates the behavior of a graphical user interface without requiring an actual GUI.
 * This class allows for testing game logic and interactions without relying on a visual interface.
 */
public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState, btnEndTurnState, btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    /**
     * Enables the End Turn button for the specified player index.
     * @param playerIndex the index of the player for whom to enable the button
     */
    public void enableEndTurnBtn(int playerIndex) {
    }

    /**
     * Enables the UI elements to indicate that it is the specified player's turn.
     * @param playerIndex the index of the current player
     */
    public void enablePlayerTurn(int playerIndex) {
    }

    /**
     * Enables the purchase button for the specified player index.
     * @param playerIndex the index of the player for whom to enable the purchase button
     */
    public void enablePurchaseBtn(int playerIndex) {
    }
	/**
	 * Returns an array representing the values of the two dice rolled.
	 * @return an integer array of length two containing the dice roll values
	 */
	public int[] getDiceRoll() {
		int roll[] = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    /**
     * Checks whether the Draw Card button is currently enabled.
     * @return true if the Draw Card button is enabled, false otherwise
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    /**
     * Checks whether the End Turn button is currently enabled.
     * @return true if the End Turn button is enabled, false otherwise
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	/**
	 * Checks whether the Get Out of Jail button is currently enabled.
	 * @return true if the Get Out of Jail button is enabled, false otherwise
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    /**
     * Checks whether the Trade button for a given index is currently enabled.
     * @param i the index of the Trade button to check
     * @return true if the Trade button at the specified index is enabled, false otherwise
     */
    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    /**
     * Moves a player from one board position to another.
     * @param index the index of the player to move
     * @param from the starting position on the board
     * @param to the destination position on the board
     */
    public void movePlayer(int index, int from, int to) {
    }

    /**
     * Opens a dialog for responding to a trade deal and returns it.
     * @param deal the trade deal to respond to
     * @return a RespondDialog instance for the given trade deal
     */
    public RespondDialog openRespondDialog(TradeDeal deal) {
        RespondDialog dialog = new MockRespondDialog(deal);
        return dialog;
    }

    /**
     * Opens a dialog to initiate a trade between players and returns it.
     * @return a TradeDialog instance
     */
    public TradeDialog openTradeDialog() {
        TradeDialog dialog = new MockTradeDialog();
        return dialog;
    }

    /**
     * Enables or disables the option to buy a house.
     * @param b true to enable buying houses, false to disable
     */
    public void setBuyHouseEnabled(boolean b) {
    }

    /**
     * Enables or disables the Draw Card button.
     * @param b true to enable the Draw Card button, false to disable
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    /**
     * Enables or disables the End Turn button.
     * @param enabled true to enable the End Turn button, false to disable
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    /**
     * Enables or disables the Get Out of Jail button.
     * @param b true to enable the button, false to disable
     */
    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    /**
     * Enables or disables the purchase property button.
     * @param enabled true to enable property purchase, false to disable
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
    }

    /**
     * Enables or disables the Roll Dice button.
     * @param b true to enable the Roll Dice button, false to disable
     */
    public void setRollDiceEnabled(boolean b) {
    }

    /**
     * Enables or disables a Trade button at a given index.
     * @param index the index of the Trade button to enable or disable
     * @param b true to enable the button, false to disable
     */
    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    /**
     * Displays the dialog to buy a house for the specified player.
     * @param currentPlayer the player attempting to buy a house
     */
    public void showBuyHouseDialog(Player currentPlayer) {
    }

    /**
     * Displays a message to the user.
     * @param string the message text to display
     */
    public void showMessage(String string) {
    }

	/**
	 * Shows the dice roll value for a utility and returns the total roll.
	 * @return the sum of the dice values rolled for the utility
	 */
	public int showUtilDiceRoll() {
//		int[] diceValues = GameMaster.instance().rollDice();
//		return diceValues[0] + diceValues[1];
		return 10;
	}

    /**
     * Starts the game and initializes the GUI state.
     */
    public void startGame() {
    }

	/**
	 * Updates the GUI state to reflect any changes.
	 */
	public void update() {
	}
}
