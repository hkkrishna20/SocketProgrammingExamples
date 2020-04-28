#program to print the fibanocci sequence upto a number entered
print("ENTER THE NUMBER OF FIBANOCCI SERIES TERMS TO BE PRINTED\n");
$n=<STDIN>;
$a=0;
$b=1;
$c=($a+$b);
print("THE FIBANOCCI SERIES IS:\n");
print($a,"\n");
print($b,"\n");
$i=1;
while($i<$n)
{	
	print($c,"\n");
	$a=$b;
	$b=$c;
	$c=($a+$b);
	$i++;
} 
