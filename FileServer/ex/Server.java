import java.io.*;
import java.net.*;
class Server implements Runnable
{
	Socket client;
	Server(Socket cl)
	{
		client=cl;
	}
	public static void main(String args[])throws InterruptedException
	{
		try
		{
			ServerSocket sr=new ServerSocket(1255);
			while(true)
			{
				Socket cl=sr.accept();
				Thread s=new Thread(new Server(cl));
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
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			Boolean flag=true;
			byte arr[]=new byte[1];
			File f=new File("Doc/a.txt");
			FileOutputStream fos=new FileOutputStream(f);
			String l;
			while(flag)
			{
				try
				{
					l=br.readLine();
					System.out.print(l);
					arr=l.getBytes();
					fos.write(arr);
					out.print('1');
				}
				catch(NumberFormatException e)
				{
					System.out.println(e);
					flag=false;
					out.print('0');
				}
			}
			fos.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}