#program to implement  the warshalls algorithm 
print("Enter the no of vertices\n");
$n=<STDIN>;
print("Enter the adjacency matrix\n"); 
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		$r[$i][$j]=<STDIN>;
	}
}
for($k=1;$k<=$n;$k++)
{
	for($i=1;$i<=$n;$i++)
	{
		for($j=1;$j<=$n;$j++)
		{
			
			$r[$i][$j]=$r[$i][$j]+$r[$i][$k]*$r[$k][$j];
		}
	}
}
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		if($r[$i][$j]>0)
		{
			$r[$i][$j]=1;
		}
	}
}
print("The Transitive closure is:\n");
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		print($r[$i][$j],"  ");
	}
	print("\n");
}
