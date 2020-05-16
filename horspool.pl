#program to implement the horspool algorithm
print("Enter the text\n");
$t=<STDIN>;
print("Enter the pattern\n");
$p=<STDIN>;
@text=split(//,$t);
@pattern=split(//,$p);
$lt=@text;
$lp=@pattern;
$n=$lt-1;
$m=$lp-1;
for($i=1;$i<=26;$i++)
{
	$table[$i]=$m;
}
shifttable();
$i=$m-1;
#$check=0;
while($i<=$n-1)
{
	$k=0;
	while($k<=$m-1 && $pattern[$m-1-$k] eq $text[$i-$k])
	{
		$k++;
	}
	if($k==$m)
	{
		print("String matched\n");
		exit;
	}
	else
	{
		$a=$text[$i];
		$i=$i+$table[$a];
	}
}
if($k != $m)
{
	print("String not matched\n");
}

sub shifttable
{
	for($j=0;$j<$m-1;$j++)
	{
		$b=$pattern[$j];
		$table[$b]=$m-1-$j;
		#print($table[$b]);
	}
	print @table;
}

