package DataStructures;

import Exceptions.*;

// StackLi class
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
 * List-based implementation of the stack.
 * @author Mark Allen Weiss
 */
public class StackLi implements Stack
{
    /**
     * Construct the stack.
     */
    public StackLi( )
    {
        topOfStack = null;
    }

    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return topOfStack == null;
    }

    /**
     * Make the stack logically empty.
     */
    public void makeEmpty( )
    {
        topOfStack = null;
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
        return topOfStack.element;
    }

    /**
     * Remove the most recently inserted item from the stack.
     * @exception Underflow if the stack is empty.
     */
    public void pop( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Stack pop" );
        topOfStack = topOfStack.next;
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

        Object topItem = topOfStack.element;
        topOfStack = topOfStack.next;
        return topItem;
    }

    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push( Object x )
    {
        topOfStack = new ListNode( x, topOfStack );
    }

    private ListNode topOfStack;
}