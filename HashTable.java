package DataStructures;

import Supporting.*;
import Exceptions.*;


// HashTable interface
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Hashable find( x )     --> Return item that matches x
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// find and remove throw ItemNotFound
// insert overrides previous value if duplicate; not an error

/**
 * Protocol for hash tables.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */
public interface HashTable
{
    /**
     * Insert into the hash table. If the item is
     * already present, then replace it with the new item.
     * @param x the item to insert.
     */
    void       insert( Hashable x );

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the hash table.
     */
    void       remove( Hashable x ) throws ItemNotFound;

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the hash table.
     */
    Hashable   find( Hashable x )   throws ItemNotFound;

    /**
     * Make the hash table logically empty.
     */
    void       makeEmpty( );
}
