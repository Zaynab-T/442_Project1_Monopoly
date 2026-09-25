package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a card in the Monopoly game that adjusts a player's money by a specified amount.
 * This class extends the abstract Card class and implements the action of modifying the player's money when applied.
 */
public class MoneyCard extends Card {
    private int amount;
    private int cardType;
    
    private String label;
    
    /**
     * Constructs a MoneyCard with a specified label, amount, and card type.
     * @param label the label or name of the money card
     * @param amount the monetary amount associated with the card
     * @param cardType the specific type identifier of the card
     */
    public MoneyCard(String label, int amount, int cardType){
        this.label = label;
        this.amount = amount;
        this.cardType = cardType;
    }

    /**
     * Applies the card's action by adjusting the current player's money by the card's amount.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		currentPlayer.setMoney(currentPlayer.getMoney() + amount);
    }

    /**
     * Returns the type identifier of the money card.
     * @return the card type as an integer
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * Returns the label or name of the money card.
     * @return the card's label as a String
     */
    public String getLabel() {
        return label;
    }
}
