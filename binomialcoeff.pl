#program to calculate the bimomial coefficient
print("Enter the value of n \n");
$n=<STDIN>;
print("Enter the value of k\n");
$k=<STDIN>;
for($i=0;$i<=$n;$i++)
{
	for($j=0;($j<=$i || $j<=$k);$j++)
	{
		if($j==0 || $j==$i)
		{
			$c[$i][$j]=1;
		}
		else
		{
			$c[$i][$j]=$c[$i-1][$j-1]+$c[$i-1][$j];
		}
	}
}
printf("The value of c(%d,%d) is %d\n",$n,$k,$c[$n][$k]);
#print(,"\n");
