#program to generate the subsets for the given list
print("Enter the list of elements for which subsets is to be generated\n");
print("Enter ctrl+d to terminate\n");
@list=<STDIN>;
$n=@list;
$N=2**$n; 
print("The subsets are\n");
print("{ (/) }");
print("\n");
for($i=1;$i<$N;$i++)
{
		@bin=binary_gen($i);
		#print @bin;
		#print "\n";
		$l=0;
		if(@bin<$n)
		{
			for($j=0;$j<($n-@bin);$j++)
			{
				$sub[$l]=0;
				$l++;
			}
			for($k=0;$k<@bin;$k++)
			{
				$sub[$l]=$bin[$k];
				$l++;
			}
		
		}
		else
		{
			for($k=0;$k<@bin;$k++)
			{
				$sub[$l]=$bin[$k];
				$l++;
			}
		}
		print"{";
		for($m=0;$m<@sub;$m++)
		{
			if($sub[$m]==1)
			{
				chomp($list[$m]);
				print("$list[$m],");
			}
		}
		print("\b");
		print"}";
		print("\n");
}		
sub binary_gen
{
	$n1=shift;
	$j=0;
	while($n1>0)
	{
		$b[$j]=($n1 % 2);
		$n1=int($n1/2);
		$j++;
	}
	@b=reverse(@b);
	return @b;
}

