import java.io.*;
class fac
{
public static void main(String [] args) throws IOException
{
	int i,j,n,t;
	float sum=1;
	System.out.println("factorial of given number ");
	System.out.println("enter any number ");
	BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
	n=Integer.parseInt(console.readLine());
	for(i=1;i<=n;i++)
	{
		sum=sum*i;
	}
System.out.println("therefore the factorial of the give n number");
System.out.println(sum);
}
}



