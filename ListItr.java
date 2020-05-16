package DataStructures;

import Exceptions.*;

// ListItr interface; maintains "current position"
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x after current position
// void remove( x )       --> Remove x
// boolean find( x )      --> Set current position to view x
// void zeroth( )         --> Set current position to prior to first
// void first( )          --> Set current position to first
// void advance( )        --> Advance
// boolean isInList( )    --> True if at valid position in list
// Object retrieve        --> Return item in current position
// ******************ERRORS********************************
// Exceptions thrown for illegal access, insert, or remove.


/**
 * Protocol for list iterators
 *    using a header node.
 * @author Mark Allen Weiss
 * @see List
 */
public interface ListItr
{
    /**
     * Insert after the current position.
     * Current is set to the inserted node on success.
     * @param x the item to insert.
     * @exception ItemNotFound if the current position is null.
     */
    void    insert( Object x ) throws ItemNotFound;

     /**
      * Set the current position to the first node containing an item.
      * current is unchanged if x is not found.
      * @param x the item to search for.
      * @return true if the item is found, false otherwise.
      */
    boolean find( Object x );
     
    /**
      * Remove the first occurrence of an item.
      * current is set to the first node on success;
      * remains unchanged otherwise.
      * @param x the item to remove.
      * @exception ItemNotFound if the item is not found.
      */
    void    remove( Object x ) throws ItemNotFound;
     

     /**
      * Test if the current position references a valid list item.
      * @return true if the current position is not null and is
      *     not referencing the header node.
      */
    boolean isInList( );

     /**
      * Return the item stored in the current position.
      * @return the stored item or null if the current position
      * is not in the list.
      */
    Object  retrieve( );

     /**
      * Set the current position to the header node.
      */
    void    zeroth( );

     /**
      * Set the current position to the first node in the list.
      * This operation is valid for empty lists.
      */
    void    first( );

     /**
      * Advance the current position to the next node in the list.
      * If the current position is null, then do nothing.
      * No exceptions are thrown by this routine because in the
      * most common use (inside a for loop), this would require the
      * programmer to add an unnecessary try/catch block.
      */
    void    advance( );
}

