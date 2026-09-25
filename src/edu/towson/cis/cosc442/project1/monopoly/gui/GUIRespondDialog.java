package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.towson.cis.cosc442.project1.monopoly.RespondDialog;
import edu.towson.cis.cosc442.project1.monopoly.TradeDeal;

/**
 * GUIRespondDialog is a modal dialog that prompts the user for a Yes or No response regarding a trade deal in the Monopoly game.
 * It implements the RespondDialog interface and provides methods to set the trade deal message and retrieve the user's response.
 */
public class GUIRespondDialog extends JDialog implements RespondDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean response;
    JTextArea txtMessage = new JTextArea();
    
    /**
     * Constructs a modal dialog with Yes and No buttons and a message display area for user response.
     */
    public GUIRespondDialog() {
        JButton btnYes = new JButton("Yes");
        JButton btnNo = new JButton("No");
        txtMessage.setPreferredSize(new Dimension(300, 200));
        txtMessage.setEditable(false);
        txtMessage.setLineWrap(true);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(txtMessage, BorderLayout.CENTER);
        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnYes);
        pnlButtons.add(btnNo);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
        
        btnYes.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			/**
			 * Handles the No button click action by setting the response to false and hiding the dialog.
			 * @param e the event triggered by clicking the No button
			 */
			public void actionPerformed(ActionEvent e) {
                response = true;
                hide();
            }
        });

        btnNo.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			/**
			 * Handles the No button click action by setting the response to false and hiding the dialog.
			 * @param e the event triggered by clicking the No button
			 */
			public void actionPerformed(ActionEvent e) {
                response = false;
                hide();
            }
        });
    
        setModal(true);
        pack();
    }

    /**
     * Returns the boolean response indicating the user's choice from the dialog.
     * @return true if the user clicked Yes, false if No
     */
    public boolean getResponse() {
        return response;
    }
    
    /**
     * Sets the trade deal message to be displayed in the dialog.
     * @param deal the TradeDeal object whose message is to be shown
     */
    public void setDeal(TradeDeal deal) {
        txtMessage.setText(deal.makeMessage());
    }

}
