/*Name:Adimulam Jyosthna
Roll No.10906002
*/
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;
class server implements Runnable
{
	Socket client;
	server(Socket cl)
	{
			client=cl;
	}
	public static void main(String args[])throws IOException
	{	
		
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));		
		int port=5555;		
		ServerSocket s=new ServerSocket(port);
		
		while(true)
		{
			Socket cl=s.accept();
			System.out.println("Connection established with " +cl);
			System.out.println("Client  \tYear of Birth\tYear of Death");
		
			
			Thread t=new Thread(new server(cl));
			t.start();
		}
	}
	public void run()
	{
		try{
		int res=0;int count=0; 
		String ans;
		BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out=new PrintWriter(client.getOutputStream(),true);
		out.println("Welcome to the DEATH CLOCK SERVER");
		out.println("Enter the year in which you were born");
		int yearofbirth=Integer.parseInt(in.readLine());
		int avgspanmale=75;
		int avgspanfemale=80;
		out.println("Enter the gender.. M for male and F for female");
		String gen=in.readLine();
		if(gen.equalsIgnoreCase("M"))
		{
			res=avgspanmale;
			
		}
		if(gen.equalsIgnoreCase("F"))
		{
			res=avgspanfemale;
			
		}		
		out.println("Do u have any problems like BP/Sugar....enter yes or no");
		ans=in.readLine();
		if(ans.compareTo("yes")==0)
		{
			res=res-5;
		}
		out.println("Do u have cancer....enter yes or no");
		 ans=in.readLine();
		if(ans.compareTo("yes")==0)
		{
			res=res-10;
		}
		out.println("Do u practise exercise daily....enter yes or no");
		 ans=in.readLine();
		if(ans.compareTo("yes")==0)
		{
			res=res+5;
		}
		out.println("Are you vegetarian....enter yes or no");
		 ans=in.readLine();
		if(ans.compareTo("yes")==0)
		{
			res=res+5;
		}
		out.println("please wait...your request is processing");
		int fin=yearofbirth+res;
		out.println("The year of your death is...."+fin);
		
		System.out.println(client.getInetAddress()+"\t"+yearofbirth+"\t\t" +fin);
		client.close();
		}
		
		
		catch(Exception e)
		{
			System.out.println(e);}
	}

		
}
		
		
			
		
		
		
		
