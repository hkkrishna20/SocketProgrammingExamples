package DataStructures;

import Exceptions.*;
import Supporting.*;
import Supporting.Comparable;

// SortListItr class; maintains "current position"
//
// CONSTRUCTION: with a LinkedList to which SortListItr
//     is permanently bound
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x in sorted order
// void remove( x )       --> Remove x
// void removeNext( )     --> Remove item after current position
// boolean find( x )      --> Set current position to view x
// void zeroth( )         --> Set current position to prior to first
// void first( )          --> Set current position to first
// void advance( )        --> Advance
// boolean isInList( )    --> True if at valid position in list
// Object retrieve        --> Return item in current position
// ******************ERRORS********************************
// Exceptions thrown for illegal access, insert, or remove.


/**
 * Linked list implementation of the sorted list iterator
 *    using a header node.
 * Insertions are done to maintian sorted order.
 * @author Mark Allen Weiss
 * @see LinkedList
 */
public class SortListItr extends LinkedListItr
{
    /**
     * Construct the list.
     * The result of the construction is the same as for ListItr.
     * @param anyList a LinkedList object to which this iterator is
     *     permanently bound. This constructor is provided for
     *     convenience. If anyList is not a LinkedList object, a
     *     ClassCastException will result.
     */
    public SortListItr( List anyList ) throws ClassCastException
    {
        super( anyList );
    }

    /**
     * Overridden to generate an exception. An insert routine
     * that accepts a Comparable object should be used.
     * @param x an Object that is attempted to be inserted.
     * @exception ItemNotFound thrown if this method is executed.
     */
    public void insert( Object x ) throws ItemNotFound
    {
        if( x instanceof Comparable )
            insert( (Comparable) x );
        else
            throw new ItemNotFound( "SortListItr insert " +
                  "requires an object of type Comparable" );
    }

    /**
     * Insert in sorted order.
     * Assumes that the list is already sorted.
     * current is set to the inserted node on success.
     * No exceptions are thrown.
     * @param x the item to insert.
     */        
    public void insert( Comparable x )
    {
        LinkedListItr prev = new LinkedListItr( theList );
        LinkedListItr curr = new LinkedListItr( theList );

        prev.zeroth( );
        curr.first( );
        while( curr.isInList( ) && ((Comparable)(curr.retrieve( ))).lessThan( x ) )
        {
            curr.advance( );
            prev.advance( );
        }

        try
          { prev.insert( x ); }
        catch( ItemNotFound e ) { }  // Cannot happen

        current = prev.current;
    }


    public static void main( String [ ] args )
    {
        MyInteger m = new MyInteger( 5 );
        Object obj1 = new Integer( 5 );
        SortListItr itr = new SortListItr( new LinkedList( ) );

        itr.insert( m );

        try 
          { itr.insert( obj1 ); }
        catch( ItemNotFound e )
          { System.out.println( "Item not Comparable" ); }

        obj1 = m;
        try
          { itr.insert( obj1 ); }
        catch( ItemNotFound e ) 
          { System.out.println( "Item not Comparable" ); }
    }
}