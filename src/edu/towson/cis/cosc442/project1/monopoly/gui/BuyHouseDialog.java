
package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.towson.cis.cosc442.project1.monopoly.Player;

/**
 * BuyHouseDialog is a modal dialog that allows players to purchase houses for their monopolies in the Monopoly game.
 * It provides a user interface for selecting a monopoly and the number of houses to buy.
 */
public class BuyHouseDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<?> cboMonopoly;
	private JComboBox<?> cboNumber;

	private Player player;

	/**
	 * Constructs the buy house dialog for the specified player, initializing and laying out GUI components.
	 * @param player the player who can purchase houses using this dialog
	 */
	public BuyHouseDialog(Player player) {
		this.player = player;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Select monopoly"));
		c.add(buildMonopolyComboBox());
		c.add(new JLabel("Number of houses"));
		c.add(buildNumberComboBox());
		c.add(buildOKButton());
		c.add(buildCancelButton());
		c.doLayout();
		this.pack();
	}

	/**
	 * Creates and returns the cancel button for the dialog with its action listener.
	 * @return the constructed cancel JButton
	 */
	private JButton buildCancelButton() {
		JButton btn = new JButton("Cancel");
		btn.addActionListener(new ActionListener(){
			/**
			 * Handles the action event triggered by the OK button by invoking okClicked.
			 * @param e the action event triggered by button press
			 */
			public void actionPerformed(ActionEvent e) {
				cancelClicked();
			}
		});
		return btn;
	}

	/**
	 * Constructs and returns a combo box allowing selection of the player's monopolies.
	 * @return the constructed JComboBox listing player's monopolies
	 */
	private JComboBox<?> buildMonopolyComboBox() {
		cboMonopoly = new JComboBox<Object>(player.getMonopolies());
		return cboMonopoly;
	}
	
	/**
	 * Constructs and returns a combo box to select the number of houses to purchase (1-5).
	 * @return the constructed JComboBox listing numbers 1 through 5
	 */
	private JComboBox<?> buildNumberComboBox() {
		cboNumber = new JComboBox<Object>(new Integer[]{
				new Integer(1),
				new Integer(2),
				new Integer(3),
				new Integer(4),
				new Integer(5)});
		return cboNumber;
	}

	/**
	 * Creates and returns the OK button for the dialog with its action listener.
	 * @return the constructed OK JButton
	 */
	private JButton buildOKButton() {
		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener(){
			/**
			 * Handles the action event triggered by the OK button by invoking okClicked.
			 * @param e the action event triggered by button press
			 */
			public void actionPerformed(ActionEvent e) {
				okClicked();
			}
		});
		return btn;
	}
	
	/**
	 * Closes the dialog without making any changes.
	 */
	private void cancelClicked() {
		this.dispose();
	}
	
	/**
	 * Processes the selected monopoly and number of houses, instructing the player to purchase them, then closes the dialog.
	 */
	private void okClicked() {
		String monopoly = (String)cboMonopoly.getSelectedItem();
		int number = cboNumber.getSelectedIndex() + 1;
		player.purchaseHouse(monopoly, number);
		this.dispose();
	}
}
