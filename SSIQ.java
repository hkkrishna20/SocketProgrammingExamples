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
    double MeanArrival,MeanService;
    void ReadMeans() throws IOException
    {
        DataInputStream obj=new DataInputStream(System.in);
        System.out.print("Enter mean arrival rate :");
        MeanArrival=Double.parseDouble(obj.readLine());
        System.out.print("Enter mean service rate :");
        MeanService=Double.parseDouble(obj.readLine());
    }
    void arrival()
    {
        if(ser_status==1)
        {
            length=length+1;
        }
        else
        {
            length=1;
            ser_status=1;
            e.InsertLast(clk-((int)(Math.log(Math.random())/MeanService))+1,1);
        }
        e.InsertLast(clk-((int)(Math.log(Math.random())/MeanArrival))+1,0);
        e.SortList();
        e.Delete();
    }
    void departure()
    {
        if(length>1)
        {
            length=length-1;
            e.InsertLast(clk-((int)(Math.log(Math.random())/MeanService))+1,1);
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
public class SSIQ
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
 Output:
 * Enter mean arrival rate :0.1
Enter mean service rate :0.2
PRESS 1 TO START SIMULATION AND CTRL+C TO STOP..
1
Arrival:The queue status at clock 1 is : CS
Departure:The queue status at clock 3 is :S
Arrival:The queue status at clock 3 is : CS
Arrival:The queue status at clock 8 is : C CS
Departure:The queue status at clock 9 is : CS
Arrival:The queue status at clock 9 is : C CS
Arrival:The queue status at clock 26 is : C C CS
Departure:The queue status at clock 32 is : C CS
Departure:The queue status at clock 33 is : CS
Departure:The queue status at clock 34 is :S
Arrival:The queue status at clock 57 is : CS
Arrival:The queue status at clock 59 is : C CS
Departure:The queue status at clock 64 is : CS
Arrival:The queue status at clock 66 is : C CS
Arrival:The queue status at clock 74 is : C C CS
Arrival:The queue status at clock 76 is : C C C CS
Departure:The queue status at clock 78 is : C C CS
Arrival:The queue status at clock 85 is : C C C CS
Arrival:The queue status at clock 87 is : C C C C CS
Arrival:The queue status at clock 89 is : C C C C C CS
Departure:The queue status at clock 91 is : C C C C CS
Arrival:The queue status at clock 95 is : C C C C C CS
Departure:The queue status at clock 100 is : C C C C CS
Departure:The queue status at clock 102 is : C C C CS
Departure:The queue status at clock 103 is : C C CS
Arrival:The queue status at clock 105 is : C C C CS
Departure:The queue status at clock 111 is : C C CS
Departure:The queue status at clock 114 is : C CS
Departure:The queue status at clock 115 is : CS
Arrival:The queue status at clock 126 is : C CS
Arrival:The queue status at clock 127 is : C C CS
Departure:The queue status at clock 133 is : C CS
Arrival:The queue status at clock 133 is : C C CS
Departure:The queue status at clock 134 is : C CS
Arrival:The queue status at clock 141 is : C C CS
Departure:The queue status at clock 141 is : C CS
Departure:The queue status at clock 142 is : CS
Arrival:The queue status at clock 144 is : C CS
Departure:The queue status at clock 155 is : CS
Departure:The queue status at clock 157 is :S
Arrival:The queue status at clock 162 is : CS
Departure:The queue status at clock 164 is :S
Arrival:The queue status at clock 164 is : CS
Departure:The queue status at clock 168 is :S
Arrival:The queue status at clock 168 is : CS
Departure:The queue status at clock 169 is :S
Arrival:The queue status at clock 170 is : CS
Arrival:The queue status at clock 172 is : C CS
Departure:The queue status at clock 182 is : CS
Departure:The queue status at clock 186 is :S
Arrival:The queue status at clock 190 is : CS
Arrival:The queue status at clock 192 is : C CS
Departure:The queue status at clock 195 is : CS
Arrival:The queue status at clock 197 is : C CS
Departure:The queue status at clock 197 is : CS
Departure:The queue status at clock 202 is :S
Arrival:The queue status at clock 222 is : CS
Departure:The queue status at clock 227 is :S
Arrival:The queue status at clock 244 is : CS
Departure:The queue status at clock 245 is :S
Arrival:The queue status at clock 249 is : CS
Departure:The queue status at clock 257 is :S
Arrival:The queue status at clock 259 is : CS
Departure:The queue status at clock 261 is :S
Arrival:The queue status at clock 267 is : CS
Departure:The queue status at clock 270 is :S
Arrival:The queue status at clock 274 is : CS
Departure:The queue status at clock 275 is :S
Arrival:The queue status at clock 280 is : CS
Arrival:The queue status at clock 282 is : C CS
Departure:The queue status at clock 285 is : CS
Arrival:The queue status at clock 287 is : C CS
Departure:The queue status at clock 290 is : CS
Departure:The queue status at clock 293 is :S
Arrival:The queue status at clock 294 is : CS
Arrival:The queue status at clock 295 is : C CS
Departure:The queue status at clock 301 is : CS
 */
