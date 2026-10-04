///**
// *
// */
//package iscteiul.ista.battleship;
//
//import java.util.List;
//
//public interface IShip {
//    String getCategory();
//
//    Integer getSize();
//
//    List<IPosition> getPositions();
//
//    IPosition getPosition();
//
//    Compass getBearing();
//
//    boolean stillFloating();
//
//    int getTopMostPos();
//
//    int getBottomMostPos();
//
//    int getLeftMostPos();
//
//    int getRightMostPos();
//
//    boolean occupies(IPosition pos);
//
//    boolean tooCloseTo(IShip other);
//
//    boolean tooCloseTo(IPosition pos);
//
//    void shoot(IPosition pos);
//}

/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents a ship in the Battleship game.
 * Defines ship attributes (category, size, position, orientation)
 * and operations to check occupation, proximity, and record hits.
 */
public interface IShip {
    /**
     * Gets the category or type of the ship (e.g., "Barge", "Frigate", "Carrack").
     *
     * @return the category name of the ship.
     */
    String getCategory();

    /**
     * Gets the number of positions/cells occupied by the ship on the board.
     *
     * @return the size of the ship.
     */
    Integer getSize();

    /**
     * Gets the list of all positions occupied by this ship.
     *
     * @return a list of {@link IPosition} objects making up the ship.
     */
    List getPositions();

    /**
     * Gets the reference position (starting/anchor position) of the ship on the board.
     *
     * @return the origin {@link IPosition} of the ship.
     */
    IPosition getPosition();

    /**
     * Gets the compass direction/orientation the ship is facing.
     *
     * @return the {@link Compass} cardinal point indicating the bearing.
     */
    Compass getBearing();

    /**
     * Checks if the ship is still floating (i.e., has at least one unhit position).
     *
     * @return {@code true} if the ship is still operational; {@code false} if sunk.
     */
    boolean stillFloating();

    /**
     * Gets the lowest row index occupied by the ship (topmost/northernmost position).
     *
     * @return the upper boundary row index.
     */
    int getTopMostPos();

    /**
     * Gets the highest row index occupied by the ship (bottommost/southernmost position).
     *
     * @return the lower boundary row index.
     */
    int getBottomMostPos();

    /**
     * Gets the lowest column index occupied by the ship (leftmost/westernmost position).
     *
     * @return the left boundary column index.
     */
    int getLeftMostPos();

    /**
     * Gets the highest column index occupied by the ship (rightmost/easternmost position).
     *
     * @return the right boundary column index.
     */
    int getRightMostPos();

    /**
     * Checks if the ship occupies a specific position on the board.
     *
     * @param pos the position ({@link IPosition}) to test.
     * @return {@code true} if the ship occupies that position; {@code false} otherwise.
     */
    boolean occupies(IPosition pos);

    /**
     * Checks if this ship is too close to another ship, violating proximity spacing rules.
     *
     * @param other the other ship ({@link IShip}) to check against.
     * @return {@code true} if they are too close/adjacent; {@code false} otherwise.
     */
    boolean tooCloseTo(IShip other);

    /**
     * Checks if the ship is too close to a specific position.
     *
     * @param pos the position ({@link IPosition}) to test.
     * @return {@code true} if the position is adjacent or overlapping; {@code false} otherwise.
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Records a shot fired at the specified position of the ship.
     *
     * @param pos the position ({@link IPosition}) targeted by the shot.
     */
    void shoot(IPosition pos);
}
