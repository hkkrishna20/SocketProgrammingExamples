import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class server implements Runnable
{ 
	Socket client;
	static SimpleDateFormat time=new SimpleDateFormat(" HH:mm:ss a zzz");
	static SimpleDateFormat date=new SimpleDateFormat(" yyyy-MM-dd");
	static SimpleDateFormat day=new SimpleDateFormat(" E ");
	server(Socket cl)
	{
		client=cl;
	}
	public static void main(String args[])throws InterruptedException
	{
		try
		{
			ServerSocket sr=new ServerSocket(1255);
			System.out.println("ClientNo	TimeOfRequest				ServiceRequested");
			while(true)
			{
				Socket cl=sr.accept();
				Thread s=new Thread(new server(cl));
				s.start();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
		try
		{
			Date d=new Date();
			String t=d.toString();
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			String l;
			out.println("Server:Enter your roll no:");
			l=br.readLine();
			int roll=Integer.parseInt(l);				
			out.println("Server:How can I help U sir?");
			l=br.readLine();
			out.println("Server:I am a Time Server You may 1.Ask time 2.Ask Date 3.Ask Day");
			l=br.readLine();
			int choice=Integer.parseInt(l);
			switch(choice)
			{
				case 1:out.println(time.format(new Date()));break;
				case 2:out.println(date.format(new Date()));break;
				case 3:out.println(day.format(new Date()));break;
			}
			System.out.println(roll+"	"+t+"		"+((choice==1)?"Time":(choice==2)?"Date":"Day"));
			client.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}