package DataStructures;

import Supporting.MyInteger; // For main only
import Exceptions.*;
import java.io.*;

// LinkedListItr class; maintains "current position"
//
// CONSTRUCTION: with (a) LinkedList to which ListItr
//     is permanently bound
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x after current position
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
 * Linked list implementation of the list iterator
 *    using a header node.
 * @author Mark Allen Weiss
 * @see LinkedList
 */
public class LinkedListItr implements ListItr
{
    /**
     * Construct the list.
     * @param anyList a LinkedList object to which this iterator is
     *     permanently bound. This constructor is provided for
     *     convenience. If anyList is not a LinkedList object, a
     *     ClassCastException will result.
     */
    public LinkedListItr( List anyList ) throws ClassCastException
    {
        this( ( LinkedList ) anyList );
    }

    /**
     * Construct the list.
     * As a result of the construction, the current position is
     * the first item, unless the list is empty, in which case
     * the current position is the zeroth item.
     * @param anyList a LinkedList object to which this iterator is
     *     permanently bound.
     */
    public LinkedListItr( LinkedList anyList )
    {
        theList = anyList;
        current = theList.isEmpty( ) ? theList.header : theList.header.next;
    }

    /**
     * Insert after the current position.
     * current is set to the inserted node on success.
     * @param x the item to insert.
     * @exception ItemNotFound if the current position is null.
     */
    public void insert( Object x ) throws ItemNotFound
    {
        if( current == null )
            throw new ItemNotFound( "Insertion error" );

        ListNode newNode = new ListNode( x, current.next );
        current = current.next = newNode;
    }

     /**
      * Set the current position to the first node containing an item.
      * current is unchanged if x is not found.
      * @param x the item to search for.
      * @return true if the item is found, false otherwise.
      */
     public boolean find( Object x )
     {
         ListNode itr = theList.header.next;

         while( itr != null && !itr.element.equals( x ) )
             itr = itr.next;

         if( itr == null )
             return false;

         current = itr;
         return true;
     }

    /**
      * Remove the first occurrence of an item.
      * current is set to the first node on success;
      * remains unchanged otherwise.
      * @param x the item to remove.
      * @exception ItemNotFound if the item is not found.
      */
     public void remove( Object x ) throws ItemNotFound
     {
         ListNode itr = theList.header;

         while( itr.next != null && !itr.next.element.equals( x ) )
             itr = itr.next;

         if( itr.next == null )
             throw new ItemNotFound( "Remove fails" );

         itr.next = itr.next.next;   // Bypass deleted node
         current = theList.header;   // Reset current
     }


    /**
      * Remove the item after the current position.
      * current is unchanged.
      * @return true if successful false otherwise.
      */
     public boolean removeNext( )
     {
         if( current == null || current.next == null )
             return false;
         current.next = current.next.next;
         return true;
     }

     /**
      * Test if the current position references a valid list item.
      * @return true if the current position is not null and is
      *     not referencing the header node.
      */
     public boolean isInList( )
     {
         return current != null && current != theList.header;
     }

     /**
      * Return the item stored in the current position.
      * @return the stored item or null if the current position
      * is not in the list.
      */
     public Object retrieve( )
     {
         return isInList( ) ? current.element : null;
     }

     /**
      * Set the current position to the header node.
      */
     public void zeroth( )
     {
         current = theList.header;
     }

     /**
      * Set the current position to the first node in the list.
      * This operation is valid for empty lists.
      */
     public void first( )
     {
         current = theList.header.next;
     }

     /**
      * Advance the current position to the next node in the list.
      * If the current position is null, then do nothing.
      * No exceptions are thrown by this routine because in the
      * most common use (inside a for loop), this would require the
      * programmer to add an unnecessary try/catch block.
      */
     public void advance( )
     {
         if( current != null )
             current = current.next;
     }

         /** List header. */
     protected LinkedList     theList;    // List header
         /** Current position. */
     protected ListNode       current;    // Current position

       
     // Method that copies from rhs to lhs;
     // Calls public methods only
     public static void copy( LinkedList lhs, LinkedList rhs )
     {
         // Aliasing test
         if( lhs == rhs )
             return;

         lhs.makeEmpty( );

         LinkedListItr lItr = new LinkedListItr( lhs );
         LinkedListItr rItr = new LinkedListItr( rhs );
 
         try
         {
             for( ; rItr.isInList( ); rItr.advance( ) )
                 lItr.insert( rItr.retrieve( ) );
         }
         catch( ItemNotFound e ) { }
     }

     // Simple print method
     static public void print( LinkedList theList )
     {
         if( theList.isEmpty( ) )
             System.out.print( "Empty list" );
         else
         {
             LinkedListItr itr = new LinkedListItr( theList );
             for( ; itr.isInList( ); itr.advance( ) )
                 System.out.print( itr.retrieve( ) + " " );
         }

         System.out.println( );
    } 

     public static void main( String [ ] args )
     {
         LinkedList    theList2 = new LinkedList( );
         ListItr itr2     = new LinkedListItr( theList2 );
         LinkedList    theList = new LinkedList( );
         ListItr itr     = new LinkedListItr( theList );

             // Repeatedly insert new items as first elements
         for( int i = 0; i < 5; i++ )
         {
             try
               { itr2.insert( new Integer( i ) ); }
             catch( ItemNotFound e ) { } // Cannot happen
             itr.zeroth( );              // Reset Itr to the start
         }

         copy( theList, theList2 );

         System.out.print( "Contents:" );
         for( itr.first( ); itr.isInList( ); itr.advance( ) )
             System.out.print( " " + itr.retrieve( ) );
         System.out.println( " end" );

         print( theList );

         theList.makeEmpty( );
         LinkedListItr itr3 = new SortListItr( theList );

         System.out.println( "Sorted list (should be 2 8)" );
         try
         {
             itr3.insert( new MyInteger( 8 ) );
             itr3.insert( new MyInteger( 2 ) );
         }
         catch( ItemNotFound e ) { }
         print( theList );
     
     }
}


