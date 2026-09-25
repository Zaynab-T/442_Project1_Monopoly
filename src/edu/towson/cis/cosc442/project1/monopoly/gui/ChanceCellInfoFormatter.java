package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * ChanceCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for ChanceCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the chance cell's label for display in the game's user interface.
 */
public class ChanceCellInfoFormatter implements CellInfoFormatter {
    
    public static final String CHANCE_CELL_LABEL = "<html><font color='teal'><b>Chance</b></font></html>";
    
    /**
     * Returns a formatted HTML string label representing a Chance cell for the given Cell object.
     * @param cell the Cell instance to format
     * @return a string containing the HTML formatted label for a Chance cell
     */
    public String format(Cell cell) {
        return CHANCE_CELL_LABEL;
    }
}
