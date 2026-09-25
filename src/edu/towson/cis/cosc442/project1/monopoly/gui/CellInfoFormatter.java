package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * CellInfoFormatter is an interface that defines a method for formatting information about a Cell object in a Monopoly game.
 * Implementing classes provide specific formatting logic for different types of cells, returning a string representation suitable for display in the game's user interface.
 */
public interface CellInfoFormatter {
    /**
     * Formats the given Cell object into a string representation.
     * @param cell the Cell object to format
     * @return a string representing the formatted Cell information
     */
    public String format(Cell cell);
}
