#program to perform the distribution counting
print("Enter the lower limit of numbers\n");
$l=<STDIN>;
print("Enter the upper limit of numbers\n");
$u=<STDIN>;
printf("Enter the no of elements b/n %d and %d",$l,$u);
$n=<STDIN>;
print("Enter the elements in to array\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
for($j=0;$j<=($u-$l);$j++)
{
	$d[$j]=0;
}
for($i=0;$i<$n;$i++)
{
	$d[$a[$i]-$l]++;
}
for($j=1;$j<=($u-$l);$j++)
{
	$d[$j]=$d[$j-1]+$d[$j];
}
for($i=$n-1;$i>=0;$i--)
{
	$j=$a[$i]-$l;
	$s[$d[$j]-1]=$a[$i];
	$d[$j]=$d[$j]-1;
}
print("The elements sorted by distribution counting are\n");
print @s;
