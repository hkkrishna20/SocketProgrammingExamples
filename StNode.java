package DataStructures;

import Exceptions.*;


    // An internal class for tree iterators
class StNode
{
    BinaryNode node;
    int timesPopped;

    StNode( BinaryNode n )
    {
       node = n;
       timesPopped = 0;
    }
}
