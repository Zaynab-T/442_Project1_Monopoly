package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * TestDiceRollDialog is a modal dialog that allows users to input a dice roll amount for testing purposes in a Monopoly game.
 * It provides a user interface with an input field for the amount and OK/Cancel buttons to confirm or cancel the input.
 */
public class TestDiceRollDialog extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnOK, btnCancel;
    private JTextField txtDiceRoll;
    private int[] diceRoll;
    
    /**
     * Constructs a modal dialog for inputting a dice roll amount with OK and Cancel buttons.
     * @param parent the parent frame for this dialog
     */
    public TestDiceRollDialog(Frame parent) {
        super(parent);
        
        setTitle("Dice Roll Dialog");
        txtDiceRoll = new JTextField(2);
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtDiceRoll);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			/**
			 * Validates and processes the input amount to set the dice roll and then hides the dialog when OK is pressed.
			 * @param e the action event triggered by clicking OK
			 */
			public void actionPerformed(ActionEvent e) {
                TestDiceRollDialog.this.hide();
                diceRoll = new int[2];
                diceRoll[0] = 0;
                diceRoll[1] = 0;
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			/**
			 * Validates and processes the input amount to set the dice roll and then hides the dialog when OK is pressed.
			 * @param e the action event triggered by clicking OK
			 */
			public void actionPerformed(ActionEvent e) {
                int amount = 0;
                try{
                    amount = Integer.parseInt(txtDiceRoll.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(TestDiceRollDialog.this,
                            "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(amount > 0) {
	                diceRoll = new int[2];
	                if((amount % 2) == 0) {
	                	diceRoll[0] = amount / 2;
	                	diceRoll[1] = amount / 2;
	                }
	                else {
	                	diceRoll[0] = amount / 2;
	                	diceRoll[1] = (amount / 2) + 1;
	                }
                }
                hide();
            }
        });
        
        this.pack();
    }

    /**
     * Returns the array representing the two dice roll values set by the dialog.
     * @return the two-element integer array of dice roll results
     */
    public int[] getDiceRoll() {
        return diceRoll;
    }
}
