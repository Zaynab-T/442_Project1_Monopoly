package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import edu.towson.cis.cosc442.project1.monopoly.Cell;
import edu.towson.cis.cosc442.project1.monopoly.GameBoard;

/**
 * GameBoardUtil is a utility class that provides methods for calculating the dimensions of a Monopoly game board and retrieving cells from specific sides (east, north, south, west) of the board.
 * It includes methods to calculate the long and short side lengths based on the total number of cells and to extract lists of cells from each side of the board.
 */
public class GameBoardUtil {
    
	/**
	 * Calculates the dimensions of the game board's sides based on the total cell count.
	 * @param i the total number of cells on the game board
	 * @return a Dimension object where width is the long side length and height is the short side length of the game board
	 */
	public static Dimension calculateDimension(int i) {
		i = i - 4;
		int shortSide = i / 4;
		int longSide = (i - (shortSide * 2)) / 2;
		return new Dimension(longSide, shortSide);
	}
	
	/**
	 * Retrieves the list of cells located on the east side of the given game board.
	 * @param board the game board to extract east side cells from
	 * @return a list of Cell objects on the east side of the board
	 */
	public static List<Cell> getEastCells(GameBoard board) {
		Dimension d = calculateDimension(board.getCellNumber());
		int shortSide = d.height;
		List<Cell> cells = new ArrayList<Cell>();
		for(int i = board.getCellNumber() - shortSide; i <= board.getCellNumber() - 1; i++) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	/**
	 * Retrieves the list of cells located on the north side of the given game board.
	 * @param board the game board to extract north side cells from
	 * @return a list of Cell objects on the north side of the board
	 */
	public static List<Cell> getNorthCells(GameBoard board) {
		Dimension d = calculateDimension(board.getCellNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List<Cell> cells = new ArrayList<Cell>();
		for(int i = longSide + 2 + shortSide; i <= longSide + 2 + shortSide + longSide + 1; i++) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	/**
	 * Retrieves the list of cells located on the south side of the given game board.
	 * @param board the game board to extract south side cells from
	 * @return a list of Cell objects on the south side of the board
	 */
	public static List<Cell> getSouthCells(GameBoard board) {
		Dimension d = calculateDimension(board.getCellNumber());
		int longSide = d.width;
		List<Cell> cells = new ArrayList<Cell>();
		for(int i = longSide + 1; i >= 0; i--) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	/**
	 * Retrieves the list of cells located on the west side of the given game board.
	 * @param board the game board to extract west side cells from
	 * @return a list of Cell objects on the west side of the board
	 */
	public static List<Cell> getWestCells(GameBoard board) {
		Dimension d = calculateDimension(board.getCellNumber());
		int longSide = d.width;
		int shortSide = d.height;
		List<Cell> cells = new ArrayList<Cell>();
		for(int i = longSide + 1 + shortSide; i > longSide + 1; i--) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
}
