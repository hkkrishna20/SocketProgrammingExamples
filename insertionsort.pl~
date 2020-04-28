#program to perform the insertion sort on numbers
print("ENTER THE NO OF ELEMENTS IN THE ARRAY\n"); 
$n=<STDIN>;
print("ENTER THE ELEMENTS IN TO THE ARRAY\n");
for($i=1;$i<=$n;$i++)
{
	$a[$i]=<STDIN>;
}
for($i=1;$i<=$n;$i++)
{
	$v=$a[$i];
	$j=$i-1;
	while($j>=0 && $a[$j]>$v)
	{
		$a[$j+1]=$a[$j];
		$j=$j-1;
		$a[$j+1]=$v;
	}
	
}
print("THE SORTED ORDER IS\n");
print @a;