package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;
import edu.towson.cis.cosc442.project1.monopoly.Player;
import edu.towson.cis.cosc442.project1.monopoly.RailRoadCell;

/**
 * RRCellInfoFormatter is a class that implements the CellInfoFormatter interface to format information for RailRoadCell objects in a Monopoly game.
 * It provides a method to generate an HTML-formatted string that includes the cell's name, price, and owner information for display in the game's user interface.
 */
public class RRCellInfoFormatter implements CellInfoFormatter {
    /**
     * Formats a RailRoadCell object's details into an HTML string for display.
     * @param cell the Cell object to format, expected to be a RailRoadCell
     * @return an HTML-formatted string representing the cell's name, price, and owner information
     */
    public String format(Cell cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getTheOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
