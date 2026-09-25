package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

/**
 * PlayerPanel is a JPanel that displays information about a specific player in the Monopoly game.
 * It includes buttons for player actions and labels to show the player's name, money, and owned properties.
 * The panel updates dynamically based on the player's current state in the game.
 */
public class PlayerPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnBuyHouse;
    private JButton btnDrawCard;
    private JButton btnEndTurn;
    private JButton btnGetOutOfJail;
    private JButton btnPurchaseProperty;
    private JButton btnRollDice;
    private JButton btnTrade;
    
    private JLabel lblMoney;
    private JLabel lblName;
    
    private Player player;
    
    private JTextArea txtProperty;

    /**
     * Constructs a PlayerPanel for the specified player with buttons and labels to interact with and display player information.
     * @param player The Player object whose information and actions this panel represents
     */
    public PlayerPanel(Player player) {
        JPanel pnlAction = new JPanel();
        JPanel pnlInfo = new JPanel();
        btnRollDice = new JButton("Roll Dice");
        btnPurchaseProperty = new JButton("Purchase Property");
        btnEndTurn = new JButton("End Turn");
        btnBuyHouse = new JButton("Buy House");
        btnGetOutOfJail = new JButton("Get Out of Jail");
        btnDrawCard = new JButton("Draw Card");
        btnTrade = new JButton("Trade");
        this.player = player;
        lblName = new JLabel();
        lblMoney = new JLabel();
        txtProperty = new JTextArea(30, 70);

        txtProperty.setEnabled(false);

        JPanel pnlName = new JPanel();
        JPanel pnlProperties = new JPanel();

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.add(pnlName, BorderLayout.NORTH);
        pnlInfo.add(pnlProperties, BorderLayout.CENTER);

        pnlProperties.setLayout(new OverlayLayout(pnlProperties));

        pnlName.add(lblName);
        pnlName.add(lblMoney);
        pnlProperties.add(txtProperty);

        pnlAction.setLayout(new GridLayout(3, 3));
        pnlAction.add(btnBuyHouse);
        pnlAction.add(btnRollDice);
        pnlAction.add(btnPurchaseProperty);
        pnlAction.add(btnGetOutOfJail);
        pnlAction.add(btnEndTurn);
        pnlAction.add(btnDrawCard);
        pnlAction.add(btnTrade);

        pnlAction.doLayout();
        pnlInfo.doLayout();
        pnlName.doLayout();
        pnlProperties.doLayout();
        this.doLayout();

        setLayout(new BorderLayout());
        add(pnlInfo, BorderLayout.CENTER);
        add(pnlAction, BorderLayout.SOUTH);

        btnRollDice.setEnabled(false);
        btnPurchaseProperty.setEnabled(false);
        btnEndTurn.setEnabled(false);
        btnBuyHouse.setEnabled(false);
        btnGetOutOfJail.setEnabled(false);
        btnDrawCard.setEnabled(false);
        btnTrade.setEnabled(false);

        setBorder(new BevelBorder(BevelBorder.RAISED));

        btnRollDice.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnRollDiceClicked();
            }
        });

        btnEndTurn.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnEndTurnClicked();
            }
        });

        btnPurchaseProperty.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnPurchasePropertyClicked();
            }
        });

        btnBuyHouse.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnBuyHouseClicked();
            }
        });

        btnGetOutOfJail.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnGetOutOfJailClicked();
            }
        });

        btnDrawCard.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                Card card = GameMaster.instance().btnDrawCardClicked();
                JOptionPane
                        .showMessageDialog(PlayerPanel.this, card.getLabel());
                displayInfo();
            }
        });

        btnTrade.addActionListener(new ActionListener() {
            /**
             * Handles the trade button click by delegating to the GameMaster instance.
             * @param e The ActionEvent triggered by clicking the trade button
             */
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnTradeClicked();
            }
        });
    }

    /**
     * Updates the panel to show the current player's name, money, and owned properties.
     */
    public void displayInfo() {
        lblName.setText(player.getName());
        lblMoney.setText("$ " + player.getMoney());
        StringBuffer buf = new StringBuffer();
        Cell[] cells = player.getAllProperties();
        for (int i = 0; i < cells.length; i++) {
            buf.append(cells[i] + "\n");
        }
        txtProperty.setText(buf.toString());
    }
    
    /**
     * Returns whether the buy house button is currently enabled.
     * @return True if the buy house button is enabled; false otherwise.
     */
    public boolean isBuyHouseButtonEnabled() {
        return btnBuyHouse.isEnabled();
    }

    /**
     * Returns whether the draw card button is currently enabled.
     * @return True if the draw card button is enabled; false otherwise.
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCard.isEnabled();
    }

    /**
     * Returns whether the end turn button is currently enabled.
     * @return True if the end turn button is enabled; false otherwise.
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurn.isEnabled();
    }
    
    /**
     * Returns whether the get out of jail button is currently enabled.
     * @return True if the get out of jail button is enabled; false otherwise.
     */
    public boolean isGetOutOfJailButtonEnabled() {
        return btnGetOutOfJail.isEnabled();
    }
    
    /**
     * Returns whether the purchase property button is currently enabled.
     * @return True if the purchase property button is enabled; false otherwise.
     */
    public boolean isPurchasePropertyButtonEnabled() {
        return btnPurchaseProperty.isEnabled();
    }
    
    /**
     * Returns whether the roll dice button is currently enabled.
     * @return True if the roll dice button is enabled; false otherwise.
     */
    public boolean isRollDiceButtonEnabled() {
        return btnRollDice.isEnabled();
    }

    /**
     * Returns whether the trade button is currently enabled.
     * @return True if the trade button is enabled; false otherwise.
     */
    public boolean isTradeButtonEnabled() {
        return btnTrade.isEnabled();
    }

    /**
     * Enables or disables the buy house button.
     * @param b A boolean indicating whether the buy house button should be enabled
     */
    public void setBuyHouseEnabled(boolean b) {
        btnBuyHouse.setEnabled(b);
    }

    /**
     * Enables or disables the draw card button.
     * @param b A boolean indicating whether the draw card button should be enabled
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCard.setEnabled(b);
    }

    /**
     * Enables or disables the end turn button.
     * @param enabled A boolean indicating whether the end turn button should be enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurn.setEnabled(enabled);
    }

    /**
     * Enables or disables the get out of jail button.
     * @param b A boolean indicating whether the get out of jail button should be enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
        btnGetOutOfJail.setEnabled(b);
    }

    /**
     * Enables or disables the purchase property button.
     * @param enabled A boolean indicating whether the purchase property button should be enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        btnPurchaseProperty.setEnabled(enabled);
    }

    /**
     * Enables or disables the roll dice button.
     * @param enabled A boolean indicating whether the roll dice button should be enabled
     */
    public void setRollDiceEnabled(boolean enabled) {
        btnRollDice.setEnabled(enabled);
    }

    /**
     * Enables or disables the trade button.
     * @param b A boolean indicating whether the trade button should be enabled
     */
    public void setTradeEnabled(boolean b) {
        btnTrade.setEnabled(b);
    }
}