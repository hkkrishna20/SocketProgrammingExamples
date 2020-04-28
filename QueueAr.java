package DataStructures;

import Exceptions.*;

// QueueAr class
//
// CONSTRUCTION: with no initializer
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
 * Array-based implementation of the queue.
 * @author Mark Allen Weiss
 */
public class QueueAr implements Queue
{
    /**
     * Construct the queue.
     */
    public QueueAr( )
    {
        theArray = new Object[ DEFAULT_CAPACITY ];
        makeEmpty( );
    }

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
        front = 0;
        back = -1;
    }

    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    public Object getFront( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Queue getFront" );
        return theArray[ front ];
    }

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @exception Underflow if the queue is empty.
     */
    public Object dequeue( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Queue dequeue" );
        currentSize--;

        Object returnValue = theArray[ front ];
        front = increment( front );
        return returnValue;
    }

    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue( Object x )
    {
        if( currentSize == theArray.length )
            doubleQueue( );
        back = increment( back );
        theArray[ back ] = x;
        currentSize++;
    }

    /**
     * Internal method to expand theArray.
     */
    private void doubleQueue( )
    {
        Object [ ] newArray;

        newArray = new Object[ theArray.length * 2 ];

            // Copy elements that are logically in the queue
        for( int i = 0; i < currentSize; i++, front = increment( front ) )
            newArray[ i ] = theArray[ front ];

        theArray = newArray;
        front = 0;
        back = currentSize - 1;
    }

    /**
     * Internal method to increment with wraparound.
     * @param x any index in theArray's range.
     * @return x+1, or 0 if x is at the end of theArray.
     */
    private int increment( int x )
    {
        if( ++x == theArray.length )
            x = 0;
        return x;
    }

    private Object [ ] theArray;
    private int        currentSize;
    private int        front;
    private int        back;

    static final int DEFAULT_CAPACITY = 10;
}