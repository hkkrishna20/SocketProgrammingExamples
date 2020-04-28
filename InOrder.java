package DataStructures;

import Exceptions.*;

// InOrder class; maintains "current position"
//     according to an inorder traversal
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
 * Inorder iterator class.
 * @author Mark Allen Weiss
 */
public class InOrder extends PostOrder
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public InOrder( BinarySearchTree theTree )
    {
        super( theTree );
    }

     /**
      * Advance the current position to the next node in the tree,
      *     according to the inorder traversal scheme.
      * @exception ItemNotFound if the current position is null.
      */
    public void advance( ) throws ItemNotFound
    {
        if( s.isEmpty( ) )
        {
            if( current == null )
                throw new ItemNotFound( "InOrder advance" );
            current = null;
            return;
        }

        StNode cnode;

        for( ; ; )
        {
            try
              { cnode = ( StNode ) s.topAndPop( ); }
            catch( Underflow e )
              { return; } // Cannot happen

            if( ++cnode.timesPopped == 2 )
            {
                current = cnode.node;
                if( cnode.node.right != null )
                    s.push( new StNode( cnode.node.right ) );
                return;
            }

                // First time through
            s.push( cnode );
            if( cnode.node.left != null )
                s.push( new StNode( cnode.node.left ) );
        }
    }
}
