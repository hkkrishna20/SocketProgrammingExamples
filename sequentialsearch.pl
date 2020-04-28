#program to perform the sequential search
print("ENTER THE NO OF ELEMENTS IN ARRAY\n");
$n=<STDIN>;
print("ENTER THE ELEMENTS IN TO THE ARRAY\n");
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
do
{
	print("ENTER THE ELEMENT TO BE SEARCHED\n");
	$k=<STDIN>;
	$a[$n]=$k;
	$i=0;
	while($a[$i]!=$k)
	{	
		$i++;
	}
	if($i<$n)
	{
		print("ELEMENT FOUND IN THE ARRAY AT INDEX ",($i+1),"\n");
	}
	else
	{
		print("ELEMENT NOT FOUND IN THE ARRAY\n");
	}
	print("DO U WISH TO SEARCH OTHER ELEMENT\n1:CONTINUE\n2:EXIT\n");
	$ch=<STDIN>;
}while($ch==1);