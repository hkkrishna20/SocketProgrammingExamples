package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// PairHeap class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// PairNode addItem( x )  --> Insert x, return position
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void decreaseKey( PairNode p, newVal )
//                        --> Decrease value in node p
// ******************ERRORS********************************
// findMin and deleteMin throw Underflow when empty

/**
 * Implements a pairing heap.
 * Supports a decreaseKey operation, but requires use
 * of addItem instead of insert.
 * Heap order is always maintained; no lazy operations allowed.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 * @see PairNode
 */
public class PairHeap implements PriorityQueue
{
    /**
     * Construct the pairing heap.
     */
    public PairHeap( )
    {
        currentSize = 0;
        root = null;
    }

    /**
     * Insert into the priority queue.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( Comparable x )
    {
        newNode = new PairNode( x );

        currentSize++;
        if( root == null )
            root = newNode;
        else
            root = compareAndLink( root, newNode );
    }


    /**
     * Insert into the priority queue, and return a PairNode
     * that can be used by decreaseKey.
     * Duplicates are allowed.
     * @param x the item to insert.
     * @return the node containing the newly inserted item.
     */
    public PairNode addItem( Comparable x )
    {
        insert( x );
        return newNode;
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item.
     * @exception Underflow if the priority queue is empty.
     */
    public Comparable findMin( ) throws Underflow
    {
        if( isEmpty( ) )
            throw new Underflow( "Empty pairing heap" );
        return root.element;
    }

    /**
     * Remove the smallest item from the priority queue.
     * @exception Underflow if the priority queue is empty.
     */
    public Comparable deleteMin( ) throws Underflow
    {
        Comparable x = findMin( );
        if( root.leftChild == null )
            root = null;
        else
            root = combineSiblings( root.leftChild );

        currentSize--;

        return x;
    }

    /**
     * Change the value of the item stored in the pairing heap.
     * @param p any node returned by addItem.
     * @param newVal the new value, which must be smaller
     *    than the currently stored value.
     * @exception IllegalValue if newVal is larger
     *    than the currently stored value.
     */
    public void decreaseKey( PairNode p, Comparable newVal ) throws IllegalValue
    {
        if( p.element.lessThan( newVal ) )
            throw new IllegalValue( "Illegal DecreaseKey" );
        p.element = newVal;
        if( p != root )
        {
            if( p.nextSibling != null )
                p.nextSibling.prev = p.prev;
            if( p.prev.leftChild == p )
                p.prev.leftChild = p.nextSibling;
            else
                p.prev.nextSibling = p.nextSibling;
 
            p.nextSibling = null;
            root = compareAndLink( root, p );
        }
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
        root = null;
    }

    private int      currentSize;    // Number of elements in heap
    private PairNode root;
    private PairNode newNode = null; // Last node inserted

    /**
     * Internal method that is the basic operation to maintain order.
     * Links first and second together to satisfy heap order.
     * @param first root of tree 1, which may not be null.
     *    first.nextSibling MUST be null on entry.
     * @param second root of tree 2, which may be null.
     * @return result of the tree merge.
     */
    private PairNode compareAndLink( PairNode first, PairNode second )
    {
        if( second == null )
            return first;

        if( second.element.lessThan( first.element ) )
        {
            // Attach first as leftmost child of second
            second.prev = first.prev;
            first.prev = second;
            first.nextSibling = second.leftChild;
            if( first.nextSibling != null )
                first.nextSibling.prev = first;
            second.leftChild = first;
            return second;
        }
        else
        {
            // Attach second as leftmost child of first
            second.prev = first;
            first.nextSibling = second.nextSibling;
            if( first.nextSibling != null )
                first.nextSibling.prev = first;
            second.nextSibling = first.leftChild;
            if( second.nextSibling != null )
                second.nextSibling.prev = second;
            first.leftChild = second;
            return first;
        }
    }


    private PairNode [ ] doubleIfFull( PairNode [ ] array, int index )
    {
        if( index == array.length )
        {
            PairNode [ ] oldArray = array;

            array = new PairNode[ index * 2 ];
            for( int i = 0; i < index; i++ )
                array[ i ] = oldArray[ i ];
        }
        return array;
    }

        // The tree array for combineSiblings
    private PairNode [ ] treeArray = new PairNode[ 5 ];

    /**
     * Internal method that implements two-pass merging.
     * @param firstSibling the root of the conglomerate;
     *     assumed not null.
     */
    private PairNode combineSiblings( PairNode firstSibling )
    {
        if( firstSibling.nextSibling == null )
            return firstSibling;

            // Store the subtrees in an array
        int numSiblings = 0;
        for( ; firstSibling != null; numSiblings++ )
        {
            treeArray = doubleIfFull( treeArray, numSiblings );
            treeArray[ numSiblings ] = firstSibling;
            firstSibling.prev.nextSibling = null;  // break links
            firstSibling = firstSibling.nextSibling;
        }
        treeArray = doubleIfFull( treeArray, numSiblings );
        treeArray[ numSiblings ] = null;

            // Combine subtrees two at a time, going left to right
        int i = 0;
        for( ; i + 1 < numSiblings; i += 2 )
            treeArray[ i ] = compareAndLink( treeArray[ i ], treeArray[ i + 1 ] );

        int j = i - 2;

            // j has the result of last compareAndLink.
            // If an odd number of trees, get the last one.
        if( j == numSiblings - 3 )
            treeArray[ j ] = compareAndLink( treeArray[ j ], treeArray[ j + 2 ] );

            // Now go right to left, merging last tree with
            // next to last. The result becomes the new last.
        for( ; j >= 2; j -= 2 )
             treeArray[ j - 2 ] = compareAndLink( treeArray[ j - 2 ], treeArray[ j ] );

        return treeArray[ 0 ];
    }

        // Test program
    public static void main( String [ ] args )
    {
        PairHeap h = new PairHeap( );
        int numItems = 40000;
        int i = 37;

        try
        {
            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
               h.insert( new MyInteger( i ) );
            for( i = 1; i < numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i );

            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.insert( new MyInteger( i ) );
            for( i = 1; i <= numItems; i++ )
                if( ((MyInteger)( h.deleteMin( ) )).intValue( ) != i )
                    System.out.println( "Oops! " + i + " " );
        }
        catch( Underflow e )
          { System.out.println( "Underflow! (as expected)" + i  ); }
    }
}
