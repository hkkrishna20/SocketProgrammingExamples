#program to multiply matrices using stratssen method
print("ENTER THE FIRST MATRIX\n");
for($i=0;$i<2;$i++)
{
	for($j=0;$j<2;$j++)
	{
		$a[$i][$j]=<STDIN>;
	}
}
print("ENTER THE SECOND MATRIX\n");
for($i=0;$i<2;$i++)
{
	for($j=0;$j<2;$j++)
	{
		$b[$i][$j]=<STDIN>;
	}
}
$m1=(($a[0][0]+$a[1][1])*($b[0][0]+$b[1][1])); 
$m2=(($a[1][0]+$a[1][1])*$b[0][0]);
$m3=($a[0][0]*($b[0][1]-$b[1][1]));
$m4=($a[1][1]*($b[1][0]-$b[0][0]));
$m5=(($a[0][0]+$a[0][1])*$b[1][1]);
$m6=(($a[1][0]-$a[0][0])*($b[0][0]+$b[0][1]));
$m7=(($a[0][1]-$a[1][1])*($b[1][0]+$b[1][1]));

$c[0][0]=$m1+$m4-$m5+$m7;
$c[0][1]=$m3+$m5;
$c[1][0]=$m2+$m4;
$c[1][1]=$m1+$m3-$m2+$m6;
print("THE RESULTANT MATRIX MULTIPLICATION IS:\n");
for($i=0;$i<2;$i++)
{
	for($j=0;$j<2;$j++)
	{
		print($c[$i][$j],"  ");
	}
	print("\n");
}