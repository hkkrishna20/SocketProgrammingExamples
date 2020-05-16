import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;
class Mail
{
	int MsgId;
	String To;
	String From;
	String Subject;
	String date;
	String Msg;
	Mail()
	{
		MsgId=0;
		To=From=Subject=Msg=date=null;
	}
	public String Compose(String to,String from)throws IOException
	{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		To=to;
		if(To==null)
		{
			System.out.print("To:");
			To=console.readLine();
		}
		From=from;
		System.out.print("Subject:");
		Subject=console.readLine();
		System.out.print("Msg:");
		Msg=console.readLine();
		return(To);
	}
	public String pack()
	{
		String temp=From;
		temp+='|';
		temp+=Subject;
		temp+='|';
		temp+=Msg;
		temp+='|';
		return(temp);	
	}
	public void unPack(String temp)
	{
		StringTokenizer a=new StringTokenizer(temp,"|");
		From=a.nextToken();
		Subject=a.nextToken();
		Msg=a.nextToken();	
	} 
}