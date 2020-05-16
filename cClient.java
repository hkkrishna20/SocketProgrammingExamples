import java.io.*;
import java.net.*;
public class cClient
{
 public static void main(String args[])throws IOException
 {
  try
  { 
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("port is ...");
   int port=Integer.parseInt(br.readLine());
   Socket s=new Socket("localhost",port);
   if(s.isConnected()==true)
     System.out.println("connection successful ");
   InputStream in=s.getInputStream();
   OutputStream out=s.getOutputStream();
   BufferedReader br1=new BufferedReader(new InputStreamReader(in));
   PrintWriter pw=new PrintWriter(out);
   String data="hai";
   while(data.compareTo("BYE")!=0)
	{
		if(data.equals("BYE"))
		break;
		data=br1.readLine();
		System.out.println(data);
		System.out.print("Client:  ");
		data=br.readLine();
		pw.println(data);
		pw.flush();
	}
	System.out.println("disconnected");
	s.close();
	}
	catch(Exception e)
	{}
  }
}
  