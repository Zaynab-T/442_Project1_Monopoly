package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * CCCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for CCCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the cell's name in white bold font for display in the game's user interface.
 */
public class CCCellInfoFormatter implements CellInfoFormatter {
    /**
     * Formats the given Cell object's name as an HTML string with white bold font for display.
     * @param cell the Cell object whose name is to be formatted
     * @return an HTML string representation of the cell's name styled in white bold font
     */
    public String format(Cell cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
