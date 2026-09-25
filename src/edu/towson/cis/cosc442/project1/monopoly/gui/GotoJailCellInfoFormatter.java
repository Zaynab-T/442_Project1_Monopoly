package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * GotoJailCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for GotoJailCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the 'Go to Jail' cell's label for display in the game's user interface.
 */
public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    /**
     * Returns a formatted string representation for a 'Go to Jail' cell.
     * @param cell the Cell instance to be formatted
     * @return a HTML-formatted string label indicating 'Go to Jail'
     */
    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
	}
}
