package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a card in the Monopoly game that sends a player directly to jail.
 * This class extends the abstract Card class and implements the action of sending the player to jail when applied.
 */
public class JailCard extends Card {
    int type;
    
    /**
     * Constructs a JailCard with a specific card type identifier.
     * @param cardType the identifier representing the type of this jail card
     */
    public JailCard(int cardType) {
        type = cardType;
    }

    /**
     * Applies the jail card action by sending the current player directly to jail.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
    }

    /**
     * Retrieves the type identifier of this jail card.
     * @return the integer representing the card's type
     */
    public int getCardType() {
        return type;
    }

    /**
     * Gets the descriptive label for the jail card's effect.
     * @return a String label explaining the jail card's action
     */
    public String getLabel() {
        return "Go to Jail immediately without collecting" +
        		" $200 when passing the GO cell";
    }
}
