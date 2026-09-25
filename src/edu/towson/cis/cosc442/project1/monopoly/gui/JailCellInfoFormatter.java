package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

/**
 * JailCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for JailCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that represents the jail cell's label for display in the game's user interface.
 */
public class JailCellInfoFormatter implements CellInfoFormatter {

    public static final String JAIL_CELL_LABEL = "<html><b>Jail</b></html>";

    /**
     * Returns a formatted HTML label representing the jail cell information.
     * @param cell the Cell object to be formatted
     * @return a string containing the HTML-formatted label for the jail cell
     */
    public String format(Cell cell) {
		return JAIL_CELL_LABEL;
	}

}
