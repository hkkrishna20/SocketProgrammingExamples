import java.io.*;
import java.net.*;
public class Server2
{
	public static void main (String args[])
	{	
	try
	{
		ServerSocket ser = new ServerSocket(9999);
		while(true)
		{
			Socket client = ser.accept();
			BufferedReader r=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter w=new PrintWriter(client.getOutputStream(),true);
			System.out.println("Welcome to java echoserver");
			String line;
				line =r.readLine ();
				if(line!=null)
				w.println("SERVER:"+line);
				System.out.println (line);
			    System.exit(0);
				}
	}
	catch(Exception err)
	{
	System.out.println("Error:"+err);
	}
	}
}

