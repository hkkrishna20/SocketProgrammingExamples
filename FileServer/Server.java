import java.io.*;
import java.net.*;
class Server implements Runnable
{
	Socket client;
	Server(Socket cl)
	{
		client=cl;
	}
	public static void main(String args[])throws InterruptedException
	{
		try
		{
			ServerSocket sr=new ServerSocket(1255);
			while(true)
			{
				Socket cl=sr.accept();
				Thread s=new Thread(new Server(cl));
				s.start();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			Boolean flag=true;
			while(flag)
			{
				out.println("*******MAIN MENU*******");
				out.println("1.Download a File");
				out.println("2.Upload a file");
				out.println("Press any other key to exit");
				String l=br.readLine();
				int choice=Integer.parseInt(l);
				switch(choice)
				{
					case 1:view(out,br);
					break;
					case 2:upload(out,br);
					break;
					default:flag=false;
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	private void view(PrintWriter out,BufferedReader br)throws IOException
	{
		File file=new File("files");
		String s[];
		s=file.list();
		for(int i=0;i<s.length;i++)
		{
			File a=new File(s[i]);
			out.println(i+"	"+s[i]+"	"+a.length()+"	"+a.lastModified());
		}
		out.println('0');
		download(out,br,s);
	}
	private void download(PrintWriter out,BufferedReader br,String s[])throws IOException
	{
		out.print("File number:");
		int n=Integer.parseInt(br.readLine());
		File f=new File(s[n]);
		FileInputStream fis=new FileInputStream(f);
		byte arr[][]=new byte[3][];
		long size=f.length();
		int index=2;
		int temp=0;
		out.println(s[n]);
		arr[0]=new byte[1048576];
		arr[1]=new byte[1024];
		arr[2]=new byte[1];
		while((temp=fis.read(arr[index]))!=-1)
		{
			String l=new String(arr[index]);
			out.println(l);
			size-=temp;
			index=((size>1048576)?0:((size>1024)?1:2));
		}
		fis.close();
	}
	private void upload(PrintWriter out,BufferedReader br)throws IOException
	{
		out.println("FileName:");
		String l=br.readLine();
		File f=new File("files",l);
		FileOutputStream fos=new FileOutputStream(f);
		byte arr[][]=new byte[3][];
		arr[0]=new byte[1048576];
		arr[1]=new byte[1024];
		arr[2]=new byte[1];
		int temp=0;
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
}
