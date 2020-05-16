import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
class mserv
{
public static void main(String args[])throws Exception
{
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter port number");
BufferedReader buf2=new BufferedReader(new FileReader("user.txt"));
BufferedWriter buf3=new BufferedWriter(new FileWriter("user.txt",true));
int port=Integer.parseInt(buf.readLine());
ServerSocket ss=new ServerSocket(port);
System.out.println("waiting....");
Socket s=ss.accept();
if(s.isConnected()==true)
		System.out.println("connection successful");
InputStream in=s.getInputStream();
OutputStream ou=s.getOutputStream();
PrintWriter pr=new PrintWriter(ou);
BufferedReader buf1=new BufferedReader(new InputStreamReader(in));
String data=buf1.readLine();
String data1,mail;
String pass=null;
Boolean ref=true;
StringTokenizer str;
while(ref)
{
data1=buf2.readLine();
if(data1==null)
{
ref=false;
break;
}
str=new StringTokenizer(data1," ");
data1=str.nextToken();
pass=str.nextToken();
if(data.equals(data1))
{
pr.println("success");
pr.flush();
break;
}
}
if(ref==true)
{
String pass1=buf1.readLine();
if(pass1.equals(pass))
{
pr.println("success");
pr.flush();
int choice;
do
{
choice=Integer.parseInt(buf1.readLine());
switch(choice)
{
case 1:
BufferedReader buf4=new BufferedReader(new FileReader("mail.txt"));
ref=true;
int i=0;
while(ref)
{
data1=buf4.readLine();
if(data1==null)
break;
str=new StringTokenizer(data1," ");
data1=str.nextToken();
if(data.equals(data1))
i++;
else
continue;
}
pr.println(i);
pr.flush();
buf4=new BufferedReader(new FileReader("mail.txt"));
while(ref)
{
data1=buf4.readLine();
mail=data1;
if(data1==null)
break;
str=new StringTokenizer(data1," ");
data1=str.nextToken();
if(data.equals(data1))
{
pr.println(mail);
pr.flush();
}
else
continue;
}
break;
case 2:
BufferedWriter buf5=new BufferedWriter(new FileWriter("mail.txt",true));
String to=buf1.readLine();
mail=buf1.readLine();
data=to+" "+data+" "+mail;
buf5.write(data);
buf5.newLine();
buf5.flush();
}
choice=Integer.parseInt(buf1.readLine());
}while(choice!=1);
}
else
{
pr.println("fail");
pr.flush();
}
}
else
{
pr.println("fail");
pr.flush();
}
s.close();
}
}