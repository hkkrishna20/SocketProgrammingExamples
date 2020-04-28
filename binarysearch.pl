#program to perform the binary search
print("ENTER THE NO OF ELEMENTS\n");
$n=<STDIN>;
print("ENTER THE ELEMENTS IN TO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
print("ENTER THE KEY ELEMENT TO BE SEARCHED\n");
$k=<STDIN>;
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
print("THE ARRAY ELEMENTS AFTER SORTING ARE \n");
print @a;
$l=0;
$r=$n;
while($l<=$r)
{
	$m=(($l+$r)/2);
	if($k==$a[$m])
	{
		print("ELEMENT IS FOUND IN THE ARRAY\n");
		exit;
	}
	elsif($k<$a[$m])
	{
		$r=($m-1);
	}
	else
	{
		$l=($m+1);
	}
}
print("ELEMENT IS NOT FOUND IN THE ARRAY \n");

 
