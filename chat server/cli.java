import java.io.*;
import java.net.*;
class cli
{
public static void main(String args[])throws Exception
{
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter port number");
int port=Integer.parseInt(buf.readLine());
Socket s=new Socket("localhost",port);
if(s.isConnected()==true)
	System.out.println("connetion success");
InputStream in=s.getInputStream();
BufferedReader buf1=new BufferedReader(new InputStreamReader(in));
OutputStream ou=s.getOutputStream();
PrintWriter pr=new PrintWriter(ou);
String data="hai";
while(true)
{
if(data.equals("BYE"))
	break;
data=buf1.readLine();
System.out.println(data);
System.out.print("Client:  ");
data=buf.readLine();
pr.println(data);
pr.flush();
}
System.out.println("disconnected");
s.close();
}
}