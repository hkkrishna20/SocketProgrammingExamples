import java.io.*;
import java.util.*;
class file
{
  public static void main(String args[])throws IOException
  {
    String s;
	try
	{
      FileReader fr=new FileReader("1.txt");
	  BufferedReader b=new BufferedReader(fr);
	  do
	  {
	  s=b.readLine();
	  //StringTokenizer st=new StringTokenizer(s,"\n");
	  //while(st.hasMoreTokens())
	  //{
	  // String t=st.nextToken();
	  System.out.println(s);
	    //}
	  }while(s.equals("null"));
	}
    catch(FileNotFoundException ioe)
	{
	System.out.println(ioe);
	}
  }
}