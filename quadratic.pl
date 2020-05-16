#program to find roots of quadratic equation#
print("ENTER THE QUADRATIC EQUATION IN FORM ax2+bx+c\n");
print("ENTER VALUE OF 'a'\n");
$a=<STDIN>;
print("ENTER VALUE OF 'b'\n");
$b=<STDIN>;
print("ENTER VALUE OF 'c'\n");
$c=<STDIN>;
$d=(($b*$b)-(4*$a*$c));
if($d>=00)
{
	$r1=(((-$b)+(sqrt($d)))/(2*$a));
	$r2=(((-$b)-(sqrt($d)))/(2*$a));
	print("FIRST ROOT IS:",$r1,"\n");
	print("SECOND ROOT IS:",$r2,"\n");
}
else
{
	$d=-($d);
	$x1=((-$b)+(sqrt($d))/(2*$a));
	$x2=((-$b)-(sqrt($d))/(2*$a));
	print("FIRST ROOT IS:",$x1,"i\n");
	print("SECOND ROOT IS:",$x2,"i\n");
}