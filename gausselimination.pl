#program to solve system of equations using gauss elimination
print("Enter the order of system of equations\n");
$n=<STDIN>;
print("Enter the coefficient matrix of order nxn\n");  
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n;$j++)
	{
		$a[$i][$j]=<STDIN>;
	}
}
print("Enter the solution matrix\n");
for($i=1;$i<=$n;$i++)
{
	$b[$i]=<STDIN>;
}
for($i=1;$i<=$n;$i++)
{
	$a[$i][$n+1]=$b[$i];
}
print("New agument matrix is\n");
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n+1;$j++)
	{
		printf("%d ",$a[$i][$j]);
	}
	printf("\n");
}
for($i=1;$i<=$n-1;$i++)
{
	$pivotrow=$i;
	for($j=$i+1;$j<=$n;$j++)
	{
		if(abs($a[$j][$i])>abs($a[$pivotrow][$i]))
		{
			$pivotrow=$j;		
		}
		
	}
	for($k=$i;$k<=$n+1;$k++)
	{
		$temp=$a[$i][$k];
		$a[$i][$k]=$a[$pivotrow][$k];
		$a[$pivotrow][$k]=$temp;
	}
	for($j=$i+1;$j<=$n;$j++)
	{
		$temp=($a[$j][$i]/$a[$i][$i]);
		for($k=$i;$k<=$n+1;$k++)
		{
			$a[$j][$k]=$a[$j][$k]-$a[$i][$k]*$temp;
		}
	}
}
print("The solution is\n");
for($i=1;$i<=$n;$i++)
{
	for($j=1;$j<=$n+1;$j++)
	{
		printf("%d ",$a[$i][$j]);
	}
	printf("\n");
}
