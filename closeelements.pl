#program to find the closest elements in an array entered#
print("ENTER THE NO OF ELEMENTS IN THE ARRAY\n");
$n=<STDIN>;
$a[$n];
print("ENTER THE ELEMENTS ARRAY\n");
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
print("THE SORTED ARRAY IS:\n");
for($i=0;$i<$n;$i++)
{
	print($a[$i]);
}
for($i=0;$i<$n-1;$i++)
{
	$b[$i]=($a[$i+1]-$a[$i]);
}
print("THE DIFFERENCE ARRAY IS:\n");
for($i=0;$i<$n;$i++)
{
	print($b[$i]);
	print("\n");
}
$min=$b[0];
$index=0;
for($i=1;$i<($n-1);$i++)
{
	if($b[$i]<$min)
	{
		$min=$b[$i];
		$index=$i;
	}
}
print("THE CLOSEST ELEMENTS IN THE ARRAY ARE:\n",$a[$index],$a[$index+1]);
print("\n");