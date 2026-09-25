package edu.towson.cis.cosc442.project1.monopoly;

/**
 * The Card class serves as an abstract representation of a card in the Monopoly game, providing a framework for specific card types such as Chance and Community Chest cards.
 * It defines essential methods that must be implemented by subclasses to specify the card's label, action, and type.
 */
public abstract class Card {

    public static int TYPE_CHANCE = 1;
    public static int TYPE_CC = 2;

    /**
     * Returns the textual label identifying this card.
     * @return The label of the card as a String.
     */
    public abstract String getLabel();
    /**
     * Executes the action associated with this card.
     */
    public abstract void applyAction();
    /**
     * Retrieves the type identifier of this card.
     * @return An integer representing the card type, such as TYPE_CHANCE or TYPE_CC.
     */
    public abstract int getCardType();
}
