import java.io.*;
import java.net.*;
class user2
{
	public static void main(String arg[]) throws IOException
	{
		String sentence, newsentence;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		ServerSocket ss=new ServerSocket(6789);
		Socket s=ss.accept();
		BufferedReader inp=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		do
		{
			sentence=inp.readLine();
			if(sentence!="exit")
			{
				System.out.println("User1:"+sentence);
				System.out.print("User2:");
				newsentence=in.readLine();
				out.println(newsentence);
			}
			
		}while(sentence.compareTo("exit")!=0);
		ss.close();
		/*if(sentence.compareTo("exit")==0)
		{
		System.exit(0);
		}*/
	} 
}