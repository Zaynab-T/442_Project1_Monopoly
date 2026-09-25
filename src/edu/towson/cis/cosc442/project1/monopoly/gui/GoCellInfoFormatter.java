package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * GoCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for GoCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the Go cell's label for display in the game's user interface.
 */
public class GoCellInfoFormatter implements CellInfoFormatter {
    
    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";
    
    /**
     * Formats the given Cell as a HTML string representing the Go cell label.
     * @param cell the Cell object to format
     * @return a HTML formatted string label for the Go cell
     */
    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
}
