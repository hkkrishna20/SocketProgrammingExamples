import java.io.*;
import java.util.*;
class MailBox
{
	MailBox()
	{
	}
	public int store(Mail m)throws IOException
	{
		RandomAccessFile mail=new RandomAccessFile("mailBox.txt","rw");
		String text=null;
		if(mail.length()>5)
		{
			mail.seek(mail.length()-10);
			text=mail.readLine();		
		}
		String b="|";
		text=mail.readLine();		
		StringTokenizer st=new StringTokenizer(text,b);
		int id=Integer.parseInt(st.nextToken());
		mail.writeBytes(m.To);
		mail.writeByte(124);
		mail.writeBytes(m.From);
		mail.writeByte(124);
		mail.writeBytes(m.Subject);
		mail.writeByte(124);
		mail.writeBytes(m.date);
		mail.writeByte(124);
		mail.writeBytes(m.Msg);
		mail.writeByte(124);
		mail.writeByte(10);
		StringBuffer a=new StringBuffer();
		a.append(++id);
		String c=new String(a);
		mail.writeBytes(c);
		mail.writeByte(124);
		mail.close();
		return(id);
	}	
	public void delete(String Id)throws IOException
	{
		RandomAccessFile mail=new RandomAccessFile("mailBox.txt","rw");
		String text=null;
		String b="|";
		long pos=0l;
		while((text=mail.readLine())!=null)
		{
			StringTokenizer msg=new StringTokenizer(text,b);
			if(msg.hasMoreTokens())
			{
				if(Id.compareTo(msg.nextToken())==0)
				{
					mail.seek(pos);
					for(int i=0;i<text.length();i++)
					{
						mail.writeByte(124);
					}
				}
			}
			pos+=text.length()+1;
		}
		mail.close();

	}
	public Boolean CheckAvailability(String to)throws IOException
	{
		File User=new File("users.txt");
		FileReader fread=new FileReader(User);
		BufferedReader user=new BufferedReader(fread);
		String text=null;
		while((text=user.readLine())!=null)
		{
			StringTokenizer msg=new StringTokenizer(text);
			if(to.compareTo(msg.nextToken())==0)
			{
				return(true);
			}
		}
		fread.close();
		return(false);
	}
}
