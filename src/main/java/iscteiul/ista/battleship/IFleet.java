///**
// *
// */
//package iscteiul.ista.battleship;
//
//import java.util.List;
//
//public interface IFleet {
//    Integer BOARD_SIZE = 10;
//    Integer FLEET_SIZE = 10;
//
//    List<IShip> getShips();
//
//    boolean addShip(IShip s);
//
//    List<IShip> getShipsLike(String category);
//
//    List<IShip> getFloatingShips();
//
//    IShip shipAt(IPosition pos);
//
//    void printStatus();
//}

/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents the fleet of ships in the Battleship game.
 * Defines board dimensions, fleet size limits, and operations
 * for managing and querying ships within the fleet.
 */
public interface IFleet {
    /**
     * Default size of the board grid (10x10).
     */
    Integer BOARD_SIZE = 10;

    /**
     * Maximum number of ships allowed in the fleet.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Retrieves the complete list of ships that make up the fleet.
     *
     * @return a list containing all {@link IShip} objects in the fleet.
     */
    List getShips();

    /**
     * Adds a new ship to the fleet if it meets the placement and validation rules.
     *
     * @param s the ship ({@link IShip}) to be added to the fleet.
     * @return {@code true} if the ship was successfully added; {@code false} otherwise.
     */
    boolean addShip(IShip s);

    /**
     * Returns a list of ships in the fleet belonging to a specific category.
     *
     * @param category the category/type of ship to search for (e.g., "Barge", "Frigate").
     * @return a list of {@link IShip} objects matching the specified category.
     */
    List getShipsLike(String category);

    /**
     * Retrieves only the ships in the fleet that are still floating (not sunk).
     *
     * @return a list containing all active/operational {@link IShip} objects.
     */
    List getFloatingShips();

    /**
     * Finds and returns the ship occupying a specific position on the board.
     *
     * @param pos the position ({@link IPosition}) to check on the board.
     * @return the {@link IShip} present at that position, or {@code null} if empty.
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints the current status of the fleet to the console (e.g., remaining, hit, or sunk ships).
     */
    void printStatus();
}