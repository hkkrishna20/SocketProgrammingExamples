import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
class regserv
{
public static void main(String args[])throws Exception
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int port=Integer.parseInt(br.readLine());
ServerSocket ss=new ServerSocket(port);
Socket s=ss.accept();
System.out.println("waiting....");
if(s.isConnected()==true)
	System.out.println("connection success");
InputStream in=s.getInputStream();
OutputStream out=s.getOutputStream();
PrintWriter pr=new PrintWriter(out);
BufferedReader buf=new BufferedReader(new InputStreamReader(in));
RandomAccessFile raf=new RandomAccessFile("user.txt","rw");
//FileReader fr=new FileReader("users.txt");
//FileWriter fw=new FileWriter("users.txt");
//BufferedReader buf1=new BufferedReader(new InputStreamReader(fr));
buf.readLine();
Boolean ref=true;
String data,data1;
data=buf.readLine();
StringTokenizer str=new StringTokenizer(data1," ");
data1=raf.readLine();
do
{
data1=str.nextToken();
if(data==data1)
{
	System.out.println("user already exist");
	ref=false;
}
data1=raf.readLine();
}while(data1!=null);
if(ref==true)
{
raf.Chars(data);
data="enter password";
pr.println(data);
pr.flush();
data=buf.readLine();
data=data+"\n";
raf.write(data);
}
}
}