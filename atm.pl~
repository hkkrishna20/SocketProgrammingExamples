#program to perform ATM transaction#
$accno=10706016;
$PIN=1234;
$bal=1000000;
print("ENTER THE PIN\n");
$pin=<STDIN>;
if($pin==$PIN)
{
	print("ENTER THE TRANSCTION\n1:WITHDRAWL\n2:BALANCE ENQUIRY\n");
	$ch=<STDIN>;
	if($ch==1)
	{
		print("ENTER THE AMOUNT OF TRANSACTION\n");
		$amount=<STDIN>;
		if($amount<($bal-250))
		{
			print("TRANSACTION IS BEING PROCESSED\n");
			print("TAKE THE CASH\n");
			$bal=$bal-$amount;
			print("ACCOUNT NO:",$accno);
			print("\n");
			print("BALANCE   :",$bal);
			print("\n");
		}
		else
		{
			print("INSUFFICIENT BALANCE.TRANSACTION NOT POSSIBLE\n");
			print("ACCOUNT NO:",$accno);
			print("\n");
			print("BALANCE   :",$bal);
			print("\n");
		}
		
	}
	elsif($ch==2)
	{
		print("BALANCE ENQUIRY IS:\n");
		print("ACCOUNT NO:",$accno);
		print("\n");
		print("BALANCE   :",$bal);
		print("\n");
	}
	else
	{
		print("INVALID TRANSACTON");
	}
}
else
{
	print("INVALID PIN NUMBER\n");
}


