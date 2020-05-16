package DataStructures;

// LinkedList class
//
// CONSTRUCTION: with no initializer
// Access is via LinkedListItr class
//
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// No special errors

/**
 * Linked list implementation of the list
 *    using a header node.
 * Access to the list is via LinkedListItr.
 * @author Mark Allen Weiss
 * @see LinkedListItr
 */
public class LinkedList implements List
{
    /**
     * Construct the list
     */
    public LinkedList( )
    {
        header = new ListNode( null );
    }

    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.next == null;
    }

    /**
     * Make the list logically empty.
     */
    public void makeEmpty( )
    {
        header.next = null;
    }

        // Friendly data, so LinkedListItr can have access
    ListNode header;
}