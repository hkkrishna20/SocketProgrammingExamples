@char=('','one','two','three','four','five','six','seven','eight','nine','ten','eleven','twelve','thirteen','fourteen','fifteen','sixteen','seventeen','eighteen','nineteen'); 
@char2=('twenty','thirty','forty','fifty','sixty','seventy','eighty','ninty');
print "Enter the number \n";
$number=<STDIN>;
if($number>10000000)
{
	print " number out of bounds \n";
}
else
{
	if($number>=100000)
	{
		$numb=$number / 100000;
		$number=$number % 100000;
		if($numb>19)
		{
			$number1=$numb % 10;
			$number2=$numb/10;
			print $char2[$number2-2];
			print $char[$number1]," lakh ";
		}
		else
		{
			print $char[$numb]," lakh ";
		}
		$numb=$number/1000;
		$number=$number % 1000;
		$numb=int($numb);
		if($numb!=0)
		{
			if($numb>19)
			{
				$number1=$numb % 10;
				$number2=$numb/10;
				print $char2[$number2-2];
				print $char[$number1]," thousand ";
			}
			else
			{
				print $char[$numb]," thousand ";
			}
		}
		$numb=$number/100;
		$number=$number % 100;
		$numb=int($numb);
		if($numb!=0)
		{
			print $char[$numb]," hundred ";
		}
		if($number>19)
		{
			$number1=$number % 10;
			$number2=$number/10;
			print $char2[$number2-2];
			print $char[$number1];
		}
		else
		{
			print $char[$number];
		}
	}
	elsif($number>=1000)
	{
		$numb=$number/1000;
		$number=$number % 1000;
		if($numb>19)
		{
			$number1=$numb% 10;
			$number2=$numb/10;
			print $char2[$number2-2];
			print $char[$number1]," thousand ";
		}
		else
		{
			print $char[$numb]," thousand ";
		}
		$numb=$number/100;
		$number=$number % 100;
		$numb=int($numb);
		if($numb!=0)
		{
			print $char[$numb]," hundred ";
		}
		if($number>19)
		{
			$number1=$number % 10;
			$number2=$number/10;
			print $char2[$number2-2];
			print $char[$number1];
		}
		else
		{
			print $char[$number];
		}
	}
	else
	{
		$numb=$number/100;
		$number=$number%(100);
		print $char[$numb]," hundred ";
		if($number>19)
		{
			$number1=$number%(10);
			$number2=$number/10;
			print $char2[$number2-2];
			print $char[$number1];
		}
		else
		{
			print $char[$numb];
		}
	}
	print "\n";
}
