class cls1 extends Thread
{
	public void run()
	{
		for(int i=2;i<=10;i=i+2)
		{
			System.out.println("Even number thread"+i);
		}
	}
}
class cls2 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i=i+2)
		{
			System.out.println("Odd number thread"+i);
		}
	}
}
class eothread
{
	public static void main(String args[]) 
	{
		cls1 c1=new cls1();
		cls2 c2=new cls2();
		c1.start();
		c1.wait();
		c2.start();
	}
}