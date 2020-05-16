/*Name:Adimulam Jyosthna
Roll No.10906002
*/
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
class client
{
	public static void main(String args[])throws IOException
	{
		String opt,ip;
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter ip address");
		ip=obj.readLine();
		Socket cl=new Socket(ip,5555);		
		BufferedReader in=new BufferedReader(new InputStreamReader(cl.getInputStream()));
		PrintWriter out=new PrintWriter(cl.getOutputStream(),true);
		System.out.println(in.readLine());
		System.out.println(in.readLine());
		int born=Integer.parseInt(obj.readLine());
		out.println(born);//year of birth
		System.out.println(in.readLine());
		String gen=obj.readLine();//gender
		out.println(gen);
		System.out.println(in.readLine());//bp/sugar
		 opt=obj.readLine();
		 out.println(opt);
		 System.out.println(in.readLine());// cancer
		 opt=obj.readLine();
		 out.println(opt);
		 System.out.println(in.readLine());// exercise
		 opt=obj.readLine();
		 out.println(opt);
		 System.out.println(in.readLine());// vegetables
		 opt=obj.readLine();
		 out.println(opt);
		 System.out.println(in.readLine());
		 System.out.println(in.readLine());
		 }
		 }
		 
		 
		 