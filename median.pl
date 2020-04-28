#program to find the median of the numbers
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
#print @a;
if(($n % 2)==1)
{
	$m=($n+1)/2;
	printf("THE MEDIAN IS %d\n",$a[$m]);
}
else
{
	$m=$n/2;
	$x=($a[$m]+$a[$m+1])/2;
	printf("THE MEDIAN IS %f\n",$x);
}