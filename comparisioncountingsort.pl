#program to perform comparision counting sorting
print("Enter the no of elements\n");
$n=<STDIN>;
print("Enter the elements in to the array\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
	$count[$i]=0;
	$count1[$i]=0;
}
for($i=0;$i<$n;$i++)
{
	for($j=$i+1;$j<$n;$j++)
	{
		if($a[$i]<$a[$j])
		{
			$count[$j]++;
			$count1[$j]++;
		}
		else
		{
			$count[$i]++;
			$count1[$i]++;
		}
	}
	$final[$i]=$count1[$i];
	if($i<$n-1)
	{
		printf("After pass %d the count[] array is",$i);
		if($i>0 & $i<$n)
		{
			
			$count1[$i-1]='-';
		}
		for($k=0;$k<$n;$k++)
		{	
			
			print(" ",$count1[$k]," ");
		}
		print("\n");
	}
	
}
print("\n");
print("The finalstate of count[]array is");
for($i=0;$i<$n;$i++)
{
	print(" ",$final[$i]," ");	
}
print("\n");
for($i=0;$i<$n;$i++)
{
	$s[$count[$i]]=$a[$i];
}
print("The elements sorted by comparision counting are\n");
print @s;
