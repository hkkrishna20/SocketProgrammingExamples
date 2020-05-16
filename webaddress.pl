#program to seperate various modules of a webaddress
$char="http://www.google.com";
@str=split(//,$char);
for($i=0;$i<4;$i++)
{
	$proto[$i]=$str[$i];
}
for($i=4;$i<7;$i++)
{
	$sep[$i-4]=$str[$i];
}
for($i=7;$i<10;$i++)
{
	$web[$i-7]=$str[$i];
}
for($i=11;$i<17;$i++)
{
	$add[$i-11]=$str[$i];
}
for($i=18;$i<21;$i++)
{
	$ext[$i-18]=$str[$i];
}
print("\nTHE PROTOCALL IS:    ");
for($i=0;$i<4;$i++)
{
	print($proto[$i]);
}
print("\nTHE SEPERATORS IS:   ");
for($i=0;$i<3;$i++)
{
	print($sep[$i]);
}
print("\nTHE WEB IS:          ");
for($i=0;$i<3;$i++)
{
	print($web[$i]);
}
print("\nTHE ADDRESS IS:      ");
for($i=0;$i<6;$i++)
{
	print($add[$i]);
}
print("\nTHE EXTENSION IS:    ");
for($i=0;$i<3;$i++)
{
	print($ext[$i]);
}
print("\n");

 
