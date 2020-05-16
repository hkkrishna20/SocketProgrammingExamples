#Name:Adimulam Jyosthna
#Roll No.10906002

use IO::Socket;
print "enter ip address of server\n";
$ip=<STDIN>;
$socket = new IO::Socket::INET ( PeerAddr => $ip,
								 PeerPort => 5555,
								 Proto => 'tcp',
								)
or die "couldnt connect server ";
#while(1)
#{
	$socket->recv($s,1024);
	print $s;
	$socket->recv($s,1024);
	print $s;
	$born=<STDIN>;
	$socket->send($born);
	$socket->recv($s,1024);
	print $s;
	$gen=<STDIN>;	
	$socket->send($gen);
	$socket->recv($s,1024);#for BP/sugar
	print $s;
	$ans=<STDIN>;
	$socket->send($ans);
	$socket->recv($s,1024);#for Cancer
	print $s;
	$ans=<STDIN>;
	$socket->send($ans);
	$socket->recv($s,1024);#for exercise
	print $s;
	$ans=<STDIN>;
	$socket->send($ans);
	$socket->recv($s,1024);#for eating raw vegetables
	print $s;
	$ans=<STDIN>;
	$socket->send($ans);
	$socket->recv($s,1024);
	print $s;
	$socket->recv($s,1024);
	print $s;
	#last;
	close $socket;
	
	#}
	
	
	