package DataStructures;

import Exceptions.*;
import Supporting.MyInteger;  // Only needed for test program;  not in text

// TreeIterator class; maintains "current position"
//
// CONSTRUCTION: with tree to which iterator is bound
//
// ******************PUBLIC OPERATIONS**********************
//     first and advance are abstract; others are final
// boolean isValid( )   --> True if at valid position in tree
// Object retrieve( )   --> Return item in current position
// void first( )        --> Set current position to first
// void advance( )      --> Advance (prefix)
// ******************ERRORS*********************************
// Exceptions thrown for illegal access or advance

/**
 * Tree iterator class.
 * @author Mark Allen Weiss
 */
abstract public class TreeIterator
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public TreeIterator( BinarySearchTree theTree )
    {
        t = theTree;
        current = null;
    }

    /**
     * Set the current position to the first item, according
     * to the traversal scheme.
     */
    abstract public void first( );

    /**
     * Test if current position references a valid tree item.
     * @return true if the current position is not null; false otherwise.
     */
    final public boolean isValid( )
    {
        return current != null;
    }

    /**
     * Return the item stored in the current position.
     * @return the stored item.
     * @exception ItemNotFound if the current position is invalid.
     */
    final public Object retrieve( ) throws ItemNotFound
    {
        if( current == null )
            throw new ItemNotFound( "TreeIterator retrieve" );
        return current.element;
    }

     /**
      * Advance the current position to the next node in the tree,
      *     according to the traversal scheme.
      * If the current position is null, then throw an exception.
      * This is the alternate strategy, that we did not use for lists.
      * @exception ItemNotFound if the current position is null.
      */
    abstract public void advance( ) throws ItemNotFound;

        /** The tree. */
    protected BinarySearchTree t;    // Tree
        /** Current position. */
    protected BinaryNode current;    // Current position

        // Test program
    public static void main( String[ ] args )
    {
        BinarySearchTree t = new BinarySearchTree( );

        testItr( "PreOrder", new PreOrder( t ) ); // Test empty tree

        try
        {
            t.insert( new MyInteger( 4 ) );
            t.insert( new MyInteger( 2 ) );
            t.insert( new MyInteger( 6 ) );
            t.insert( new MyInteger( 1 ) );
            t.insert( new MyInteger( 3 ) );
            t.insert( new MyInteger( 5 ) );
            t.insert( new MyInteger( 7 ) );
        }
        catch( Exception e )
          { }

        testItr( "Preorder", new PreOrder( t ) );
        testItr( "Postorder", new PostOrder( t ) );
        testItr( "Inorder", new InOrder( t ) );
        testItr( "Level order", new LevelOrder( t ) );
    }

    public static void testItr( String type, TreeIterator itr )
    {
        try
        {
            System.out.print( type + ":" );
            for( itr.first( ); itr.isValid( ); itr.advance( ) )
                System.out.print( " " + itr.retrieve( ) );
            System.out.println( );
            itr.advance( );
        }
        catch( ItemNotFound E )
          { System.out.println( E + " (as expected)" ); }
    }
}
