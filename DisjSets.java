package DataStructures;

// DisjSets class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

/**
 * Disjoint set class, using union by rank
 * and path compression.
 * Elements in the set are numbered starting at 0.
 * @author Mark Allen Weiss
 */
public class DisjSets
{
    /**
     * Construct the disjoint sets object.
     * @param numElements the initial number of disjoint sets.
     */
    public DisjSets( int numElements )
    {
        array = new int [ numElements ];
        for( int i = 0; i < array.length; i++ )
            array[ i ] = -1;
    }

    /**
     * Union two disjoint sets using the height heuristic.
     * For simplicity, we assume root1 and root2 are distinct
     * and represent set names.
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union( int root1, int root2 )
    {
        if( array[ root2 ] < array[ root1 ] )  /* root2 is deeper */
            array[ root1 ] = root2;        /* Make root2 new root */
        else
        {
            if( array[ root1 ] == array[ root2 ] )
                array[ root1 ]--;        /* Update height if same */
            array[ root2 ] = root1;        /* Make root1 new root */
        }
    }

    /**
     * Perform a find with path compression.
     * Error checks omitted again for simplicity.
     * @param x the element being searched for.
     * @return the set containing x.
     */
    public int find( int x )
    {
        if( array[ x ] < 0 )
            return x;
        else
            return array[ x ] = find( array[ x ] );
    }

    private int [ ] array;


    // Test main; all finds on same output line should be identical
    public static void main( String [ ] args )
    {
        int NumElements = 128;
        int NumInSameSet = 16;

        DisjSets s = new DisjSets( NumElements );
        int set1, set2;

        for( int k = 1; k < NumInSameSet; k *= 2 )
        {
            for( int j = 0; j + k < NumElements; j += 2 * k )
            {
                set1 = s.find( j );
                set2 = s.find( j + k );
                s.union( set1, set2 );
            }
        }

        for( int i = 0; i < NumElements; i++ )
        {
            System.out.print( s.find( i )+ "*" );
            if( i % NumInSameSet == NumInSameSet - 1 )
                System.out.println( );
        }
        System.out.println( );
    }
}
