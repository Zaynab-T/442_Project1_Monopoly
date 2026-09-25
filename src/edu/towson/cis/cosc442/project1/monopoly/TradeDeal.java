package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a trade deal between two players in the Monopoly game.
 * This class encapsulates the details of a trade offer, including the amount of money offered,
 * the index of the player selling the property, and the name of the property being traded.
 */
public class TradeDeal {
    private int amount;
    private int playerIndex;
    private String propertyName;

    /**
     * Returns the amount of money offered in the trade deal.
     * @return The monetary amount of the trade offer.
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * Returns the index of the player who is selling the property.
     * @return The player index of the seller.
     */
    public int getPlayerIndex() {
        return playerIndex;
    }
    
    /**
     * Returns the name of the property involved in the trade deal.
     * @return The property name.
     */
    public String getPropertyName() {
        return propertyName;
    }
    
    /**
     * Creates a message describing the trade offer from the current player to the seller.
     * @return A string message detailing the trade proposal.
     */
    public String makeMessage() {
        return GameMaster.instance().getCurrentPlayer() + 
        	" wishes to purchase " +
        	propertyName + " from " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	" for " + amount + ".  " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	", do you wish to trade your property?";
    }
    
    /**
     * Sets the amount of money offered in the trade deal.
     * @param amount The monetary amount to offer in the trade.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /**
     * Sets the property name involved in the trade deal.
     * @param propertyName The name of the property to be traded.
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /**
     * Sets the index of the player who is selling the property.
     * @param playerIndex The player index to designate as the seller.
     */
    public void setSellerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
