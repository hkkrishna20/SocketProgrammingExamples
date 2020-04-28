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
        Event t=Head;
        while(t!=null)
        {
            Event s=t;
            while(s.next!=null)
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
                s=s.next;
            }
            t=t.next;
        }
    }
}
class Single
{
    static int clk=0;static int length=0;EventList e=new EventList();static int ser_status;
    int QueueLength;
    static int nextArrival,nextDeparture;
    double MeanArrival,MeanService;
    void ReadMeans() throws IOException
    {
        DataInputStream obj=new DataInputStream(System.in);
        System.out.print("Enter the length of the queue :");
        QueueLength=Integer.parseInt(obj.readLine());
        System.out.print("Enter mean arrival rate :");
        MeanArrival=Double.parseDouble(obj.readLine());
        System.out.print("Enter mean service rate :");
        MeanService=Double.parseDouble(obj.readLine());
    }
    void arrival()
    {
        if(ser_status==1)
        {
            if(length<QueueLength)
                length=length+1;
        }
        else
        {
            length=1;
            ser_status=1;nextDeparture=clk-((int)(Math.log(Math.random())/MeanService))+1;
            e.InsertLast(nextDeparture,1);
        }
        nextArrival=clk-((int)(Math.log(Math.random())/MeanArrival))+1;
        e.InsertLast(nextArrival,0);
        e.SortList();
        e.Delete();
    }
    void departure()
    {
        if(length>1)
        {
            length=length-1;
            nextDeparture=clk-((int)(Math.log(Math.random())/MeanService))+1;
            e.InsertLast(nextDeparture,1);
            e.SortList();
        }
        else if(length==1)
        {
            length=0;ser_status=0;
        }
        else
        {

        }
        e.Delete();
    }
    void Initialize() throws IOException
    {
        clk=0;length=0;ser_status=0;e.create(1, 0);ReadMeans();
    }
    void Process()
    {
        Event e1=e.Head;
        clk=e1.s_time;
        if(e1.event_type==0)
        {
            arrival();System.out.print("Arrival:");
        }
        if(e1.event_type==1)
        {
            departure();System.out.print("Departure:");
        }
        System.out.print("The queue status at clock "+clk+" is :");
        for(int i=0;i<length;i++)
        {
            System.out.print(" "+"C");
        }
        System.out.println("S");
    }
}
public class SSFQ
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
 * Enter the length of the queue :5
Enter mean arrival rate :0.1
Enter mean service rate :0.2
PRESS 1 TO START SIMULATION AND CTRL+C TO STOP..
1
Arrival:The queue status at clock 1 is : CS
Departure:The queue status at clock 8 is :S
Arrival:The queue status at clock 10 is : CS
Departure:The queue status at clock 16 is :S
Arrival:The queue status at clock 26 is : CS
Departure:The queue status at clock 29 is :S
Arrival:The queue status at clock 65 is : CS
Arrival:The queue status at clock 73 is : C CS
Arrival:The queue status at clock 74 is : C C CS
Arrival:The queue status at clock 75 is : C C C CS
Arrival:The queue status at clock 77 is : C C C C CS
Departure:The queue status at clock 80 is : C C C CS
Departure:The queue status at clock 97 is : C C CS
Departure:The queue status at clock 98 is : C CS
Arrival:The queue status at clock 109 is : C C CS
Departure:The queue status at clock 113 is : C CS
Departure:The queue status at clock 116 is : CS
Departure:The queue status at clock 123 is :S
Arrival:The queue status at clock 149 is : CS
Departure:The queue status at clock 155 is :S
Arrival:The queue status at clock 156 is : CS
Departure:The queue status at clock 159 is :S
Arrival:The queue status at clock 173 is : CS
Departure:The queue status at clock 179 is :S
Arrival:The queue status at clock 179 is : CS
Departure:The queue status at clock 180 is :S
Arrival:The queue status at clock 193 is : CS
Departure:The queue status at clock 194 is :S
Arrival:The queue status at clock 216 is : CS
Arrival:The queue status at clock 217 is : C CS
Departure:The queue status at clock 219 is : CS
Departure:The queue status at clock 224 is :S
Arrival:The queue status at clock 231 is : CS
Departure:The queue status at clock 238 is :S
Arrival:The queue status at clock 257 is : CS
Departure:The queue status at clock 260 is :S
Arrival:The queue status at clock 261 is : CS
Departure:The queue status at clock 267 is :S
Arrival:The queue status at clock 272 is : CS
Departure:The queue status at clock 273 is :S
Arrival:The queue status at clock 277 is : CS
Departure:The queue status at clock 278 is :S
Arrival:The queue status at clock 278 is : CS
Arrival:The queue status at clock 280 is : C CS
Departure:The queue status at clock 282 is : CS
Departure:The queue status at clock 284 is :S
Arrival:The queue status at clock 295 is : CS
Departure:The queue status at clock 297 is :S
Arrival:The queue status at clock 298 is : CS
Arrival:The queue status at clock 299 is : C CS
Arrival:The queue status at clock 301 is : C C CS
 */