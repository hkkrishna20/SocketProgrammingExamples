package DataStructures;

import Exceptions.*;

// Stack interface
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
 * Protocol for stacks.
 * @author Mark Allen Weiss
 */
public interface Stack
{
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @exception Underflow if the stack is empty.
     */
    Object  top( )       throws Underflow;

    /**
     * Remove the most recently inserted item from the stack.
     * @exception Underflow if the stack is empty.
     */
    void    pop( )       throws Underflow;

    /**
     * Return and remove the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     * @exception Underflow if the stack is empty.
     */
    Object  topAndPop( ) throws Underflow;

    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    void    push( Object x );

    /**
     * Make the stack logically empty.
     */
    void    makeEmpty( );
}