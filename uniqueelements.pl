#program to check whether all elements of the given array are distinct
print("ENTER THE NO OF ELEMENTS IN TO THE ARRAY\n");
$n=<STDIN>;
print("ENTER THE ELEMENTS INTO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
for($i=0;$i<$n-1;$i++)
{
	for($j=$i+1;$j<$n;$j++)
	{
		if($a[$i]==$a[$j])
		{
			print("THE ELEMENTS ARE NOT UNIQUE\n");
			exit;		
		}
	}
}
{
	print("THE ELEMENTS ARE UNIQUE\n");
	exit;	
}