import java.io.*;
import java.net.*;
class serv
{
public static void main(String args[])throws Exception
{
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter port number");
String data="hai";
int port=Integer.parseInt(buf.readLine());
ServerSocket ss=new ServerSocket(port);
System.out.println("waiting....");
Socket s=ss.accept();
if(s.isConnected()==true)
		System.out.print("connection successful");
InputStream in=s.getInputStream();
OutputStream ou=s.getOutputStream();
PrintWriter pr=new PrintWriter(ou);
BufferedReader buf1=new BufferedReader(new InputStreamReader(in));
while(true)
{
if(data.equals("BYE"))
	break;
System.out.print("server:  ");
data=buf.readLine();
pr.println(data);
pr.flush();
data=buf1.readLine();
System.out.println(data);
}
System.out.print("disconnected");
s.close();
}
}