import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
class mcli
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
System.out.println("enter username");
String data=buf.readLine();
pr.println(data);
pr.flush();
data=buf1.readLine();
if(data.equals("fail"))
System.out.println("user doesn't exist");
else
{
System.out.println("enter password");
String pass=buf.readLine();
pr.println(pass);
pr.flush();
data=buf1.readLine();
if(data.equals("fail"))
System.out.println("wrong password");
else
{
int choice;
do
{
System.out.println("Enter choice");
System.out.println(" 1.Inbox\n 2.compose");
choice=Integer.parseInt(buf.readLine());
pr.println(choice);
pr.flush();
switch(choice)
{
case 1:
int count=Integer.parseInt(buf1.readLine());
System.out.println("From      Content");
StringTokenizer str;
for(int i=0;i<count;i++)
{
data=buf1.readLine();
str=new StringTokenizer(data," ");
str.nextToken();
System.out.print(str.nextToken()+"      ");
while(str.hasMoreTokens())
System.out.print(str.nextToken()+" ");
System.out.println();
}
break;
case 2:
System.out.println("enter to username");
data=buf.readLine();
pr.println(data);
pr.flush();
System.out.println("enter content");
data=buf.readLine();
pr.println(data);
pr.flush();
break;
}
System.out.println("enter 1 to exit");
choice=Integer.parseInt(buf.readLine());
pr.println(choice);
pr.flush();
}while(choice!=1);
}
}
s.close();
}
}