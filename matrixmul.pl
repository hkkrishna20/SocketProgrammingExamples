print("ENTER THE ORDER OF THE FIRST MATRIX\n");
$m=<STDIN>;
$n=<STDIN>;
print("ENTER THE ORDER OF THE SECOND MATRIX\n");
$p=<STDIN>;
$q=<STDIN>;
print("ENTER THE FIRST MATRIX\n");
for($i=0;$i<$m;$i++)
{
	for($j=0;$j<$n;$j++)
	{
		$a[$i][$j]=<STDIN>;
	}
}
print("THE FIRST MATRIX IS\n");
for($i=0;$i<$m;$i++)
{
	for($j=0;$j<$n;$j++)
	{
		print($a[$i][$j]);
		print(" ");
	}
	print("\n");
}
print("ENTER THE SECOND MATRIX\n");
for($i=0;$i<$p;$i++)
{
	for($j=0;$j<$q;$j++)
	{
		$b[$i][$j]=<STDIN>;
	}
}
print("THE SECOND MATRIX IS\n");
for($i=0;$i<$p;$i++)
{
	for($j=0;$j<$q;$j++)
	{
		print($b[$i][$j]);
		print(" ");
	}
	print("\n");
}
if($n==$p)
{
	for($i=0;$i<$m;$i++)
	{
		for($k=0;$k<$n;$k++)
		{
			for($j=0;$j<$q;$j++)
			{
				$c[$i][$j]=($c[$i][$j]+($a[$i][$k]*$b[$k][$j]));
			}
		}
	}
	print("THE MULTIPLICATION OF MATRICES IS\n");
	for($i=0;$i<$p;$i++)
	{
		for($j=0;$j<$q;$j++)
		{
			print($c[$i][$j]);
			print(" ");
		}
		print("\n");
	}	

}
else
{
	print("MATRIX MULTIPLICATION IS NOT POSSIBLE\n");
}
 


 
