#program to perform the heap sort
print("Enter the no of elements\n");
$n=<STDIN>;
print("Enter the elements in to the array\n");
for($i=1;$i<=$n;$i++)
{
	$h[$i]=<STDIN>;
}
print("The heap tree is\n");
heapconstruct();
print(" ");
for($i=1;$i<=$n;$i++)
{
	print($h[$i]," ");
}
print("The sorted order is\n");
for($i=1;$i<=$n;$i++)
{
	heapdeletion();
}
sub heapdeletion
{
	heapconstruct();
	$dele=$h[1];
	print $dele;
	$h[1]=$h[$n];
	$h[$n]=0;
	$n--;
	#return @dele;
}
sub heapconstruct
{
	$m=$n/2;
	for($i=int($m);$i>=1;$i--)
	{
		$k=$i;
		$v=$h[$k];
		$heap=0;
		while((!$heap) && ((2*$k)<=$n))
		{
			$j=2*$k;
			if($j<$n)
			{
				if($h[$j]<$h[$j+1])
				{
					$j++;
				}
			}
			if($v>=$h[$j])
			{
				$heap=1;
			}
			else
			{
				$h[$k]=$h[$j];
				$k=$j;
			}
			$h[$k]=$v;
		}
	}
return @h;
}
 
