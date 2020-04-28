package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// PriorityQueue interface
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// findMin and deleteMin throw Underflow when empty.

/**
 * Protocol for priority queues.
 * @author Mark Allen Weiss
 */
public interface PriorityQueue
{
    /**
     * Insert into the priority queue.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    void       insert( Comparable x );

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item.
     * @exception Underflow if the priority queue is empty.
     */
    Comparable findMin( )   throws Underflow;

    /**
     * Remove the smallest item from the priority queue.
     * @exception Underflow if the priority queue is empty.
     */
    Comparable deleteMin( ) throws Underflow;

    /**
     * Make the priority queue logically empty.
     */
    void       makeEmpty( );

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean    isEmpty( );
}
