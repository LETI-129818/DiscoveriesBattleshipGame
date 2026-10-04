///**
// *
// */
//package iscteiul.ista.battleship;
//
//import java.util.List;
//
//public interface IGame {
//    IShip fire(IPosition pos);
//
//    List<IPosition> getShots();
//
//    int getRepeatedShots();
//
//    int getInvalidShots();
//
//    int getHits();
//
//    int getSunkShips();
//
//    int getRemainingShips();
//
//    void printValidShots();
//
//    void printFleet();
//}

/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents the Battleship game engine.
 * Defines methods for firing shots and tracking match statistics,
 * such as valid, repeated, invalid, and successful hits.
 */
public interface IGame {
    /**
     * Fires a shot at a specific position on the board.
     *
     * @param pos the position ({@link IPosition}) targeted by the shot.
     * @return the hit ship ({@link IShip}) if the shot lands on a target, or {@code null} if it hits water or is invalid.
     */
    IShip fire(IPosition pos);

    /**
     * Retrieves the list of all positions where shots have been fired during the game.
     *
     * @return a list of {@link IPosition} objects corresponding to fired shots.
     */
    List getShots();

    /**
     * Gets the total count of repeated shots (shots fired at previously targeted positions).
     *
     * @return the number of repeated shots.
     */
    int getRepeatedShots();

    /**
     * Gets the total count of invalid shots (shots out of bounds or violating rules).
     *
     * @return the number of invalid shots.
     */
    int getInvalidShots();

    /**
     * Gets the total count of successful shots that hit a ship.
     *
     * @return the total number of hits.
     */
    int getHits();

    /**
     * Gets the total count of fleet ships that have been completely sunk.
     *
     * @return the number of sunk ships.
     */
    int getSunkShips();

    /**
     * Gets the number of fleet ships that are still floating/operational.
     *
     * @return the number of remaining ships.
     */
    int getRemainingShips();

    /**
     * Prints a visual representation of the board grid containing only valid shots to the console.
     */
    void printValidShots();

    /**
     * Prints a visual representation of the board showing the location and status of all fleet ships to the console.
     */
    void printFleet();
}