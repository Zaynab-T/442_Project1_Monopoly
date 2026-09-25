package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import edu.towson.cis.cosc442.project1.monopoly.GameMaster;

/**
 * InfoPanel is a JPanel that displays information about all players in the Monopoly game.
 * It dynamically creates PlayerPanel instances for each player and arranges them in a grid layout.
 * The displayInfo method updates the panel with the current state of each player.
 */
public class InfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Executes displayInfo.
	 */
	public void displayInfo() {
		GameMaster master = GameMaster.instance();
		setLayout(new GridLayout(1, master.getNumberOfPlayers()));
		for (int i = 0; i< master.getNumberOfPlayers(); i++){
			PlayerPanel panel = new PlayerPanel(master.getPlayer(i));
			add(panel);
			panel.displayInfo();
		}
	}
}
