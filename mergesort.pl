#program to perform the mergesort on given arrays
print("ENTER THE NO OF ELEMENTS IN THE FIRST ARRAY\n");
$n1=<STDIN>;
print("ENTER THE ELEMENTS IN TO THE FIRST ARRAY\n");
for($i=0;$i<$n1;$i++)
{
	$b[$i]=<STDIN>;
}
print("ENTER NO OF ELEMENTS IN THE SECOND ARRAY\n");
$n2=<STDIN>;
print("ENTER THE ELEMENTS IN TO THE SECOND ARRAY\n");
for($i=0;$i<$n2;$i++)
{
	$c[$i]=<STDIN>;
}
$i=0;$j=0;$k=0;
$p=$n1;
$q=$n2;
while($i<$p && $j<$q)
{
	if($b[$i]<=$c[$j])
	{
		$a[$k]=$b[$i];
		$i++;
	}
	else
	{
		$a[$k]=$c[$j];
		$j++;
	}
	$k++;
}
print($i," ",$j," ",$k,"\n");
if($i==$p)
{
	for($i=$j;$i<$q;$i++)
	{
		$a[$k]=$c[$i];
	}
}
else
{
	for($i=$j;$i<$q;$i++)
	{
		$a[$k]=$b[$i];
	}
}
print("THE SORTED ORDER IS\n");
print(@a);