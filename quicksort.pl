print "Enter the number of elements\n";
$n=<STDIN>;
print "Enter the elements\n";
for($i=0;$i<$n;$i++)
{
	$a[$i]=<STDIN>;
}
print "The elements before sorting are\n";
print @a;
$low=0;
quicksort($low,$n);
print "The elements after sorting are\n";
print @a;
sub quicksort
{
	$lo=@_[0];
	$hi=@_[1];
	$low=$lo;
	$n=$hi;
	if($lo>=$n)
	{
		return;
	}
	$temp= int (($lo+$hi)/2);
	print "@ ",$temp;
	$mid=$a[$temp];
	while ($lo < $hi)
	{
		while ($lo<$hi & $a[$lo] < $mid) 
		{
			$lo++;
		}
		while ($lo<$hi & $a[$hi] > $mid)
		{
			$hi--;
		}
		if ($lo < $hi)
		{
			$T = $a[$lo];
			$a[$lo] = $a[$hi];
			$a[$hi] = $T;
		}
	}
	if ($hi < $lo)
	{
		$T = $hi;
		$hi = $lo;
		$lo = $T;
	}
	if($lo!=n)
	{
	quicksort($low,$lo);
	}
	quicksort($lo == $low ? $lo+1 : $lo,$n);
}