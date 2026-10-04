///**
// *
// */
//package iscteiul.ista.battleship;
//
///**
// * @author fba
// */
//public interface IPosition {
//    int getRow();
//
//    int getColumn();
//
//    boolean equals(Object other);
//
//    boolean isAdjacentTo(IPosition other);
//
//    void occupy();
//
//    void shoot();
//
//    boolean isOccupied();
//
//    boolean isHit();
//}

/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents a position (cell) on the game board grid.
 * Defines row and column coordinates, ship occupation status,
 * and shot history for the cell.
 *
 * @author fba
 */
public interface IPosition {
    /**
     * Gets the row index corresponding to this position.
     *
     * @return the row number.
     */
    int getRow();

    /**
     * Gets the column index corresponding to this position.
     *
     * @return the column number.
     */
    int getColumn();

    /**
     * Compares this position with another object for equality.
     * Two positions are considered equal if they have the same row and column.
     *
     * @param other the object to compare with this position.
     * @return {@code true} if the object is a position with identical coordinates; {@code false} otherwise.
     */
    boolean equals(Object other);

    /**
     * Checks if this position is adjacent (vertically, horizontally, or diagonally) to another position.
     *
     * @param other the other position ({@link IPosition}) to check proximity against.
     * @return {@code true} if the positions are neighbors/adjacent; {@code false} otherwise.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks this position as occupied by a segment of a ship.
     */
    void occupy();

    /**
     * Records that a shot was fired at this position.
     */
    void shoot();

    /**
     * Checks if this position is currently occupied by a ship.
     *
     * @return {@code true} if occupied; {@code false} if free.
     */
    boolean isOccupied();

    /**
     * Checks if this position has already been targeted by a shot.
     *
     * @return {@code true} if it has been hit by a shot; {@code false} otherwise.
     */
    boolean isHit();
}