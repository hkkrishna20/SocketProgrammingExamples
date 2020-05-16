package DataStructures;

import Exceptions.*;


// StackAr class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void push( x )         --> Insert x
// void pop( )            --> Remove most recently inserted item
// Object top( )          --> Return most recently inserted item
// Object topAndPop( )    --> Return and remove most recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// top, pop, or topAndPop on empty stack

/**
 * Array-based implementation of the stack.
 * @author Mark Allen Weiss
 */
public class StackAr implements Stack
{
    /**
     * Construct the stack.
     */
    public StackAr( )
    {
        theArray = new Object[ DEFAULT_CAPACITY ];
        topOfStack = -1;
    }

    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return topOfStack == -1;
    }

    /**
     * Make the stack logically empty.
     */
    public void makeEmpty( )
    {
        topOfStack = -1;
    }

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @exception Underflow if the stack is empty.
     */
    public Object top( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Stack top" );
        return theArray[ topOfStack ];
    }

    /**
     * Remove the most recently inserted item from the stack.
     * @exception Underflow if the stack is empty.
     */
    public void pop( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Stack pop" );
        topOfStack--;
    }

    /**
     * Return and remove the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     * @exception Underflow if the stack is empty.
     */
    public Object topAndPop( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Stack topAndPop" );
        return theArray[ topOfStack-- ];
    }

    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push( Object x )
    {
        if( topOfStack + 1 == theArray.length )
            doubleArray( );
        theArray[ ++topOfStack ] = x;
    }

    /**
     * Internal method to extend theArray.
     */
    private void doubleArray( )
    {
        Object [ ] newArray;

        newArray = new Object[ theArray.length * 2 ];
        for( int i = 0; i < theArray.length; i++ )
            newArray[ i ] = theArray[ i ];
        theArray = newArray;
    }

    private Object [ ] theArray;
    private int        topOfStack;

    static final int DEFAULT_CAPACITY = 10;
}