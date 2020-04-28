package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// SearchTree interface
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove smallest item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Most routines throw ItemNotFound on various degenerate conditions
// insert throws DuplicateItem if item is already in the tree

/**
 * Protocol for search trees.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 */
public interface SearchTree
{
    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @exception DuplicateItem if an item
     *     that matches x is already in the tree.
     */
    void       insert( Comparable x ) throws DuplicateItem;

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the tree.
     */
    void       remove( Comparable x ) throws ItemNotFound;

    /**
     * Remove the smallest item from the tree.
     * @exception ItemNotFound if the tree is empty.
     */
    void       removeMin( )           throws ItemNotFound;

    /**
     * Find the smallest item in the tree.
     * @return the smallest item.
     * @exception ItemNotFound if the tree is empty.
     */
    Comparable findMin( )             throws ItemNotFound;

    /**
     * Find the largest item the tree.
     * @return the largest item.
     * @exception ItemNotFound if the tree is empty.
     */
    Comparable findMax( )             throws ItemNotFound;

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the tree.
     */
    Comparable find( Comparable x )   throws ItemNotFound;

    /**
     * Make the tree logically empty.
     */
    void       makeEmpty( );

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean    isEmpty( );

    /**
     * Print the tree contents in sorted order.
     */
    void       printTree( );
}