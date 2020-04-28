print("ENTER A NUMBER N\n");
$n=<STDIN>;
$sum=0;
for($i=1;$i<=$n;$i++)
{
	$sum=($sum+($i*$i));
}
print("THE SUM OF FIRST ",$n,"NUMBERS IS:",$sum,"\n"); 
