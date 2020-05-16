import java.io.*;
import java.net.*;
class Client1
{
 public static void main(String args[])throws IOException
 { 
  try 
  {
   BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("port number is: ");
   int port =Integer.parseInt(br1.readLine());
   Socket ss=new Socket("localhost",port);
   InputStream is=ss.getInputStream();
   PrintWriter w1=new PrintWriter(ss.getOutputStream(),true);
   BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
   String line,rline;
    line=br1.readLine();
      w1.println(line);
    
	rline=br.readLine();
	System.out.println("from server :" +rline);
   }
   catch(Exception e)
   {}
  }
}
    	