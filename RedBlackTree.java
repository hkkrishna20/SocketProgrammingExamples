package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// RedBlackTree class
//
// CONSTRUCTION: with a negative infinity sentinel
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove smallest item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Most routines throw ItemNotFound on various degenerate conditions
// insert throws DuplicateItem if item is already in the tree

/**
 * Implements a red black tree.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 */
public class RedBlackTree implements SearchTree
{
    /**
     * Construct the tree.
     * @param negInf a value less than or equal to all others.
     */
    public RedBlackTree( Comparable negInf )
    {
        header      = new BinaryNode( negInf );
        header.left = header.right = nullNode;
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @exception DuplicateItem if an item
     *        that matches x is already in the tree.
     */
    public void insert( Comparable x ) throws DuplicateItem
    {
        current = parent = grand = header;
        nullNode.element = x;

        while( current.element.compares( x ) != 0 )
        {
            great = grand; grand = parent; parent = current;
            current = x.lessThan( current.element ) ?
                         current.left : current.right;

                // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                 handleReorient( x );
        }

            // Insertion fails if already present
        if( current != nullNode )
            throw new DuplicateItem( "RedBlackTree insert" );
        current = new BinaryNode( x, nullNode, nullNode );

            // Attach to parent
        if( x.lessThan( parent.element ) )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( x );
    }

    /**
     * Remove from the tree.
     * Not implemented in this version.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *        that matches x can be found in the tree.
     */
    public void remove( Comparable x ) throws ItemNotFound
    {
        System.out.println( "Remove is not implemented" );
    }

    /**
     * Remove the smallest item from the tree.
     * Not implemented in this version.
     * @exception ItemNotFound if the tree is empty.
     */
    public void removeMin( ) throws ItemNotFound
    {
        System.out.println( "RemoveMin is not implemented" );
    }

    /**
     * Find the smallest item  the tree.
     * @return the smallest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMin( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "RedBlackTree findMin" );

        BinaryNode itr = header.right;

        while( itr.left != nullNode )
            itr = itr.left;

        return itr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMax( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "RedBlackTree findMax" );

        BinaryNode itr = header.right;

        while( itr.right != nullNode )
            itr = itr.right;

        return itr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item.
     * @exception ItemNotFound if no item
     *        that matches x can be found in the tree.
     */
    public Comparable find( Comparable x ) throws ItemNotFound
    {
        nullNode.element = x;
        current = header.right;

        for( ; ; )
        {
            if( x.lessThan( current.element ) )
                current = current.left;
            else if( current.element.lessThan( x ) ) 
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                throw new ItemNotFound( "RedBlackTree find" );
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        header.right = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.right == nullNode;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( header.right == null )
            System.out.println( "Empty tree" );
        else
            printTree( header.right );
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( BinaryNode t )
    {
        if( t != t.left )
        {
            printTree( t.left );
            System.out.println( t.element.toString( ) );
            printTree( t.right );
        }
    }

    /**
     * Internal routine that is called during an insertion
     *     if a node has two red children. Performs flip
     *     and rotatons.
     * @param item the item being inserted.
     */
    private void handleReorient( Comparable item )
    {
            // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( item.lessThan( grand.element ) != item.lessThan( parent.element ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private BinaryNode rotate( Comparable item, BinaryNode parent )
    {
        if( item.lessThan( parent.element ) )
            return parent.left = item.lessThan( parent.left.element ) ?
                Rotations.withLeftChild( parent.left )  :  // LL
                Rotations.withRightChild( parent.left ) ;  // LR
        else
            return parent.right = item.lessThan( parent.right.element ) ?
                Rotations.withLeftChild( parent.right ) :  // RL
                Rotations.withRightChild( parent.right );  // RR
    }


    private BinaryNode header;
    private static BinaryNode nullNode;
        static         // Static initializer for nullNode
        {
            nullNode = new BinaryNode( null );
            nullNode.left = nullNode.right = nullNode;
        }

    private static final int BLACK = 1;    // Black must be 1
    private static final int RED   = 0;

        // Used in insert routine and its helpers
    private static BinaryNode current;
    private static BinaryNode parent;
    private static BinaryNode grand;
    private static BinaryNode great;


        // Test program; should print min and max and nothing else
    public static void main( String [ ] args )
    {
        SearchTree t = new RedBlackTree( new MyInteger( Integer.MIN_VALUE ) );
        final int NUMS = 40000;
        final int GAP  =   307;

        System.out.println( "Checking... (no more output means success)" );

        try
        {
            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                t.insert( new MyInteger( i ) );

            if( NUMS < 40 )
                t.printTree( );
            if( ((MyInteger)(t.findMin( ))).intValue( ) != 1 ||
                ((MyInteger)(t.findMax( ))).intValue( ) != NUMS - 1 )
                System.out.println( "FindMin or FindMax error!" );

            for( int i = 2; i < NUMS; i+=2 )
                if( ((MyInteger)(t.find( new MyInteger( i ) ))).intValue( )
                          != i )
                    System.out.println( "Error! at " + i );
            try
              { t.find( new MyInteger( 0 ) ); System.out.println( "OOPS -- 0" ); }
            catch( ItemNotFound e ) { }
        }
        catch( DuplicateItem e )
          { System.out.println( e ); }
        catch( ItemNotFound e )
          { System.out.println( e ); }
    }
}