#program to perform string comparision
print("ENTER THE FIRST STRING\n");
$str1=<STDIN>;
print("ENTER THE SECOND STRING\n");
$str2=<STDIN>;
if(($str1)eq($str2))
{
	print("THE STRINGS ENTERED ARE SAME\n");
	exit;
}
else
{
	print("THE STRINGS ENTERED ARE NOT SAME\n");
	#$str3=($str1.$str2);
	#print("THE STRING CONCATENATION IS:",$str3);
	exit;
}
