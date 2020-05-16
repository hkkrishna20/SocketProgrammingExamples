
import java.io.*;
import java.net.*;
class user1
	{
	public static void main(String[] args) throws Exception
	{
		String sentence, newsentence;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Socket cs=new Socket("localhost",6789);
		BufferedReader inp=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
		System.out.print("User1:");
		sentence=br.readLine();
		out.println(sentence);
		do
		{
			
			newsentence=inp.readLine();
			if(newsentence!="exit")
			{
			    System.out.println("User2:"+newsentence);
				System.out.print("User1:");
				sentence=br.readLine();
				out.println(sentence);
				//newsentence=inp.readLine();
				//System.out.println("User2:"+newsentence);
			}
		}while(newsentence.compareTo("exit")!=0);
		cs.close();
	}
}