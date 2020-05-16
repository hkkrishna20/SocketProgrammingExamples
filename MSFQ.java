import java.lang.*;
import java.io.*;
import java.util.*;
class Event
{
    int s_time;
    int event_type;
    Event next;
}
class EventList
{
    Event Head;
    void create(int st,int ety)
    {
        Event e=new Event();
        e.event_type=ety;e.s_time=st;
        Head=e;e.next=null;
    }
    void InsertLast(int st,int ety)
    {
        Event e=new Event();
        e.event_type=ety;e.s_time=st;
        Event t=Head;
        while(t.next!=null)
        {
            t=t.next;
        }
        t.next=e;e.next=null;
    }
    void Delete()
    {
        Head=Head.next;
    }
    void SortList()
    {
        Event t,s;
        t=Head;s=Head;
        while(t!=null)
        {
            for(s=Head;s.next!=null;s=s.next)
            {
                if(s.s_time>s.next.s_time)
                {
                    int temp=s.event_type;
                    s.event_type=s.next.event_type;
                    s.next.event_type=temp;
                    int temp2=s.s_time;
                    s.s_time=s.next.s_time;
                    s.next.s_time=temp2;
                }
            }
            t=t.next;
        }
    }
    void Display()
    {
        Event t=Head;
        while(t!=null)
        {
            System.out.println(t.event_type+"\t"+t.s_time);
            t=t.next;
        }
    }
}
class Single
{
    static int clk=0;static int length=0;EventList e=new EventList();
    double MeanArrival,MeanService;int Servers;static int[] serStatus;int Tot_status;
    int QueueLength;
    void ReadMeans() throws IOException
    {
        DataInputStream obj=new DataInputStream(System.in);
        System.out.print("Enter mean arrival rate :");
        MeanArrival=Double.parseDouble(obj.readLine());
        System.out.print("Enter mean service rate :");
        MeanService=Double.parseDouble(obj.readLine());
        System.out.print("Enter the number of servers :");
        Servers=Integer.parseInt(obj.readLine());
        serStatus=new int[Servers];
        System.out.print("Enter the maximum QueueLength :");
        QueueLength=Integer.parseInt(obj.readLine());
    }
    void arrival()
    {
        Tot_status=searchServers();
        if(length>=Servers)
        {
            if(length<QueueLength)
                length=length+1;
        }
        else if(length<Servers && length>0)
        {
            serStatus[Tot_status]=1;
            length=length+1;
            e.InsertLast(clk-((int)(Math.log(Math.random())/MeanService))+Servers,1);
        }
        else
        {
            length=length+1;
            serStatus[Tot_status]=1;
            e.InsertLast(clk-((int)(Math.log(Math.random())/MeanService))+Servers,1);
        }
        e.Delete();
        e.InsertLast(clk-((int)(Math.log(Math.random())/MeanArrival))+Servers,0);
        e.SortList();
    }
    void departure()
    {
        if(length>Servers)
        {
            length=length-1;e.Delete();
            e.InsertLast(clk-((int)(Math.log(Math.random())/MeanService))+Servers,1);
        }
        else if(length<=Servers && length>1)
        {
            length=length-1;int flag=100;
            for(int i=0;i<Servers;i++)
            {
                if(serStatus[i]==1)
                    flag=i;serStatus[i]=0;break;
            }
            if(flag==100 && serStatus[Servers-1]==1)
                serStatus[Servers-1]=0;
            e.Delete();
        }
        else if(length==1)
        {
            length=0;
            for(int i=0;i<Servers;i++)
            {
                serStatus[i]=0;
            }
            e.Delete();
        }
        else{}
        e.SortList();
    }
    void Initialize() throws IOException
    {
        clk=0;length=0;ReadMeans();
        for(int i=0;i<Servers;i++)
        {
            serStatus[i]=0;
        }
        System.out.println(serStatus.length);
        e.create(1, 0);
    }
    void Process()
    {
        Event e1=e.Head;
        clk=e1.s_time;
        if(e1.event_type==0)
        {
            arrival();
            System.out.println("************************************************");
            System.out.println("CLOCK : "+clk);
            System.out.println("ARRIVAL");
            OutStats();
        }
        if(e1.event_type==1)
        {
            departure();
            System.out.println("************************************************");
            System.out.println("CLOCK : "+clk);
            System.out.println("DEPARTURE");
            OutStats();
        }
    }
    void OutStats()
    {
        int freeServers = 0;
        for(int i=0;i<Servers;i++)
        {
            if(serStatus[i]==0)
                freeServers++;
        }
        for(int i=0;i<Servers;i++)
        {
            System.out.print(serStatus[i]);
        }
        System.out.println();
        System.out.println("Number of free servers                           : "+freeServers);
        System.out.println("Number of customers waiting in Queue for service : "+(length-(Servers-freeServers)));
        System.out.println("Number of customers being served                 : "+(Servers-freeServers));
        System.out.println();
        System.out.println("************************************************");
    }
    int searchServers()
    {
        int flag=100;
        for(int i=0;i<Servers;i++)
        {
            if(serStatus[i]==0)
                flag=i;break;
        }
        if(flag==100 && serStatus[Servers-1]==0)
            flag=Servers-1;
        return flag;
    }
}
public class MSFQ
{
    public static void main(String arg[]) throws IOException
    {
        Single s=new Single();int a;
        s.Initialize();
        DataInputStream obj=new DataInputStream(System.in);
        System.out.println("PRESS 1 TO START SIMULATION AND CTRL+C TO STOP..");
        a=Integer.parseInt(obj.readLine());
        if(a==1)
        {
            while(true)
            {
                s.Process();
            }
        }
    }
}
/*
 * Output:
 * Enter mean arrival rate :0.9
Enter mean service rate :0.4
Enter the number of servers :2
Enter the maximum QueueLength :4
2
PRESS 1 TO START SIMULATION AND CTRL+C TO STOP..
1
************************************************
CLOCK : 1
ARRIVAL
10
Number of free servers                           : 1
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 1

************************************************
************************************************
CLOCK : 3
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4
DEPARTURE
01
Number of free servers                           : 1
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 1

************************************************
************************************************
CLOCK : 5
DEPARTURE
00
Number of free servers                           : 2
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 0

************************************************
************************************************
CLOCK : 6
ARRIVAL
10
Number of free servers                           : 1
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 1

************************************************
************************************************
CLOCK : 8
DEPARTURE
00
Number of free servers                           : 2
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 0

************************************************
************************************************
CLOCK : 10
ARRIVAL
10
Number of free servers                           : 1
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 1

************************************************
************************************************
CLOCK : 12
DEPARTURE
00
Number of free servers                           : 2
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 0

************************************************
************************************************
CLOCK : 12
ARRIVAL
10
Number of free servers                           : 1
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 * CLOCK : 4310
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 1
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4312
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 2
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4314
DEPARTURE
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 1
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4314
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 2
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4318
DEPARTURE
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 1
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4319
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 2
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4321
DEPARTURE
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 1
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4322
ARRIVAL
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 2
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4323
DEPARTURE
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 1
Number of customers being served                 : 2

************************************************
************************************************
CLOCK : 4324
DEPARTURE
11
Number of free servers                           : 0
Number of customers waiting in Queue for service : 0
Number of customers being served                 : 2
 */