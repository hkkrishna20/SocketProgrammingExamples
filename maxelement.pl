#program to find the maximum element in the given array
print("ENTER THE NO OF ELEMENTS IN TO THE ARRAY\n");
$n=<STDIN>;
print("ENTER THE ELEMENTS INTO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
$max=$a[0];
for($i=0;$i<$n;$i++)
{
	if($a[$i]>$max)
	{
		$max=$a[$i];
	}
}
print("THE MAXIMUM ELEMENT IS:",$max,"\n");