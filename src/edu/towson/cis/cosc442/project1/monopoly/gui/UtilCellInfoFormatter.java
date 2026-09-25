package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;
import edu.towson.cis.cosc442.project1.monopoly.Player;
import edu.towson.cis.cosc442.project1.monopoly.UtilityCell;

/**
 * The UtilCellInfoFormatter class implements the CellInfoFormatter interface to provide a formatted string representation of a UtilityCell's information.
 * It formats the cell's name, price, and owner information into an HTML string for display purposes in the Monopoly game GUI.
 */
public class UtilCellInfoFormatter implements CellInfoFormatter {

	/**
	 * Formats the given cell's information into an HTML string for display purposes.
	 * @param cell the Cell object to format
	 * @return an HTML-formatted string representing the cell's name, price, and owner information
	 */
	public String format(Cell cell) {
        UtilityCell c = (UtilityCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getTheOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='olive'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
	}
}
