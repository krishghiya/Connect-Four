
package edu.sjsu.cs.cs151.connectfour.Model;

import java.util.ArrayList;

/** Board.java
 * 
 * CS 151 Spring 2019
 * Professor Katarzyna Tarnowska
 * 
 * A class the represents the board Connect Four is played on.
 * Implements a SINGLETON pattern. 
 * 
 * @author Holly Lind
 * @since 11.05.2019
 */
public final class Board {

  // A SINGLETON instance of Board. 
  private static final Board instance = new Board(); 
  
  /**
   * creates a Board
   * @postcondition tiles initiated with BOARD_COLUMNS and BOARD_ROWS
   * all Tiles are colorless and filled is false
   */
  private Board() {
    tiles = new ArrayList<ArrayList<Tile>>();
    for (int i = 0; i < BOARD_COLUMNS; i++) {
      tiles.add(new ArrayList<Tile>());
      
      for (int j = 0; j < BOARD_ROWS; j++)
        tiles.get(i).add(new Tile(i, j));
    }
  }
  
  
  /**
   * checks what row to place next piece given a column
   * if 6 is returned, then the column is full
   * @param column to check
   * @return row to place piece in
   */
  public int checkColumnPlacement(int column) {
    for (int row = 0; row < BOARD_ROWS; row++) {
      if (!this.getTile(column, row).getFilled())
        return row;
    }
    return 6;
  }
  
  
  /**
   * access method for BOARD_COLUMNS
   * @return BOARD_COLUMNS (should be 7 for normal ConnectFour)
   */
  public static int getColumns() { 
    return BOARD_COLUMNS; 
  }
  
  
  /**
   * access method for BOARD_ROWS
   * @return BOARD_ROWS (should be 6 for normal ConnectFour)
   */
  public static int getRows() {
    return BOARD_ROWS;
  }
  
  
  /**
   * access method for PLAYER_ONE_COLOR
   * @return PLAYER_ONE_COLOR
   */
  public static String getPlayerOneColor() {
    return PLAYER_ONE_COLOR; 
  }
  
  
  /**
   * access method for PLAYER_TWO_COLOR
   * @return PLAYER_TWO_COLOR
   */
  public static String getPlayerTwoColor() { 
    return PLAYER_TWO_COLOR;
  }
  
  
  /**
   * changes a Tile's properties based on player's action
   * @param column of Tile that player chose
   * @param row of Tile that player chose
   * @param player - which player took the action
   * @postcondition Tile's color is set to player's color
   * @postcondition Tile's fill is set true
   */
  public void setTile(int column, int row, String player) {
    Tile tileToChange = this.getTile(column, row);
    if (player.equals(Model.getPlayerOne())) {
      tileToChange.setColor(PLAYER_ONE_COLOR);
      tileToChange.nowFilled();
    }
    else {
      tileToChange.setColor(PLAYER_TWO_COLOR);
      tileToChange.nowFilled();
    }
  }
  
  
  /**
   * resets all of the Tiles on the Board
   * @postcondition all Tiles are colorless and filled is false
   */
  public void resetBoard() {
    for (int i = 0; i < BOARD_COLUMNS; i++) {
      for (int j = 0; j < BOARD_ROWS; j++)
        this.getTile(i, j).resetTile();
    }
  }
  
  
  /**
   * access method for a Tile at (x, y)
   * @param x coordinate of Tile
   * @param y coordinate of Tile
   * @return Tile at (x, y)
   */
  public Tile getTile(int x, int y) {
    return tiles.get(x).get(y);
  }
  
  /**
   * @return The singleton instance of Board. 
   */
  public static Board getInstance() {
    return instance; 
  }
  
  private ArrayList<ArrayList<Tile>> tiles;
  private static final int BOARD_COLUMNS = 7;
  private static final int BOARD_ROWS = 6;
  private static final String PLAYER_ONE_COLOR = "red";
  private static final String PLAYER_TWO_COLOR = "black";
}
