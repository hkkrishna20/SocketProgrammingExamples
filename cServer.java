import java.io.*; 
import java.net.*;
public class cServer
{
 public static void main(String args[])throws IOException
 {
  try
  {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("Enter the port number: ");
   int port=Integer.parseInt(br.readLine());
   ServerSocket server=new ServerSocket(port);
   System.out.println("waiting............");
   Socket client=server.accept();
   System.out.println("Finally got a client.....");
   InputStream in=client.getInputStream();
   OutputStream out=client.getOutputStream();
   BufferedReader br1=new BufferedReader(new InputStreamReader(in));
   PrintWriter pr=new PrintWriter(out);
   String line="hai";
   while(line.compareTo("BYE")!=0)
   {
    if(line.equals("BYE"))
	 break;
	 else
	 {
	  System.out.print("server:  ");
      line=br.readLine();
	  pr.println(line);
	  pr.flush();
	  line=br1.readLine();
      System.out.println(line);
      }
	 }
     System.out.print("disconnected");
     server.close();

    }
   catch(Exception e)
   {}
 }
} 
 