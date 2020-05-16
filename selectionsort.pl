#program to sort elements using selection sort
print("ENTER THE NO OF ELEMENTS IN THE ARRAY\n");
$n=<STDIN>;
print("ENTER ELEMENTS IN TO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
for($i=0;$i<$n-1;$i++)
{
	$min=$i;
	for($j=$i+1;$j<$n;$j++)
	{
		if($a[$j]<$a[$min])
		{
			$min=$j;
		}
	}
			$temp=$a[$i];
			$a[$i]=$a[$min];
			$a[$min]=$temp;	
}
print("THE ELEMENTS AFTER SORTING ARE \n");
print @a;
