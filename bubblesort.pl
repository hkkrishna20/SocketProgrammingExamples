#program to sort elements of an array using bubble sort
print("ENTER THE NO OF ELEMENTS IN THE ARRAY\n");
$n=<STDIN>;
print("ENTER ELEMENTS IN TO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
for($i=0;$i<$n;$i++)
{
	for($j=0;$j<($n-1);$j++)
	{
		if($a[$j]>$a[$j+1])
		{
			$temp=$a[$j];
			$a[$j]=$a[$j+1];
			$a[$j+1]=$temp;
		}
	}
}
print("THE ELEMENTS AFTER SORTING ARE \n");
print @a;