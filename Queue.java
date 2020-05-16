package DataStructures;

import Exceptions.*;

// Queue interface
//
// ******************PUBLIC OPERATIONS*********************
// void enqueue( x )      --> Insert x
// Object getFront( )     --> Return least recently inserted item
// Object dequeue( )      --> Return and remove least recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// getFront or dequeue on empty queue

/**
 * Protocol for queues.
 * @author Mark Allen Weiss
 */
public interface Queue
{
    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    Object getFront( ) throws Underflow;

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    Object dequeue( ) throws Underflow;

    /**
     * Insert a new item into the queue.
     * @param X the item to insert.
     */
    void  enqueue( Object X );

    /**
     * Make the queue logically empty.
     */
    void makeEmpty( );
}