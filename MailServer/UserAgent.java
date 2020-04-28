import java.io.*;
import java.util.*;
class UserAgent
{
	static String mailId;
	static String Password;
	public static void main(String args[])throws IOException
	{
		Boolean flag=Login();
		if(flag)
		{
			BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
			while(flag)
			{
				System.out.println("1.Compose new msg\n2.Display msgs\nEnter any other key to quit\n");
				int choice=Integer.parseInt(console.readLine());
				switch(choice)
				{
					case 1:Compose(null);
						   break;
					case 2:Display();
						   break;
					default:flag=false;
				}
			}
		}
		else
		{
			System.out.println("Wrong mailID or Password\n");
		}
	}
	public static Boolean Login()throws IOException
	{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("mailID:");
		mailId=console.readLine();
		System.out.print("Password:");
		Password=console.readLine();
		File User=new File("users.txt");
		FileReader fread=new FileReader(User);
		BufferedReader user=new BufferedReader(fread);
		String text=null;
		while((text=user.readLine())!=null)
		{
			StringTokenizer msg=new StringTokenizer(text);
			if((mailId.compareTo(msg.nextToken())==0)&&(Password.compareTo(msg.nextToken())==0))
			{
				System.out.println("hi");
				return(true);
			}
		}
		return(false);
	}
	public static void Compose(String To)throws IOException
	{
		Mail mail=new Mail();
		To=mail.Compose(To,mailId);	
		MessageTransferAgent MTA=new MessageTransferAgent();
		if(MTA.send(mail))
		{
			System.out.println("Mail has been sent to "+To);
		}
		else
		{
			System.out.println("Mail sending failed");
		}
	}
	public static void Display()throws IOException
	{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		File mail=new File("mailBox.txt");
		FileReader fread=new FileReader(mail);
		BufferedReader mailBox=new BufferedReader(fread);
		String text=null;
		String Id=null;
		String b="|";
		Boolean flag=true;
		while(flag)
		{
			fread=new FileReader(mail);
			mailBox=new BufferedReader(fread);
			while((text=mailBox.readLine())!=null)
			{
				StringTokenizer msg=new StringTokenizer(text,b);
				if(msg.hasMoreTokens())
				{
					Id=msg.nextToken();
					if(msg.hasMoreTokens())
					{
						if(mailId.compareTo(msg.nextToken())==0)
						{
							System.out.println(Id+"	"+msg.nextToken()+"	"+msg.nextToken()+"	"+msg.nextToken());
						}
					}
				}
			}
			fread.close();
			flag=Read(mail);
		}		
	}
	public static Boolean Read(File mail)throws IOException
	{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		String text=null;
		System.out.println("1.Read a msg\nenter any other number to go to main Menu\n");
		int choice=Integer.parseInt(console.readLine());
		if(choice!=1)
		{
			return(false);
		}
		System.out.print("MsgID:");
		String Id=console.readLine();
		FileReader fread=new FileReader(mail);
		BufferedReader mailBox=new BufferedReader(fread);
		String b="|";
		while((text=mailBox.readLine())!=null)
		{
			StringTokenizer msg=new StringTokenizer(text,b);
			if(msg.hasMoreTokens())
			{
				if(Id.compareTo(msg.nextToken())==0)
				{
					String To=msg.nextToken();
					String From=msg.nextToken();
					String Subject=msg.nextToken();
					String date=msg.nextToken();					
					System.out.println(msg.nextToken());
					System.out.println("1.Reply\n2.Delete\nEnter any other key to go to Msg Menu\n");
					choice=Integer.parseInt(console.readLine());
					switch(choice)
					{
						case 1:Compose(From);
							   break;
						case 2:MailBox box=new MailBox();
							   box.delete(Id);
							   break;
					}
					return(true);
				}
			}
		}
		return(false);
	}
}