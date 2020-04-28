package DataStructures;

import Supporting.*;
import Exceptions.*;

// ProbingHashTable abstract class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Hashable find( x )     --> Return item that matches x
// void makeEmpty( )      --> Remove all items
// int hash( String str, int tableSize )
//                        --> Static method to hash strings
// ******************ERRORS********************************
// find and remove throw ItemNotFound
// insert overrides previous value if duplicate; not an error

/**
 * Probing table implementation of hash tables.
 * This is an abstract class that must be extended to
 * implement a particular probing algorithm, such as
 * quadratic probing.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */
public abstract class ProbingHashTable implements HashTable
{
    /**
     * Abstract method that performs collision resolution.
     * Each class must override this method only.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    protected abstract int findPos( Hashable x );

    /**
     * Construct the hash table.
     */
    public ProbingHashTable( )
    {
        allocateArray( DEFAULT_TABLE_SIZE );
        makeEmpty( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then replace it with the new item.
     * @param x the item to insert.
     */
    public final void insert( Hashable x )
    {
            // Insert x as active
        int currentPos = findPos( x );
        array[ currentPos ] = new HashEntry( x, true );
        if( ++currentSize < array.length / 2 )
            return;

            // REHASHING CODE
            // Save old table
        HashEntry [ ] oldArray = array;

            // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) );
        currentSize = 0;

            // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null && oldArray[ i ].isActive )
                insert( oldArray[ i ].element );

        return;
    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the hash table.
     */
    public final void remove( Hashable x ) throws ItemNotFound
    {
        int currentPos = findPos( x );
	assertFound( currentPos, "ProbingHashTable remove" );
        array[ currentPos ].isActive = false;
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     * @exception ItemNotFound if no item
     *     that matches x can be found in the hash table.
     */
    public final Hashable find( Hashable x ) throws ItemNotFound
    {
        int currentPos = findPos( x );
	assertFound( currentPos, "ProbingHashTable find" );
        return array[ currentPos ].element;
    }

    /**
     * If currentPos exists and is active do nothing.
     * Otherwise, throw an exception.
     * @param currentPos the result of a call to findPos.
     * @param message the String to construct the exception.
     * @exception ItemNotFound if inactive cell.
     */
    private final void assertFound( int currentPos, String message )
                                    throws ItemNotFound
    {
        if( array[ currentPos ] == null || !array[ currentPos ].isActive )
            throw new ItemNotFound( message );
    }

    /**
     * Make the hash table logically empty.
     */
    public final void makeEmpty( )
    {
        currentSize = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }

    /**
     * A hash routine for String objects.
     * @param key the String to hash.
     * @param tableSize the size of the hash table.
     * @return the hash value.
     */
    public final static int hash( String key, int tableSize )
    {
        int hashVal = 0;

        for( int i = 0; i < key.length( ); i++ )
            hashVal = 37 * hashVal + key.charAt( i );

        hashVal %= tableSize;
        if( hashVal < 0 )
            hashVal += tableSize;

        return hashVal;
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

        /** The array of elements. */
    protected HashEntry [ ] array; // The array of elements
    private int currentSize;       // The number of occupied cells

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private final void allocateArray( int arraySize )
    {
        array = new HashEntry[ arraySize ];
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private final static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private final static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
}
