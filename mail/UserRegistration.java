import java.io.*;
class UserRegistration
{
	public static void main(String args[])throws IOException
	{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("UserName:");
		String UserName=console.readLine();
		System.out.println("Password:");
		String Password=console.readLine();
		System.out.println("Re-Type Password:");
		String pass=console.readLine();
		if(Password.equals(pass))
		{
			RandomAccessFile a=new RandomAccessFile("users.txt","rw");
			a.seek(a.length());
			a.writeBytes(UserName);
			a.writeBytes("	");
			a.writeBytes(Password);
			a.writeByte(10);
		}
		else
		{
			System.out.println("Your passwords didnt match");
		}
	}
}
