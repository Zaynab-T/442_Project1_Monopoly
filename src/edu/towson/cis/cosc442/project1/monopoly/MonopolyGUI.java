package edu.towson.cis.cosc442.project1.monopoly;
/**
 * MonopolyGUI is an interface that defines the methods required for the graphical user interface of a Monopoly game.
 * It provides methods for enabling/disabling buttons, moving players, displaying dialogs, and updating the game state visually.
 */
public interface MonopolyGUI {
	/**
	 * Enables or activates the End Turn button for the specified player index.
	 * @param playerIndex the index of the player for whom to enable the End Turn button
	 */
	public void enableEndTurnBtn(int playerIndex);
	/**
	 * Enables UI elements and visual indicators for the specified player's turn.
	 * @param playerIndex the index of the player whose turn is being enabled
	 */
	public void enablePlayerTurn(int playerIndex);
	/**
	 * Enables or activates the Purchase button for the specified player index.
	 * @param playerIndex the index of the player who can activate the Purchase button
	 */
	public void enablePurchaseBtn(int playerIndex);
	/**
	 * Returns the current dice roll as an array of integers.
	 * @return an array containing the values of the dice rolled
	 */
	public int[] getDiceRoll();
    /**
     * Checks if the Draw Card button is currently enabled.
     * @return true if the Draw Card button is enabled; false otherwise
     */
    public boolean isDrawCardButtonEnabled();
    /**
     * Checks if the End Turn button is currently enabled.
     * @return true if the End Turn button is enabled; false otherwise
     */
    public boolean isEndTurnButtonEnabled();
	/**
	 * Checks if the Get Out of Jail button is currently enabled.
	 * @return true if the Get Out of Jail button is enabled; false otherwise
	 */
	public boolean isGetOutOfJailButtonEnabled();
    /**
     * Determines if the Trade button is enabled for a specific player index.
     * @param i the index of the player to check the Trade button state
     * @return true if the Trade button is enabled for the player; false otherwise
     */
    public boolean isTradeButtonEnabled(int i);
	/**
	 * Animates or updates the player's movement from a starting position to a new position on the board.
	 * @param index the index of the player to move
	 * @param from the current position index of the player
	 * @param to the destination position index to move the player to
	 */
	public void movePlayer(int index, int from, int to);
    /**
     * Opens a dialog allowing the player to respond to a trade deal.
     * @param deal the trade deal to respond to
     * @return a RespondDialog object that manages the response interaction
     */
    public RespondDialog openRespondDialog(TradeDeal deal);
    /**
     * Opens the trade dialog for initiating a trade between players.
     * @return a TradeDialog object used to create or manage a trade
     */
    public TradeDialog openTradeDialog();
    /**
     * Enables or disables the option to buy houses in the GUI.
     * @param b true to enable buying houses; false to disable
     */
    public void setBuyHouseEnabled(boolean b);
    /**
     * Enables or disables the Draw Card button in the GUI.
     * @param b true to enable the Draw Card button; false to disable
     */
    public void setDrawCardEnabled(boolean b);
    /**
     * Enables or disables the End Turn button in the GUI.
     * @param enabled true to enable the End Turn button; false to disable
     */
    public void setEndTurnEnabled(boolean enabled);
    /**
     * Enables or disables the Get Out of Jail button in the GUI.
     * @param b true to enable the Get Out of Jail button; false to disable
     */
    public void setGetOutOfJailEnabled(boolean b);
    /**
     * Enables or disables the Purchase Property button in the GUI.
     * @param enabled true to enable property purchase; false to disable
     */
    public void setPurchasePropertyEnabled(boolean enabled);
    /**
     * Enables or disables the Roll Dice button in the GUI.
     * @param b true to enable the Roll Dice button; false to disable
     */
    public void setRollDiceEnabled(boolean b);
    /**
     * Enables or disables the Trade button for a specified player.
     * @param index the index of the player whose Trade button state is being set
     * @param b true to enable the Trade button; false to disable
     */
    public void setTradeEnabled(int index, boolean b);
    /**
     * Displays the dialog prompting the specified player to buy houses.
     * @param currentPlayer the player who is being prompted to buy houses
     */
    public void showBuyHouseDialog(Player currentPlayer);
    /**
     * Displays a message to the user in the GUI.
     * @param string the message text to show
     */
    public void showMessage(String string);
	/**
	 * Displays the dice roll specifically used for utility properties and returns the roll value.
	 * @return the integer value of the utility dice roll displayed
	 */
	public int showUtilDiceRoll();
	/**
	 * Initializes and starts the Monopoly game GUI and related components.
	 */
	public void startGame();
	/**
	 * Refreshes or updates the GUI to reflect the current game state.
	 */
	public void update();
}
