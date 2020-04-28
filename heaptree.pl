#program to construct heap tree
print("Enter the no of elements\n");
$n=<STDIN>;
print("Enter the elements in to the array\n");
for($i=1;$i<=$n;$i++)
{
	$h[$i]=<STDIN>;
}
print("The heap tree is\n");
heapconstruct();
do
{
print("Enter the choice for heaptree\n1:insertion\n2:deletion of maxkey\n");
$ch=<STDIN>;
if($ch==1)
{	
		print("Enter the element to be inserted\n");
		$new=<STDIN>;
		$n++;
		$h[$n]=$new;
		print("After insertion the heaptree is\n");
		heapconstruct();
		
}
elsif($ch==2)
{
		$h[1]=$h[$n];
		$h[$n]=0;
		$n--;
		print("After deletion the heaptree is\n");
		heapconstruct();
		
}
else
{
		print("Invalid choice\n");
}
print("do u wish to continue\n1:continue\n2:exit\n");
$ch1=<STDIN>;
}while($ch1==1);
sub heapconstruct
{
	$m=$n/2;
	for($i=int($m);$i>=1;$i--)
	{
		$k=$i;
		$v=$h[$k];
		$heap=0;
		while((!$heap) && ((2*$k)<=$n))
		{
			$j=2*$k;
			if($j<$n)
			{
				if($h[$j]<$h[$j+1])
				{
					$j++;
				}
			}
			if($v>=$h[$j])
			{
				$heap=1;
			}
			else
			{
				$h[$k]=$h[$j];
				$k=$j;
			}
			$h[$k]=$v;
		}
	}
	for($i=1;$i<=$n;$i++)
	{
		print(" ",$h[$i]," ");
	}
}
