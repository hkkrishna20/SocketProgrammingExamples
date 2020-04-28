#program to find whether a number n is prime or not
print("ENTER A NUMBER\n");
$n=<STDIN>;
$j=1;
for($i=2;$i<$n;$i++)
{
	$j=$n % $i;
	if($j==0)
	{
		print"\n";
		print($n, "is not a prime number\n");
		break;
		exit;
	}
}

if($j!=0)	
	{
		print($n,"is a prime\n");
	}
	
