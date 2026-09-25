package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

/**
 * GUICell is a JPanel that represents a cell on the Monopoly game board in the GUI.
 * It displays information about the cell, including its name and any players currently on it.
 * The panel uses an OverlayLayout to layer player labels and cell information for visual clarity.
 */
public class GUICell extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private Cell cell;
	private JLabel lblInfo;
	private JLabel[] lblPlayers = new JLabel[GameMaster.MAX_PLAYER];
	
    /**
     * Constructs a GUICell component representing the given board cell with player labels and info display.
     * @param cell the Cell object to represent in the GUI
     */
    public GUICell(Cell cell) {
        this.cell = cell;
        setLayout(new OverlayLayout(this));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel pnlPlayer = new JPanel();
        pnlPlayer.setLayout(new GridLayout(2, 4));
        pnlPlayer.setOpaque(false);
        createPlayerLabels(pnlPlayer);
        add(pnlPlayer);
        setPreferredSize(new Dimension(100,100));
        addCellInfo();
        this.doLayout();
	}
	
	/**
	 * Adds and initializes the cell information label to the GUI component.
	 */
	private void addCellInfo() {
        lblInfo = new JLabel();
		displayInfo();
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(1, 1));
        pnlInfo.add(lblInfo);
        add(pnlInfo);
    }
	
	/**
	 * Adds a player's initial to the corresponding player label in the GUI based on the player's index.
	 * @param index the index of the player to add
	 */
	public void addPlayer(int index) {
		Player player = GameMaster.instance().getPlayer(index);
		lblPlayers[index].setText(player.getName().substring(0, 1));
		lblPlayers[index].setOpaque(true);
	}

    /**
     * Creates and adds player labels to the given panel for displaying player presence on the cell.
     * @param pnlPlayer the JPanel to add player labels to
     */
    private void createPlayerLabels(JPanel pnlPlayer) {
		for (int i = 0; i < GameMaster.MAX_PLAYER; i++) {
			lblPlayers[i] = new JLabel();
			lblPlayers[i].setBackground(Color.GREEN);
			pnlPlayer.add(lblPlayers[i]);
		}
	}

	/**
	 * Updates the cell information label text with the current cell data and repaints the component.
	 */
	public void displayInfo() {
		lblInfo.setText(InfoFormatter.cellInfo(cell));
        this.invalidate();
		this.repaint();
	}

	/**
	 * Returns the Cell object associated with this GUI cell component.
	 * @return the Cell represented by this GUI component
	 */
	public Cell getCell() {
		return cell;
	}
	
	/**
	 * Removes a player's initial from the player label at the specified index and updates the display.
	 * @param index the index of the player to remove
	 */
	public void removePlayer(int index) {
		lblPlayers[index].setText("");
		lblPlayers[index].setOpaque(false);
        this.repaint();
	}
}
