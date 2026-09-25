package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * FreeParkingCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for Free Parking cells in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the free parking cell's label for display in the game's user interface.
 */
public class FreeParkingCellInfoFormatter implements CellInfoFormatter {
    
    public static final String FP_CELL_LABEL = "<html><b>Free Parking</b></html>";
    
    /**
     * Returns a formatted string label representing a Free Parking cell, ignoring the input cell's details.
     * @param cell The cell to be formatted (not used in this implementation).
     * @return A formatted HTML string label for the Free Parking cell.
     */
    public String format(Cell cell) {
        return FP_CELL_LABEL;
    }
}
