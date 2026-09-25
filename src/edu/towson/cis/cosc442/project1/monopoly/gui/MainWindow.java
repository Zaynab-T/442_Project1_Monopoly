package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

/**
 * MainWindow is the primary JFrame for the Monopoly game GUI, responsible for displaying the game board, player information, and handling user interactions.
 * It implements the MonopolyGUI interface to provide methods for enabling/disabling buttons, moving players, and displaying dialogs.
 */
public class MainWindow extends JFrame implements MonopolyGUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel eastPanel = new JPanel();
	ArrayList<GUICell> guiCells = new ArrayList<GUICell>();

	JPanel northPanel = new JPanel();
	PlayerPanel[] playerPanels;
	JPanel southPanel = new JPanel();
	JPanel westPanel = new JPanel();

	/**
	 * Constructs the main window for the Monopoly game GUI, initializing and arranging panels and setting up window close behavior.
	 */
	public MainWindow() {
		northPanel.setBorder(new LineBorder(Color.BLACK));
		southPanel.setBorder(new LineBorder(Color.BLACK));
		westPanel.setBorder(new LineBorder(Color.BLACK));
		eastPanel.setBorder(new LineBorder(Color.BLACK));
		
		Container c = getContentPane();
		//setSize(800, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d);
		c.add(northPanel, BorderLayout.NORTH);
		c.add(southPanel, BorderLayout.SOUTH);
		c.add(eastPanel, BorderLayout.EAST);
		c.add(westPanel, BorderLayout.WEST);
		
		this.addWindowListener(new WindowAdapter(){
			/**
			 * Handles the window closing event by terminating the application.
			 * @param e the WindowEvent triggered when the window is closing
			 */
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Adds GUI cells representing the game board cells to the specified panel and tracks them for display.
	 * @param panel the JPanel to which the GUI cells will be added
	 * @param cells the list of Cell objects to be represented as GUI cells
	 */
	private void addCells(JPanel panel, List<?> cells) {
		for(int x=0; x<cells.size(); x++) {
			GUICell cell = new GUICell((Cell)cells.get(x));
			panel.add(cell);
			guiCells.add(cell);
		}
	}
	
	/**
	 * Creates and displays the player panels for all players participating in the game.
	 */
	private void buildPlayerPanels() {
		GameMaster master = GameMaster.instance();
		JPanel infoPanel = new JPanel();
        int players = master.getNumberOfPlayers();
        infoPanel.setLayout(new GridLayout(2, (players+1)/2));
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		playerPanels = new PlayerPanel[master.getNumberOfPlayers()];
		for (int i = 0; i< master.getNumberOfPlayers(); i++){
			playerPanels[i] = new PlayerPanel(master.getPlayer(i));
			infoPanel.add(playerPanels[i]);
			playerPanels[i].displayInfo();
		}
	}

	/**
	 * Enables the 'End Turn' button for the specified player.
	 * @param playerIndex the index of the player whose button is to be enabled
	 */
	public void enableEndTurnBtn(int playerIndex) {
		playerPanels[playerIndex].setEndTurnEnabled(true);
	}
	
	/**
	 * Enables the 'Roll Dice' button to indicate it is the specified player's turn.
	 * @param playerIndex the index of the player to enable for rolling dice
	 */
	public void enablePlayerTurn(int playerIndex) {
		playerPanels[playerIndex].setRollDiceEnabled(true);
		
	}

	/**
	 * Enables the purchase property button for the specified player.
	 * @param playerIndex the index of the player who can purchase a property
	 */
	public void enablePurchaseBtn(int playerIndex) {
		playerPanels[playerIndex].setPurchasePropertyEnabled(true);
	}

	@SuppressWarnings("deprecation")
	/**
	 * Displays a dialog to allow manual dice roll input and returns the resulting dice values.
	 * @return an array of integers representing the dice roll results
	 */
	public int[] getDiceRoll() {
		TestDiceRollDialog dialog = new TestDiceRollDialog(this);
		dialog.show();
		return dialog.getDiceRoll();
	}

    /**
     * Checks whether the 'Draw Card' button is enabled for the current player.
     * @return true if the draw card button is enabled, false otherwise
     */
    public boolean isDrawCardButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isDrawCardButtonEnabled();
    }

    /**
     * Checks whether the 'End Turn' button is enabled for the current player.
     * @return true if the end turn button is enabled, false otherwise
     */
    public boolean isEndTurnButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isEndTurnButtonEnabled();
    }

	/**
	 * Checks whether the 'Get Out of Jail' button is enabled for the current player.
	 * @return true if the get out of jail button is enabled, false otherwise
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
		return playerPanels[currentPlayerIndex].isGetOutOfJailButtonEnabled();
	}

    /**
     * Checks whether the 'Trade' button is enabled for the specified player.
     * @param i the index of the player to check
     * @return true if the trade button is enabled for the player, false otherwise
     */
    public boolean isTradeButtonEnabled(int i) {
        return playerPanels[i].isTradeButtonEnabled();
    }
	
	/**
	 * Moves a player from one board cell to another, updating the GUI to reflect the change.
	 * @param index the index of the player to move
	 * @param from the starting cell index
	 * @param to the destination cell index
	 */
	public void movePlayer(int index, int from, int to) {
		GUICell fromCell = queryCell(from);
		GUICell toCell = queryCell(to);
		fromCell.removePlayer(index);
		toCell.addPlayer(index);
	}

    @SuppressWarnings("deprecation")
	/**
	 * Opens a dialog to allow a player to respond to a trade deal and returns the dialog instance.
	 * @param deal the TradeDeal object representing the proposed trade
	 * @return the RespondDialog instance for the trade response
	 */
	public RespondDialog openRespondDialog(TradeDeal deal) {
        GUIRespondDialog dialog = new GUIRespondDialog();
        dialog.setDeal(deal);
        dialog.show();
        return dialog;
    }

    @SuppressWarnings("deprecation")
	/**
	 * Opens a dialog for initiating a trade between players and returns the dialog instance.
	 * @return the TradeDialog instance for making trades
	 */
	public TradeDialog openTradeDialog() {
        GUITradeDialog dialog = new GUITradeDialog(this);
        dialog.show();
        return dialog;
    }
	
	/**
	 * Retrieves the GUI cell that corresponds to the specified board cell index.
	 * @param index the index of the cell on the game board
	 * @return the GUICell associated with the specified index
	 */
	private GUICell queryCell(int index) {
		Cell cell = GameMaster.instance().getGameBoard().getCell(index);
		for(int x = 0; x < guiCells.size(); x++) {
			GUICell guiCell = (GUICell)guiCells.get(x);
			if(guiCell.getCell() == cell) return guiCell;
		}
		return null;
	}

    /**
     * Enables or disables the 'Buy House' button for the current player.
     * @param b true to enable, false to disable the button
     */
    public void setBuyHouseEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setBuyHouseEnabled(b);
    }

    /**
     * Enables or disables the 'Draw Card' button for the current player.
     * @param b true to enable, false to disable the button
     */
    public void setDrawCardEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setDrawCardEnabled(b);
    }

    /**
     * Enables or disables the 'End Turn' button for the current player.
     * @param enabled true to enable, false to disable the button
     */
    public void setEndTurnEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setEndTurnEnabled(enabled);
    }

    /**
     * Enables or disables the 'Get Out of Jail' button for the current player.
     * @param b true to enable, false to disable the button
     */
    public void setGetOutOfJailEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setGetOutOfJailEnabled(b);
    }

    /**
     * Enables or disables the property purchase button for the current player.
     * @param enabled true to enable, false to disable the button
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setPurchasePropertyEnabled(enabled);
    }

    /**
     * Enables or disables the 'Roll Dice' button for the current player.
     * @param b true to enable, false to disable the button
     */
    public void setRollDiceEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setRollDiceEnabled(b);
    }

    /**
     * Enables or disables the 'Trade' button for the specified player.
     * @param index the index of the player whose trade button to set
     * @param b true to enable, false to disable the button
     */
    public void setTradeEnabled(int index, boolean b) {
        playerPanels[index].setTradeEnabled(b);
    }
	
	/**
	 * Configures the game board GUI layout and creates GUI cells based on the provided game board.
	 * @param board the GameBoard instance to display
	 */
	public void setupGameBoard(GameBoard board) {
		Dimension dimension = GameBoardUtil.calculateDimension(board.getCellNumber());
		northPanel.setLayout(new GridLayout(1, dimension.width + 2));
		southPanel.setLayout(new GridLayout(1, dimension.width + 2));
		westPanel.setLayout(new GridLayout(dimension.height, 1));
		eastPanel.setLayout(new GridLayout(dimension.height, 1));
		addCells(northPanel, GameBoardUtil.getNorthCells(board));
		addCells(southPanel, GameBoardUtil.getSouthCells(board));
		addCells(eastPanel, GameBoardUtil.getEastCells(board));
		addCells(westPanel, GameBoardUtil.getWestCells(board));
		buildPlayerPanels();
	}

    @SuppressWarnings("deprecation")
	/**
	 * Displays a dialog allowing the specified player to purchase houses on properties.
	 * @param currentPlayer the Player who may buy houses
	 */
	public void showBuyHouseDialog(Player currentPlayer) {
        BuyHouseDialog dialog = new BuyHouseDialog(currentPlayer);
        dialog.show();
    }

    /**
     * Displays a message dialog with the specified message string.
     * @param msg the message to display
     */
    public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
    }

	/**
	 * Shows a dialog to roll utility dice and returns the result.
	 * @return an integer representing the utility dice roll result
	 */
	public int showUtilDiceRoll() {
		return UtilDiceRoll.showDialog();
	}

	/**
	 * Starts the game by initializing all players' positions on the board.
	 */
	public void startGame() {
		int numberOfPlayers = GameMaster.instance().getNumberOfPlayers();
		for(int i = 0; i < numberOfPlayers; i++) {
			movePlayer(i, 0, 0);
		}
	}

	/**
	 * Refreshes the display information for all player panels and board cells.
	 */
	public void update() {
		for(int i = 0; i < playerPanels.length; i++) {
			playerPanels[i].displayInfo();
		}
		for(int j = 0; j < guiCells.size(); j++ ) {
			GUICell cell = (GUICell)guiCells.get(j);
			cell.displayInfo();
		}
	}
}
