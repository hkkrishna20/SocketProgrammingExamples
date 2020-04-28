import java.io.*;
import java.net.*;
class Client
{
	public static void main(String args[])throws IOException
	{
		Socket sc=new Socket("127.0.0.1",1255);
		InputStream in=sc.getInputStream();
		PrintWriter out=new PrintWriter(sc.getOutputStream(),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		Boolean flag=true;
		byte arr[]=new byte[1];
		File f=new File("a.txt");
		FileInputStream fis=new FileInputStream(f);
		while(flag)
		{
			try
			{
				fis.read(arr);
				String l=new String(arr);
				System.out.print(l);
				out.print(l);
				l=br.readLine();
				if(l.charAt(0)=='0')
				{
					flag=false;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println(e);
			}
			catch(EOFException e)
			{
				flag=false;
			}
		}
		fis.close();
	}
}