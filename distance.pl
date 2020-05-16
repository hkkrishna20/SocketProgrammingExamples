#program to find distance between two points
print("ENTER THE X COORDINATE OF FIRST POINT\n");
$x1=<STDIN>;
print("ENTER THE Y COORDINATE OF FIRST POINT\n");
$y1=<STDIN>;
print("ENTER THE X COORDINATE OF SECOND POINT\n");
$x2=<STDIN>;
print("ENTER THE X COORDINATE OF SECOND POINT\n");
$y2=<STDIN>;
$d=sqrt((($x2-$x1)*($x2-$x1))+(($y2-$y1)*($y2-$y1)));
print("DISTANCE BETWEEN POINTS IS:",$d,"\n");