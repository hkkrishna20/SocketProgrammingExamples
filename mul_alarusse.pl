#program to perform multiplication using alarusse
print("ENTER THE NUMBER n\n");
$n=<STDIN>;
print("ENTER THE NUMBER m\n");
$m=<STDIN>;
print("THE ALARUSEE TABLE IS:\n");
print("--------------------------\n");
print("n    m\n");
print("--------------------------\n");
printf("%d   %d\n",$n,$m);
while($n!=0)
{
	if((($n)%2)==0)
	{
		$n=$n/2;
		$m=$m*2;
		printf("%d   %d\n",$n,$m);
	}
	else
	{
		$n=int($n/2);
		$x=$x+$m;
		$m=$m*2;
		if($n>0)
		{
			printf("%d   %d   %d\n",$n,$m,($m/2));
		}
	}
}
print("THE PRODUCT IS:",$x);
print("\n");

