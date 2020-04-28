print "Enter the names of four cities\n";
for($i=0;$i<4;$i++)
{
	$c[$i]=<STDIN>;
}
print "Enter the distances between the four cities\n";
for($i=0;$i<4;$i++)
{
	for($j=0;$j<4;$j++)
	{
		
			print "Enter the distance between the city $c[$i] and the city $c[$j] is:\n";
			$a[$i][$j]=<STDIN>;
	}
}
$dmin=10000;
for($i=0;$i<4;$i++)
{
	for($j=0;$j<4;$j++)
	{
		for($k=0;$k<4;$k++)
		{
			for($l=0;$l<4;$l++)
			{
				if(($i!=$j)&&($j!=$k)&&($k!=$i)&&($l!=$i)&&($l!=$j)&&($l!=$k))
				{
					$dis=$a[$i][$j]+$a[$j][$k]+$a[$k][$l]+$a[$l][$i];
					if($dis<$dmin)
					{
						$dmin=$dis;
						$x[0]=$c[$i];
						$x[1]=$c[$j];
						$x[2]=$c[$k];
						$x[3]=$c[$l];
					}
				}
			}
		}
	}
}
print "The minimum distance is:$dmin\n";
print "The optimal route is:\n";
print("->");
for($i=0;$i<4;$i++)
{
	print "$x[$i]->";
}
print "$x[0]";