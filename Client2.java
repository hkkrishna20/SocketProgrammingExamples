import java.io.*;
import java.net.*;
public class Client2
{
public static void main(String args[])throws IOException
{ 
 try
 {
  Socket s=new Socket("localhost",9999);
  BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
  PrintWriter w=new PrintWriter(s.getOutputStream(),true);
  BufferedReader con = new BufferedReader (new InputStreamReader(System.in));
  String line,rline;
  
  
   line=con.readLine();
   if(line!=null)
  {
   w.println(line);
  }

  rline=r.readLine();
  System.out.println("Echo from server"+rline);
 
 }
 catch(Exception err)
 {
 System.out.println("error"+err);
 }
}
}