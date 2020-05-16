package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// AATree class
//
// CONSTRUCTION: with no initializer
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
// Insert throws DuplicateItem if item is already in the tree

/**
 * Implements an AA-tree.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 */
public class AATree implements SearchTree
{
    /**
     * Construct the tree.
     */
    public AATree( )
    {
        root = nullNode;
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @exception DuplicateItem if an item
     *        that matches x is already in the tree.
     */
    public void insert( Comparable x ) throws DuplicateItem
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *        that matches x can be found in the tree.
     */
    public void remove( Comparable x ) throws ItemNotFound
    {
        deletedNode = nullNode;
        root = remove( x, root );
    }

    /**
     * Remove the smallest item from the tree.
     * @exception ItemNotFound if the tree is empty.
     */
    public void removeMin( ) throws ItemNotFound
    {
        Comparable min = findMin( );
        remove( min );
    }

    /**
     * Find the smallest item in the tree.
     * @return the smallest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMin( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "AATree findMin" );

        BinaryNode ptr = root;

        while( ptr.left != nullNode )
            ptr = ptr.left;

        return ptr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMax( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "AATree findMax" );

        BinaryNode ptr = root;

        while( ptr.right != nullNode )
            ptr = ptr.right;

        return ptr.element;
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
        BinaryNode current = root;
        nullNode.element = x;

        for( ; ; )
        {
            if( x.lessThan( current.element ) )
                 current = current.left;
            else if( current.element.lessThan( x ) ) 
                 current = current.right;
            else if( current != nullNode )
                 return current.element;
            else
                 throw new ItemNotFound( "AATree find" );
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == nullNode;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( root == nullNode )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @exception DuplicateItem if item that
     *        matches x is already in the subtree rooted at t.
     */
    private BinaryNode insert( Comparable x, BinaryNode t ) throws DuplicateItem
    {
        if( t == nullNode )
            t = new BinaryNode( x, nullNode, nullNode );
        else if( x.compares( t.element ) < 0 )
            t.left = insert( x, t.left );
        else if( x.compares( t.element ) > 0 )
            t.right = insert( x, t.right );
        else
            throw new DuplicateItem( "SearchTree insert" );

        t = skew( t );
        t = split( t );
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @exception ItemNotFound no item that
     *        matches x is in the subtree rooted at t.
     */
    private BinaryNode remove( Comparable x, BinaryNode t ) throws ItemNotFound
    {
        if( t != nullNode )
        {
            // Step 1: Search down the tree and set lastNode and deletedNode
            lastNode = t;
            if( x.lessThan( t.element ) )
                t.left = remove( x, t.left );
            else
            {
                deletedNode = t;
                t.right = remove( x, t.right );
            }

            // Step 2: If at the bottom of the tree and
            //         x is present, we remove it
            if( t == lastNode )
            {
                if( deletedNode == nullNode || x.compares( deletedNode.element ) != 0 )
                    throw new ItemNotFound( "AATree remove" );
                deletedNode.element = t.element;
                deletedNode = nullNode;
                t = t.right;
            }

            // Step 3: Otherwise, we are not at the bottom; rebalance
            else
                if( t.left.level < t.level - 1 || t.right.level < t.level - 1 )
                {
                    if( t.right.level > --t.level )
                        t.right.level = t.level;
                    t = skew( t );
                    t.right = skew( t.right );
                    t.right.right = skew( t.right.right );
                    t = split( t );
                    t.right = split( t.right );
                }
        }
        return t;
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
     * Skew primitive for AA-trees.
     * @param t the node that roots the tree.
     * @return the new root after the rotation.
     */
    private BinaryNode skew( BinaryNode t )
    {
        if( t.left.level == t.level )
            t = Rotations.withLeftChild( t );
        return t;
    }

    /**
     * Split primitive for AA-trees.
     * @param t the node that roots the tree.
     * @return the new root after the rotation.
     */
    private BinaryNode split( BinaryNode t )
    {
        if( t.right.right.level == t.level )
        {
            t = Rotations.withRightChild( t );
            t.level++;
        }
        return t;
    }

    private BinaryNode root;
    private static BinaryNode nullNode;
        static         // Static initializer for NullNode
        {
            nullNode = new BinaryNode( null );
            nullNode.left = nullNode.right = nullNode;
            nullNode.level = 0;
        }

    private static BinaryNode deletedNode;
    private static BinaryNode lastNode;



        // Test program; should print min and max and nothing else
    public static void main( String [ ] args )
    {
        SearchTree t = new AATree( );
        final int NUMS = 40000;
        final int GAP  =   307;

        System.out.println( "Checking... (no more output means success)" );

        try
        {
            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                t.insert( new MyInteger( i ) );

            for( int i = 1; i < NUMS; i+= 2 )
                t.remove( new MyInteger( i ) );

            if( NUMS < 40 )
                t.printTree( );
            if( ((MyInteger)(t.findMin( ))).intValue( ) != 2 ||
                ((MyInteger)(t.findMax( ))).intValue( ) != NUMS - 2 )
                System.out.println( "FindMin or FindMax error!" );

            for( int i = 2; i < NUMS; i+=2 )
                 t.find( new MyInteger( i ) );

            for( int i = 1; i < NUMS; i+=2 )
            {
                try
                  { System.out.println( "OOPS!!! " + t.find( new MyInteger( i ) ) ); }
                catch( ItemNotFound e )
                  { }
            }
        }
        catch( DuplicateItem e )
          { System.out.println( e ); }
        catch( ItemNotFound e )
          { System.out.println( e ); }
    }
}