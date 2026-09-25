package edu.towson.cis.cosc442.project1.monopoly;

/**
 * The CardCell class represents a cell on the Monopoly game board that is associated with a card type, such as Chance or Community Chest.
 * It extends the Cell class and provides functionality to store and retrieve the type of card associated with the cell.
 */
public class CardCell extends Cell {
    private int type;
    
    /**
     * Constructs a CardCell with the specified type and name.
     * @param type the type identifier of the card cell
     * @param name the name of the card cell
     */
    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    /**
     * Executes the action associated with the card cell when activated.
     */
    public void playAction() {
    }
    
    /**
     * Retrieves the card cell's type identifier.
     * @return the type of the card cell as an integer
     */
    public int getType() {
        return type;
    }
}
