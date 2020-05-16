#program to print the nth prime number
print("ENTER THE NUMBER UPTO WHICH PRIME NUMBERS ARE NEEDED\n");
$n=<STDIN>;

loop:if($n<=1)
{
	print("NO PRIMES ARE PRESENT BEFORE THE NUMBERED ENTERED\n");
	print("AGAIN ENTER A NUMBER\n");
	$n=<STDIN>;
	goto loop;
}
elsif($n>999999)
{
	print("MAXIMUM NUMBER EXCEEDED\n");
	print("AGAIN ENTER A NUMBER\n");
	$n=<STDIN>;
	goto loop;
}
for($p=2;$p<=$n;$p++)
{
	$a[$p]=$p;
}
for($p=2;$p<=sqrt($n);$p++)
{
	if($a[$p]!=0)
	{
		$j=$p*$p;
	}
	while($j<=$n)
	{
		$a[$j]=0;
		$j=$j+$p;
	}
}
$i=0;
for($p=2;$p<=$n;$p++)
{
	if($a[$p]!=0)
	{
		$l[$i]=$a[$p];
		$i++;
	}
}
$n1=$i;
print("THE PRIME NUMBERS ARE:\n");
#print("INDEX ----PRIMENUMBER\n");
for($i=0;$i<$n1;$i++)
{	
	print($i+1,"-----PRIME------",$l[$i],"\n");
}
$count=$i;
print("THE NUMBER OF PRIME NUMBERS IS:",$count,"\n");
print("ENTER THE INDEX OF PRIME NUMBER REQUIRED:");
$ch=<STDIN>;
loop1:if($ch>$count)
{
	print("THERE IS NO SUCH INDEX OF PRIME NUMBER IN THE BEFORE THE NUMBER ENTERED\n");
	print("RE ENTER WITHIN THE LIMIT\n");
	$ch=<STDIN>;
	goto loop1;
}
elsif($ch<1)
{
	print("THERE IS NO SUCH INDEX OF PRIME NUMBER IN THE BEFORE THE NUMBER ENTERED\n");
	print("RE ENTER WITHIN THE LIMIT\n");
	$ch=<STDIN>;
	goto loop1;
}
printf("THE %ld----PRIME IS: %ld",$ch,$l[$ch-1]);
print("\n");