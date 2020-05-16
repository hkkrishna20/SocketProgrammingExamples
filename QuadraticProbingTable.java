package DataStructures;

import Supporting.*;

// QuadraticProbingTable class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Hashable find( x )     --> Return item that matches x
// void makeEmpty( )      --> Remove all items
// int hash( String str, int tableSize )
//                        --> Static method to hash Strings
// ******************ERRORS********************************
// find and remove throw ItemNotFound
// insert overrides previous value if duplicate; not an error

/**
 * Quadratic probing implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */
public class QuadraticProbingTable extends ProbingHashTable
{
    /**
     * Method that performs quadratic probing resolution.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    protected final int findPos( Hashable x )
    {
        int collisionNum = 0;
        int currentPos = x.hash( array.length );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            currentPos += 2 * ++collisionNum - 1;  // Compute ith probe
            if( currentPos >= array.length )       // Implement the mod
                currentPos -= array.length;
        }

        return currentPos;
    }

    // Simple main
    public static void main( String [ ] args )
    {
        HashTable H = new QuadraticProbingTable( );

        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        try
        {
            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                H.insert( new MyInteger( i ) );

            for( int i = 1; i < NUMS; i+= 2 )
                H.remove( new MyInteger( i ) );

            for( int i = 2; i < NUMS; i+=2 )
                H.find( new MyInteger( i ) );

            for( int i = 1; i < NUMS; i+=2 )
            {
                try
                  { System.out.println( "OOPS!!! " + H.find( new MyInteger( i ) ) ); }
                catch( Exceptions.ItemNotFound e )
                  { }
            }
        }
        catch( Exceptions.ItemNotFound e )
          { System.out.println( e ); }
    }

}
