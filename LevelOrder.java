package DataStructures;

import Exceptions.*;

// LevelOrder class; maintains "current position"
//     according to a level-order traversal
// 
// CONSTRUCTION: with tree to which iterator is bound
//
// ******************PUBLIC OPERATIONS**********************
// boolean isValid( )   --> True if at valid position in tree
// Object retrieve( )   --> Return item in current position
// void first( )        --> Set current position to first
// void advance( )      --> Advance (prefix)
// ******************ERRORS*********************************
// Exceptions thrown for illegal access or advance

/**
 * Level-order iterator class.
 * @author Mark Allen Weiss
 */
public class LevelOrder extends TreeIterator
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public LevelOrder( BinarySearchTree theTree )
    {
        super( theTree );
        q = new QueueAr( );
        q.enqueue( t.root );
    }

    /**
     * Set the current position to the first item, according
     * to the level-order traversal scheme.
     */
    public void first( )
    {
        q.makeEmpty( );
        if( t.root != null )
            q.enqueue( t.root );
        try
          { advance( ); }
        catch( ItemNotFound e ) { } // Empty tree
    }

     /**
      * Advance the current position to the next node in the tree,
      *     according to the level-order traversal scheme.
      * @exception ItemNotFound if the current position is null.
      */
    public void advance( ) throws ItemNotFound
    {
        if( q.isEmpty( ) )
        {
            if( current == null )
                throw new ItemNotFound( "LevelOrder advance" );
            current = null;
            return;
        }

        try
          { current = ( BinaryNode ) q.dequeue( ); }
        catch( Underflow E )
          { return; } // Cannot happen

        if( current.left != null )
            q.enqueue( current.left );
        if( current.right != null )
            q.enqueue( current.right );
    }

        /** An internal queue of visited nodes */
    private Queue q;    // Queue of TreeNode objects
}
