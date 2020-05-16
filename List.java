package DataStructures;

// List interface
//
// Access is via ListItr class
//
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// No special errors

/**
 * Protocol for lists.
 * Access to the list is done via the ListItr object.
 * @author Mark Allen Weiss
 * @see ListItr
 */
public interface List
{
    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Make the list logically empty.
     */
    void makeEmpty( );
}