#program to implement  the floyd's algorithm 
print("Enter the no of vertices\n");
$n=<STDIN>;
print("Enter the weight matrix\n"); 
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		$d[$i][$j]=<STDIN>;
	}
}
for($k=1;$k<=$n;$k++)
{
	for($i=1;$i<=$n;$i++)
	{
		for($j=1;$j<=$n;$j++)
		{
			$d[$i][$j]=min($d[$i][$j],($d[$i][$k]+$d[$k][$j]));
		}
	}
}
print("The Shortest path matrix is:\n");
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		printf("%d ",$d[$i][$j]);
	}
	print("\n");
}
sub min
{
	$sum=($d[$i][$k]+$d[$k][$j]);
	if($d[$i][$j]<$sum)
	{
		$d[$i][$j]=$d[$i][$j];
	}
	else
	{
		$d[$i][$j]=$sum;
	}
}