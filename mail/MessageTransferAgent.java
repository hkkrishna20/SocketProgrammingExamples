import java.io.*;
import java.net.*;
import java.util.Date;
class MessageTransferAgent implements Runnable
{
	Mail mail;
	Socket client;
	MessageTransferAgent()
	{
		mail=null;
		client=null;	
	}
	MessageTransferAgent(Socket cl)
	{
		client=cl;
		mail=new Mail();
	}
	public static void main(String args[])throws IOException
	{
		try
		{
			ServerSocket sr=new ServerSocket(1255);
			while(true)
			{
				Socket cl=sr.accept();
				Thread s=new Thread(new MessageTransferAgent(cl));
				s.start();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public Boolean send(Mail m)
	{
		mail=m;
		try
		{
			Socket sc=new Socket("127.0.0.1",1255);
			InputStream in=sc.getInputStream();
			PrintWriter out=new PrintWriter(sc.getOutputStream(),true);
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String l;
			out.println(mail.To);
			l=br.readLine();
			Boolean flag=Boolean.parseBoolean(l);
			if(flag)
			{
				out.println(mail.pack());
				l=br.readLine();
				flag=Boolean.parseBoolean(l);			
			}
			sc.close();
			return(flag);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
		return(false);
	}
	public void run()
	{
		try
		{
			MailBox box=new MailBox();
			String l=null;
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			mail.To=br.readLine();
			if(box.CheckAvailability(mail.To))
			{
				out.println("true");
				l=br.readLine();
				Date d=new Date();
				mail.date=d.toString();
				mail.unPack(l);
				mail.MsgId=box.store(mail);
				out.println("true");
				client.close();
			}
			else
			{
				out.println("false");
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}