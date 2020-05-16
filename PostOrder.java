package DataStructures;

import Exceptions.*;

// PostOrder class; maintains "current position"
//     according to a postorder traversal
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
 * Postorder iterator class.
 * @author Mark Allen Weiss
 */
public class PostOrder extends TreeIterator
{
    /**
     * Construct the iterator.
     * The current position is set to null.
     * @param theTree the tree to which the iterator is
     *     permanently bound.
     */
    public PostOrder( BinarySearchTree theTree )
    {
        super( theTree );
        s = new StackAr( );
        s.push( new StNode( t.root ) );
    }

    /**
     * Set the current position to the first item, according
     * to the postorder traversal scheme.
     */
    public void first( )
    {
        s.makeEmpty( );
        if( t.root != null )
            s.push( new StNode( t.root ) );
        try
          { advance( ); }
        catch( ItemNotFound e ) { }  // Empty tree
    }

     /**
      * Advance the current position to the next node in the tree,
      *     according to the postorder traversal scheme.
      * @exception ItemNotFound if the current position is null.
      */
    public void advance( ) throws ItemNotFound
    {
        if( s.isEmpty( ) )
        {
            if( current == null )
                throw new ItemNotFound( "PostOrder Advance" );
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

            if( ++cnode.timesPopped == 3 )
            {
                current = cnode.node;
                return;
            }

            s.push( cnode );
            if( cnode.timesPopped == 1 )
            {
                if( cnode.node.left != null )
                    s.push( new StNode( cnode.node.left ) );
            }
            else  // cnode.timesPopped == 2
            {
                if( cnode.node.right != null )
                    s.push( new StNode( cnode.node.right ) );
            }
        }
    }

        /** An internal stack if visited nodes. */
    protected Stack s;    // The stack of StNode objects
}

