package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// BinaryHeap class
//
// CONSTRUCTION: with a negative infinity sentinel
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void toss( x )         --> Insert x (lazily)
// ******************ERRORS********************************
// findMin and deleteMin throw Underflow when empty

/**
 * Implements a binary heap.
 * Allows lazy insertion and provides a linear-time
 * heap construction method.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 */
public class BinaryHeap implements PriorityQueue
{
    /**
     * Construct the binary heap.
     * @param negInf a value smaller than or equal to all others.
     */
    public BinaryHeap( Comparable negInf )
    {
        currentSize = 0;
        orderOK = true;
        getArray( DEFAULT_CAPACITY );
        array[ 0 ] = negInf;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( Comparable x )
    {
        if( !orderOK )
        {
            toss( x );
            return;
        }

        checkSize( );

            // Percolate up
        int hole = ++currentSize;
        for( ; x.lessThan( array[ hole / 2 ] ); hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }

    /**
     * Insert into the priority queue, without maintaining
     * heap order. Duplicates are allowed.
     * @param x the item to insert.
     */
    public void toss( Comparable x )
    {
        checkSize( );
        array[ ++currentSize ] = x;
        if( x.lessThan( array[ currentSize / 2 ] ) )
            orderOK = false;
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item.
     * @exception Underflow if the priority queue is empty.
     */
    public Comparable findMin( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Empty binary heap" );
        if( !orderOK )
            fixHeap( );
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @exception Underflow if the priority queue is empty.
     */
    public Comparable deleteMin( ) throws Underflow
    {
        Comparable minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }

    /**
     * Re-establish heap order property after a series of
     * toss operations. Runs in linear time.
     */
    private void fixHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
        orderOK = true;
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 11;

    private int currentSize;      // Number of elements in heap
    private boolean orderOK;      // True if heap order is guaranteed
    private Comparable [ ] array; // The heap array

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        Comparable tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].lessThan( array[ child ] ) )
                child++;
            if( array[ child ].lessThan( tmp ) )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }

    /**
     * Private method to allocate the heap array.
     * Includes an extra spot for the sentinel.
     * @param newMaxSize the capacity of the heap.
     */
    private void getArray( int newMaxSize )
    {
        array = new Comparable[ newMaxSize + 1 ];
    }

    /**
     * Private method that doubles the heap array if full.
     */
    private void checkSize( )
    {
        if( currentSize == array.length - 1 )
        {
            Comparable [ ] oldArray = array;
            getArray( currentSize * 2 );
            for( int i = 0; i < oldArray.length; i++ )
                array[ i ] = oldArray[ i ];
        }
    }

        // Test program
    public static void main( String [ ] args )
    {
        BinaryHeap h = new BinaryHeap( new MyInteger( -2147483648 ) );
        int numItems = 10000;
        int i = 37;

        try
        {
            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.insert( new MyInteger( i ) );
            for( i = 1; i < numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i );

            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.toss( new MyInteger( i ) );
            for( i = 1; i <= numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i + " " );
        }
        catch( Underflow e )
          { System.out.println( "Underflow (expected)! " + i  ); }
    }
}
