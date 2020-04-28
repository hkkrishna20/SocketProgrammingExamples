import java.io.*;
import java.net.*;
public class client
{
	public static void main(String args[])throws IOException
	{
		try
		{
			Socket sc=new Socket("127.0.0.1",1255);
			InputStream in=sc.getInputStream();
			PrintWriter out=new PrintWriter(sc.getOutputStream(),true);
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
			String l;
			l=br.readLine();
			System.out.println(l);
			l=console.readLine();
			out.println(l);
			System.out.println("Me:"+l);
			l=br.readLine();
			System.out.println(l);
			out.println("What services do you offer");
			System.out.println("Me:What services do you offer");
			l=br.readLine();
			System.out.println(l);
			l=console.readLine();
			out.println(l);
			l=br.readLine();
			System.out.println(l);			
			sc.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
}
