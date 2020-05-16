#program to convert the binary number entered to binary number
do
{
print("ENTER THE CHOICE\n1:DECIMAL TO BINARY\n2:BINARY TO DECIMAL\n");
$ch=<STDIN>;
if($ch==1)
{
print("ENTER A INTEGER NUMBER IN DECIMAL FORM\n");
$d=int(<STDIN>);
$d1=$d;
$r[0]=int(($d)%(2));
$d=int($d1/2);
$i=1;
while($d!=0)
{
	
	$r[$i]=($d)%(2);
	$d=int($d/2);
	$i++;
}
$n=$i;
printf("THE BINARY FORM OF %ld IS",$d1); 
printf("\n");
printf("%ld",$d);
for($i=$n;$i>=0;$i--)
{
	printf("%ld",$r[$i]);
}
print("\n");
}
elsif($ch==2)
{
	print("ENTER THE BINARY NUMBER --PRESS 'ENTER' BETWEEN EACH BINARY NUMBER---- ENTER 2 TO TERMINATE \n");
	$i=0;
	do
	{
		$a[$i]=<STDIN>;
		$check=$a[$i];
		$i++;
	}while($check!=2);
	$l=$i-1;
	#print("length is");
	#print($l,"\n");
	print("THE ENTERED BINARY NUMBER IS\n");
	for($i=0;$i<$l;$i++)
	{
		print($a[$i]);
	}
	$count=$l;
	$count--;
	for($i=$count;$i>=0;$i--)
	{
		$b[$count-$i]=(2**$i);
	}
	for($i=0;$i<$l;$i++)
	{
		$pro[$i]=($a[$i]*$b[$i]);
		$dec=$dec+$pro[$i];
	}
	print("THE DECIMAL EQUIVALENT IS : ",$dec);
	print("\n");
}
else
{
	print("INVALID CHOICE\n");
}
print("DO U WISH TO CONTINUE\n1:CONTINUE\nANY OTHER KEY TO EXIT\n");
$choice=<STDIN>;
}while($choice==1);
