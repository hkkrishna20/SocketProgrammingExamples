package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

// SplayTree class
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
// Comparable getRoot( )  --> Return item at root
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Most routines throw ItemNotFound on various degenerate conditions
// insert throws DuplicateItem if item is already in the tree

/**
 * Implements a top-down splay tree.
 * Note that all "matching" is based on the compares method.
 * @author Mark Allen Weiss
 */
public class SplayTree implements SearchTree
{
    /**
     * Construct the tree.
     */
    public SplayTree( )
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
        if( newNode == null )
            newNode = new BinaryNode( null );
        newNode.element = x;

        if( root == nullNode )
        {
            newNode.left = newNode.right = nullNode;
            root = newNode;
        }
        else
        {
            root = splay( x, root );
            if( x.lessThan( root.element ) )
            {
                newNode.left = root.left;
                newNode.right = root;
                root.left = nullNode;
                root = newNode;
            }
            else
            if( root.element.lessThan( x ) )
            {
                newNode.right = root.right;
                newNode.left = root;
                root.right = nullNode;
                root = newNode;
            }
            else
                throw new DuplicateItem( "SplayTree insert" );
        }
        newNode = null;   // So next insert will call new
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *        that matches x can be found in the tree.
     */
    public void remove( Comparable x ) throws ItemNotFound
    {
        BinaryNode newTree;

            // If x is found, it will be at the root
        root = splay( x, root );
        if( root.element.compares( x ) != 0 )
            throw new ItemNotFound( "SplayTree remove" );

        if( root.left == nullNode )
            newTree = root.right;
        else
        {
            // Find the maximum in the left subtree
            // Splay it to the root; and then attach right child
            newTree = root.left;
            newTree = splay( x, newTree );
            newTree.right = root.right;
        }
        root = newTree;
    }

    /**
     * Return item stored in the root.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable getRoot( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "SplayTree getRoot" );
        return root.element;
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
     * Not the most efficient implementation (uses two passes), but has correct
     *     amortized behavior.
     * A good alternative is to first call Find with parameter
     *     smaller than any item in the tree, then call findMin.
     * @return the smallest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMin( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "SplayTree findMin" );

        BinaryNode ptr = root;

        while( ptr.left != nullNode )
            ptr = ptr.left;

        root = splay( ptr.element, root );
        return ptr.element;
    }

    /**
     * Find the largest item in the tree.
     * Not the most efficient implementation (uses two passes), but has correct
     *     amortized behavior.
     * A good alternative is to first call Find with parameter
     *     larger than any item in the tree, then call findMax.
     * @return the largest item.
     * @exception ItemNotFound if the tree is empty.
     */
    public Comparable findMax( ) throws ItemNotFound
    {
        if( isEmpty( ) )
            throw new ItemNotFound( "SplayTree findMax" );

        BinaryNode ptr = root;

        while( ptr.right != nullNode )
            ptr = ptr.right;

        root = splay( ptr.element, root );
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
        root = splay( x, root );

        if( isEmpty( ) || root.element.compares( x ) != 0 )
            throw new ItemNotFound( "SplayTree find" );

        return root.element;
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
     * Internal method to perform a top-down splay.
     * The last accessed node becomes the new root.
     * This method may be overridden to use a different
     * splaying algorithm, however, the splay tree code
     * depends on the accessed item going to the root.
     * @param x the target item to splay around.
     * @param t the root of the subtree to splay.
     * @return the subtree after the splay.
     */
    protected BinaryNode splay( Comparable x, BinaryNode t )
    {
        BinaryNode leftTreeMax, rightTreeMin;

        header.left = header.right = nullNode;
        leftTreeMax = rightTreeMin = header;

        nullNode.element = x;   // Guarantee a match

        for( ; ; )
            if( x.lessThan( t.element ) )
            {
                if( x.lessThan( t.left.element ) )
                    t = Rotations.withLeftChild( t );
                if( t.left == nullNode )
                    break;
                // Link Right
                rightTreeMin.left = t;
                rightTreeMin = t;
                t = t.left;
            }
            else if( t.element.lessThan( x ) )
            {
                if( t.right.element.lessThan( x ) )
                    t = Rotations.withRightChild( t );
                if( t.right == nullNode )
                    break;
                // Link Left
                leftTreeMax.right = t;
                leftTreeMax = t;
                t = t.right;
            }
            else
                break;

        leftTreeMax.right = t.left;
        rightTreeMin.left = t.right;
        t.left = header.right;
        t.right = header.left;
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


    private BinaryNode root;
    private static BinaryNode nullNode;
        static         // Static initializer for nullNode
        {
            nullNode = new BinaryNode( null );
            nullNode.left = nullNode.right = nullNode;
        }

    private static BinaryNode newNode = null;  // Used between different inserts
    private static BinaryNode header = new BinaryNode( null ); // For Splay


        // Test program; should print min and max and nothing else
    public static void main( String [ ] args )
    {
        SearchTree t = new SplayTree( );
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
