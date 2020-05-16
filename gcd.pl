#program to calculate gcd#
print("ENTER THE FIRST NUMBER\n");
$m=<STDIN>; 
print("ENTER THE SECOND NUMBER\n");
$n=<STDIN>;
if($m>$n)
{	
	while(($m%$n)!=0)
	{
		$r=$m%$n;
		$m=$n;
		$n=$r;
	}
	print("GCD IS:   ",$n);
	print("\n");
}
else
{
	$temp=$m;
	$m=$n;
	$n=$temp;
	while(($m%$n)!=0)
	{
		$r=$m%$n;
		$m=$n;
		$n=$r;
	}
	print("GCD IS:\n",$n);
	print("\n");
}
