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
		while(flag)
		{
			for(int i=0;i<4;i++)
			{
				String l=br.readLine();
				System.out.println(l);
			}			
			int choice=Integer.parseInt(console.readLine());
			out.println(choice);
			switch(choice)
			{
				case 1:view(out,br,console);
				break;
				case 2:upload(out,br,console);
				break;
				default:flag=false;
			}		
		}
	}
	private static void view(PrintWriter out,BufferedReader br,BufferedReader console)throws IOException
	{
		String l=br.readLine();
		while(l.charAt(0)!='0')
		{
			System.out.println(l);
			l=br.readLine();
		}
		download(out,br,console);
	}
	private static void download(PrintWriter out,BufferedReader br,BufferedReader console)throws IOException
	{
		String l=br.readLine();
		System.out.println(l);
		out.println(console.readLine());
		System.out.print("Enter destination path:");
		File f=new File(console.readLine(),br.readLine());
		FileOutputStream fos=new FileOutputStream(f);
		int temp=0;
		byte arr[][]=new byte[3][];
		arr[0]=new byte[1048576];
		arr[1]=new byte[1024];
		arr[2]=new byte[1];
		l=br.readLine();
		while((temp=l.length())!=0)
		{
			temp=((temp==1048576)?0:((temp==1024)?1:2));
			arr[temp]=l.getBytes();
			fos.write(arr[temp]);
			l=br.readLine();
		}
		fos.close();
	}
	private static void upload(PrintWriter out,BufferedReader br,BufferedReader console)throws IOException
	{
		String l=br.readLine();
		System.out.println(l);
		l=console.readLine();
		out.println(l);
		System.out.print("FilePath:");
		File f=new File(console.readLine(),l);
		FileInputStream fis=new FileInputStream(f);
		int temp=0;
		int index=2;
		long size=f.length();
		byte arr[][]=new byte[3][];
		arr[0]=new byte[1048576];
		arr[1]=new byte[1024];
		arr[2]=new byte[1];
		while((temp=fis.read(arr[index]))!=-1)
		{
			l=new String(arr[index]);
			out.println(l);
			size-=temp;
			index=((size>1048576)?0:((size>1024)?1:2));
		}
		fis.close();
	}
}