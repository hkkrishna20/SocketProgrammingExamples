import java.io.*;
import java.net.*;
class Server1
{ 
 public static void main(String args[])throws IOException
 {
  try
   {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 System.out.println("Enter the Port Number:\n");
	 int port=Integer.parseInt(br.readLine());
	 ServerSocket s=new ServerSocket(port);
	 Socket ss=s.accept();
	 if(ss.isConnected()==true);
	   System.out.println("connection successful:");
	 InputStream in=ss.getInputStream();
	 PrintWriter w=new PrintWriter(ss.getOutputStream(),true);
	 System.out.println("Hello Welcme: ");
	}
	catch(Exception e)
	{}
  }
}
	 