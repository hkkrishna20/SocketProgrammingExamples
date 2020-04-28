#program to perform string matching
print("ENTER THE MAIN STRING\n");
$a=<STDIN>;
@t=split(//,$a);

print("ENTER THE SUB STRING\n");
$b=<STDIN>;
@p=split(//,$b);

$n=@t-1;
$m=@p-1;
for($i=0;$i<=$n-$m;$i++)
{
	$j=0;
	while($j<$m && $p[$j] eq $t[$i+$j])
	{
		$j++;
		$index=$j;
	}
}
	if($index==$m)
	{
		print("SUB STRING FOUND IN MAIN STRING\n");
	}
	else
	{
		print("SUB STRING NOT FOUND IN MAIN STRING\n");
	}
