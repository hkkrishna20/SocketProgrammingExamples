#program to find the minimum spanning tree using prims algorithm
print("Enter the no of vertices\n");
$n=<STDIN>;
# print("Enter the vertices\n"); 
# @vertex=<STDIN>;
print("Enter the adjacency matrix\nEnter 999 if no edge exists");
for($i=0;$i<$n;$i++)
{
	for($j=0;$j<$n;$j++)
	{
		$adj[$i][$j]=<STDIN>;
	}
}

