package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Represents a player in the Monopoly game, managing their properties, money, position, and jail status.
 * This class provides methods for buying and selling properties, paying rent, and handling player actions.
 */
public class Player {
	//the key of colorGroups is the name of the color group.
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();
	private boolean inJail;
	private int money;
	private String name;

	private Cell position;
	private ArrayList<PropertyCell> properties = new ArrayList<PropertyCell>();
	private ArrayList<Cell> railroads = new ArrayList<Cell>();
	private ArrayList<Cell> utilities = new ArrayList<Cell>();
	
	/**
	 * Constructs a new Player positioned at the 'Go' cell and not in jail.
	 */
	public Player() {
		GameBoard gb = GameMaster.instance().getGameBoard();
		inJail = false;
		if(gb != null) {
			position = gb.queryCell("Go");
		}
	}

    /**
     * Assigns the property to the player, updates owned property collections, and deducts the purchase amount from the player's money.
     * @param property The property cell to be purchased and assigned to the player
     * @param amount The purchase price to deduct from the player's money
     */
    public void buyProperty(Cell property, int amount) {
        property.setTheOwner(this);
        if(property instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)property;
            properties.add(cell);
            colorGroups.put(
                    cell.getColorGroup(), 
                    new Integer(getPropertyNumberForColor(cell.getColorGroup())+1));
        }
        if(property instanceof RailRoadCell) {
            railroads.add(property);
            colorGroups.put(
                    RailRoadCell.COLOR_GROUP, 
                    new Integer(getPropertyNumberForColor(RailRoadCell.COLOR_GROUP)+1));
        }
        if(property instanceof UtilityCell) {
            utilities.add(property);
            colorGroups.put(
                    UtilityCell.COLOR_GROUP, 
                    new Integer(getPropertyNumberForColor(UtilityCell.COLOR_GROUP)+1));
        }
        setMoney(getMoney() - amount);
    }
	
	/**
	 * Checks if the player currently holds any monopolies allowing them to buy houses.
	 * @return true if the player has at least one monopoly; false otherwise
	 */
	public boolean canBuyHouse() {
		return (getMonopolies().length != 0);
	}

	/**
	 * Determines if the player owns a property with the given name.
	 * @param property The name of the property to check for ownership
	 * @return true if the player owns the property; false otherwise
	 */
	public boolean checkProperty(String property) {
		for(int i=0;i<properties.size();i++) {
			Cell cell = (Cell)properties.get(i);
			if(cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Transfers all properties owned by this player to the specified player or frees them if null, resetting availability and houses as needed.
	 * @param player The player to receive the properties, or null to release ownership
	 */
	public void exchangeProperty(Player player) {
		for(int i = 0; i < getPropertyNumber(); i++ ) {
			PropertyCell cell = getProperty(i);
			cell.setTheOwner(player);
			if(player == null) {
				cell.setAvailable(true);
				cell.setNumHouses(0);
			}
			else {
				player.properties.add(cell);
				colorGroups.put(
						cell.getColorGroup(), 
						new Integer(getPropertyNumberForColor(cell.getColorGroup())+1));
			}
		}
		properties.clear();
	}
    
    /**
     * Returns an array of all properties, utilities, and railroads currently owned by the player.
     * @return An array containing all cells owned by the player
     */
    public Cell[] getAllProperties() {
        ArrayList<Cell> list = new ArrayList<Cell>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return (Cell[])list.toArray(new Cell[list.size()]);
    }

	/**
	 * Retrieves the current amount of money the player has.
	 * @return The player's current money amount
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * Returns the color groups for which the player owns all properties, constituting monopolies.
	 * @return An array of monopoly color group names owned by the player
	 */
	public String[] getMonopolies() {
		ArrayList<String> monopolies = new ArrayList<String>();
		Enumeration<String> colors = colorGroups.keys();
		while(colors.hasMoreElements()) {
			String color = (String)colors.nextElement();
            if(!(color.equals(RailRoadCell.COLOR_GROUP)) && !(color.equals(UtilityCell.COLOR_GROUP))) {
    			Integer num = (Integer)colorGroups.get(color);
    			GameBoard gameBoard = GameMaster.instance().getGameBoard();
    			if(num.intValue() == gameBoard.getPropertyNumberForColor(color)) {
    				monopolies.add(color);
    			}
            }
		}
		return (String[])monopolies.toArray(new String[monopolies.size()]);
	}

	/**
	 * Returns the player's name.
	 * @return The name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Pays the bail to get the player out of jail, resets bankruptcy status if necessary, and updates the game GUI.
	 */
	public void getOutOfJail() {
		money -= JailCell.BAIL;
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(null);
		}
		inJail = false;
		GameMaster.instance().updateGUI();
	}

	/**
	 * Returns the current position cell of the player on the game board.
	 * @return The cell where the player is currently located
	 */
	public Cell getPosition() {
		return this.position;
	}
	
	/**
	 * Retrieves a property cell owned by the player at the specified index.
	 * @param index The index of the property to retrieve
	 * @return The PropertyCell at the given index
	 */
	public PropertyCell getProperty(int index) {
		return (PropertyCell)properties.get(index);
	}
	
	/**
	 * Returns the total number of properties owned by the player.
	 * @return The count of properties owned
	 */
	public int getPropertyNumber() {
		return properties.size();
	}

	/**
	 * Returns the number of properties owned by the player for the specified color group.
	 * @param name The name of the color group to count properties for
	 * @return The number of properties owned in the given color group
	 */
	private int getPropertyNumberForColor(String name) {
		Integer number = (Integer)colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Checks if the player is bankrupt, defined as having zero or less money.
	 * @return true if the player is bankrupt; false otherwise
	 */
	public boolean isBankrupt() {
		return money <= 0;
	}

	/**
	 * Determines if the player is currently in jail.
	 * @return true if the player is in jail; false otherwise
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * Returns the count of railroad properties owned by the player.
	 * @return The number of railroads owned
	 */
	public int numberOfRR() {
		return getPropertyNumberForColor(RailRoadCell.COLOR_GROUP);
	}

	/**
	 * Returns the count of utility properties owned by the player.
	 * @return The number of utilities owned
	 */
	public int numberOfUtil() {
		return getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
	}
	
	/**
	 * Pays rent to another player, adjusting money accordingly and handling bankruptcy by transferring properties.
	 * @param owner The player who owns the property to which rent is paid
	 * @param rentValue The amount of rent to pay
	 */
	public void payRentTo(Player owner, int rentValue) {
		if(money < rentValue) {
			owner.money += money;
			money -= rentValue;
		}
		else {
			money -= rentValue;
			owner.money +=rentValue;
		}
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(owner);
		}
	}
	
	/**
	 * Executes the purchase of the player's current position cell if it is available, assigning ownership and deducting money.
	 */
	public void purchase() {
		if(getPosition().isAvailable()) {
			Cell c = getPosition();
			c.setAvailable(false);
			if(c instanceof PropertyCell) {
				PropertyCell cell = (PropertyCell)c;
				purchaseProperty(cell);
			}
			if(c instanceof RailRoadCell) {
				RailRoadCell cell = (RailRoadCell)c;
				purchaseRailRoad(cell);
			}
			if(c instanceof UtilityCell) {
				UtilityCell cell = (UtilityCell)c;
				purchaseUtility(cell);
			}
		}
	}
	
	/**
	 * Purchases houses for all properties in the specified monopoly if the player has sufficient funds and limits are respected.
	 * @param selectedMonopoly The color group name of the monopoly to build houses on
	 * @param houses The number of houses to purchase for each property
	 */
	public void purchaseHouse(String selectedMonopoly, int houses) {
		GameBoard gb = GameMaster.instance().getGameBoard();
		PropertyCell[] cells = gb.getPropertiesInMonopoly(selectedMonopoly);
		if((money >= (cells.length * (cells[0].getHousePrice() * houses)))) {
			for(int i = 0; i < cells.length; i++) {
				int newNumber = cells[i].getNumHouses() + houses;
				if (newNumber <= 5) {
					cells[i].setNumHouses(newNumber);
					this.setMoney(money - (cells[i].getHousePrice() * houses));
					GameMaster.instance().updateGUI();
				}
			}
		}
	}
	
	/**
	 * Completes the purchase of a property cell by the player using its price.
	 * @param cell The property cell to purchase
	 */
	private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
	}

	/**
	 * Completes the purchase of a railroad cell by the player using its price.
	 * @param cell The railroad cell to purchase
	 */
	private void purchaseRailRoad(RailRoadCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

	/**
	 * Completes the purchase of a utility cell by the player using its price.
	 * @param cell The utility cell to purchase
	 */
	private void purchaseUtility(UtilityCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

    /**
     * Sells the specified property cell, removes ownership and adds the sale amount to the player's money.
     * @param property The property cell to sell
     * @param amount The amount of money gained from selling the property
     */
    public void sellProperty(Cell property, int amount) {
        property.setTheOwner(null);
        if(property instanceof PropertyCell) {
            properties.remove(property);
        }
        if(property instanceof RailRoadCell) {
            railroads.remove(property);
        }
        if(property instanceof UtilityCell) {
            utilities.remove(property);
        }
        setMoney(getMoney() + amount);
    }

	/**
	 * Sets the player's jail status to the specified value.
	 * @param inJail true if the player is to be marked as in jail; false otherwise
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/**
	 * Updates the player's money to the specified amount.
	 * @param money The new amount of money to set for the player
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Sets the player's name to the specified string.
	 * @param name The new name for the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Updates the player's current position to the specified game board cell.
	 * @param newPosition The cell to set as the player's new position
	 */
	public void setPosition(Cell newPosition) {
		this.position = newPosition;
	}

    /**
     * Returns the player's name as its string representation.
     * @return The name of the player
     */
    public String toString() {
        return name;
    }
    
    /**
     * Clears all properties, railroads, and utilities currently owned by the player.
     */
    public void resetProperty() {
    	properties = new ArrayList<PropertyCell>();
    	railroads = new ArrayList<Cell>();
    	utilities = new ArrayList<Cell>();
	}
}
