#program to find the best route from given set of routes
print("ENTER THE STARTING POINT:\n");
print("ENTER X COORDINATE:");
$x1=<STDIN>; 
print("ENTER Y COORDINATE:");
$y1=<STDIN>;
print("ENTER THE ENDING POINT:\n");
print("ENTER X COORDINATE:");
$x=<STDIN>; 
print("ENTER Y COORDINATE:");
$y=<STDIN>;
print("ENTER THE NO OF ROUTES:\n");
$n=<STDIN>;
#@np=0;
for($j=1;$j<=$n;$j++)
{
  print("ENTER THE NO OF POINTS IN THE ",$j," ROUTE:");
  $np[$j]=<STDIN>;
  for($i=1;$i<=$np[$j];$i++)
  {
    print("ENTER THE ",$i," POINT:\n");
    print("ENTER THE X COORDINATE:");
    $x[$j][$i]=<STDIN>;
    print("ENTER THE Y COORDINATE:");
    $y[$j][$i]=<STDIN>;
  }
}
for($j=1;$j<=$n;$j++)
{
	$b[$j][1]=sqrt((($x1-$x[$j][1])*($x1-$x[$j][1]))+(($y1-$y[$j][1])*($y1-$y[$j][1])));
	for($i=2;$i<=$np[$j];$i++)
	{
		$b[$j][$i]=$b[$j][$i-1]+sqrt((($x[$j][$i-1]-$x[$j][$i])*($x[$j][$i-1]-$x[$j][$i]))+(($y[$j][$i-1]-$y[$j][$i])*($y[$j][$i-1]-$y[$j][$i])));
	}
	$d[$j]=$b[$j][$np[$j]]+sqrt((($x-$x[$j][$np[$j]])*($x-$x[$j][$np[$j]]))+(($y-$y[$j][$np[$j]])*($y-$y[$j][$np[$j]])));
	
}

for($i=1;$i<=$n;$i++)
{
  	print("THE DISTANCE OF THE ",$i," ROUTE IS:");
	print(" ",$d[$i],"\n");
}
$min=$d[1];
$index=1;
for($i=2;$i<=$n;$i++)
{
	if($d[$i]<$min)
	{
		$min=$d[$i];
		$index=$i;
	}
}
print("THE BEST ROUTE IS  ",$index," ROUTE\n");

