package DataStructures;

import Supporting.*;
import Exceptions.*;
import Supporting.Comparable;

public class BinarySearch
{
    /**
     * Performs the standard binary search
     * using one comparison per level.
     * @exception ItemNotFound if appropriate.
     * @return index where item is found.
     */
    public static int binarySearch( Comparable [ ] a, Comparable x )
                                    throws ItemNotFound
    {
        if( a.length == 0 )
            throw new ItemNotFound( "Binary Search fails: empty" );

        int low = 0;
        int high = a.length - 1;
        int mid;

        while( low < high )
        {
            mid = ( low + high ) / 2;

            if( a[ mid ].compares( x ) < 0 )
                low = mid + 1;
            else
                high = mid;
        }

        if( a[ low ].compares( x ) == 0 )
            return low;

        throw new ItemNotFound( "BinarySearch fails" );
    }

    // Test program
    public static void main( String [ ] args )
    {
        int SIZE = 8;
        Comparable [ ] a = new MyInteger [ SIZE ];
        for( int i = 0; i < SIZE; i++ )
            a[ i ] = new MyInteger( i * 2 );

        for( int i = 0; i < SIZE * 2; i++ )
        {
            try
            {
                System.out.println( "Found " + i + " at " +
                                     binarySearch( a, new MyInteger( i ) ) );
            }
            catch( ItemNotFound e )
              { System.out.println( i + " not found" ); }
        }
    }
}