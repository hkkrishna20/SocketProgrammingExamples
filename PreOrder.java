package DataStructures;

import Exceptions.*;

// PreOrder class; maintains "current position"
//     according to a preorder traversal
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
 * Preorder iterator class.
 * @author Mark Allen Weiss
 */
public class PreOrder extends TreeIterator
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public PreOrder( BinarySearchTree theTree )
    {
        super( theTree );
        s = new StackAr( );
        s.push( t.root );
    }

    /**
     * Set the current position to the first item, according
     * to the preorder traversal scheme.
     */
    public void first( )
    {
        s.makeEmpty( );
        if( t.root != null )
            s.push( t.root );
        try
          { advance( ); }
        catch( ItemNotFound e ) { } // Empty tree
    }

     /**
      * Advance the current position to the next node in the tree,
      *     according to the preorder traversal scheme.
      * @exception ItemNotFound if the current position is null.
      */
    public void advance( ) throws ItemNotFound
    {
        if( s.isEmpty( ) )
        {
            if( current == null )
                throw new ItemNotFound( "PreOrder Advance" );
            current = null;
            return;
        }

        try
          { current = ( BinaryNode ) s.topAndPop( ); }
        catch( Underflow e )
          { return; } // Cannot happen

        if( current.right != null )
            s.push( current.right );
        if( current.left != null )
            s.push( current.left );
    }

        /** An internal stack of visited nodes */
    private Stack s;    // Stack of TreeNode objects
}
