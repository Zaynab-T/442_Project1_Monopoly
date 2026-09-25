package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;
import edu.towson.cis.cosc442.project1.monopoly.Player;
import edu.towson.cis.cosc442.project1.monopoly.PropertyCell;

/**
 * The PropertyCellInfoFormatter class implements the CellInfoFormatter interface to provide a formatted string representation of a PropertyCell's information.
 * It formats the cell's name, color, price, owner, and number of houses into an HTML string for display purposes in the Monopoly game GUI.
 */
public class PropertyCellInfoFormatter implements CellInfoFormatter {
    /**
     * Formats information about a property cell into an HTML string including its name, color, price, owner, and number of houses.
     * @param cell the property cell to format information for
     * @return an HTML formatted string representing the property's details
     */
    public String format(Cell cell) {
        PropertyCell c = (PropertyCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getTheOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='")
                .append(c.getColorGroup())
                .append("'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
				.append("<br>* ").append(c.getNumHouses())
                .append("</html>");
        return buf.toString();
    }
}
