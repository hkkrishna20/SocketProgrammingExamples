/*    ASSIGNMENY-12
Sorting by Replacement selection */

using namespace std;
#include<iostream>
#include<fstream>
#include"kway.cpp"

#define SIZE 3

class minheap
{
	public:
           void input();
	    void insert(int,int*,int*);
           int delete_one(int*,int*);
           void display(int *heap,int now)
           {
                        cout<<endl;
                        for(int i=1;i<=now;i++)
                                cout<<heap[i]<<'\t';
                        cout<<endl;
           }
           void replacement_selection();
};
void minheap::input()
{
        cout<<"\n\nEnter some numbers to be sorted\n"
               <<" Using Replace ment selection algorithm\n"
               <<"Enter -1 to stop :\n";
               
        ofstream out("input.txt");
        int n;
        cin>>n;
        while(n!=-1)
        {
                out<<n<<endl;
                cin>>n;
        }
        out.close();
}

void minheap::insert(int n,int *heap,int*now)
{
        if(*now>SIZE)
        {
                cout<<"Momory insufficient";
                return;
        }
        heap[++(*now)]=n;
        //Reorder the heap
        int k=(*now);
        while(k>1)            //k has a parent
        {
                if(heap[k]<heap[k/2])
                {
                        int t=heap[k];
                        heap[k]=heap[k/2];
                        heap[k/2]=t;
                        
                         k/=2;
                }
                else
                        break;
        }
}

int minheap::delete_one(int *heap,int*now)
{
        int val;
        if(*now<1)
                return -1;
        val=heap[1];
        heap[1]=heap[*now];
        (*now)--;
        
        //Reorder the heap by moving down
        int k=1;
        int newk;
        while(2*k<=*now)     //k has atleast one chaild
        {
                //Set newk to the index of the smallest chaild of k
                if(2*k==*now)     //if k has only left chaid
                {
                        newk=2*k;
                }
                else                //k has two chailds
                {
                        if(heap[2*k]<heap[2*k+1])
                                newk=2*k;
                        else
                                newk=2*k+1;
                }
                if(heap[k]<heap[newk])
                        break;
                else
                {
                        int t;
                        t=heap[k];
                        heap[k]=heap[newk];
                        heap[newk]=t;
                        
                        k=newk;
                }
        }
        return val;
}

void minheap::replacement_selection()
{
        ofstream obj[30];
        int no=0;
	 ifstream file("input.txt");
	
        int pheap[SIZE+1];
        int sheap[SIZE+1];
        int nowp=0;
        int nows=0;   
	//Initialize the primary heap
        int n;
        for(int i=1;i<=SIZE;i++)
        {
                file>>n;
                if(!file.fail())
                        insert(n,pheap,&nowp);
        }
        char flname[15];
        int last;
	 cout<<"now the primary heap is:\n";
	 display(pheap,nowp);
		  
	while(1)
        {
	 	no++;
		sprintf(flname,"file%d.txt",no);
		obj[no].open(flname);
	
		int out=delete_one(pheap,&nowp);
		
		if(out==-1)
			break;
		obj[no]<<out<<endl;
		cout<<out<<"has gone to "<<no<<" file"<<endl;
		
		last=out;
		file>>n;
		if(!file.fail())
		{
			insert(n,pheap,&nowp);
			cout<<endl<<n<<"has gone to pheap\n";
		}
                while(1)
                {
                        out=delete_one(pheap,&nowp);
			   if(out==-1)
			   break;
                        if(out>last)
                        {
                                obj[no]<<out<<endl;
				    cout<<out<<"has gone to "<<no<<" file"<<endl;
                                last=out;
                        }
                        else
                        {
                                insert(out,sheap,&nows);
				    cout<<endl<<n<<"has gone to sheap\n";
				    out=delete_one(pheap,&nowp);
				    if(out>last)
				    {
				    	obj[no]<<out<<endl;
					cout<<out<<"\nhas gone to "<<no<<" file"<<endl;
					last=out;
				     }
				     else
				     {
				     	   insert(out,sheap,&nows);
					   cout<<endl<<n<<"has gone to sheap\n";
				     }
					if(nowp==0)
					{
						file>>n;
						if(!file.fail())
						{
							insert(n,sheap,&nows);
							cout<<endl<<n<<"has gone to sheap\n";
						}
						break;
					}
                        }
                        file>>n;
			   if(!file.fail())
			   {
				   insert(n,pheap,&nowp);
				   cout<<endl<<n<<"has gone to pheap\n";
			   }
                }
                
		  cout<<endl<<"nowp"<<nowp<<endl;
		  cout<<endl<<"nows"<<nows<<endl;
		  display(sheap,nows);
                if(nowp==0&&nows==0)
		  {
		         cout<<"\n Both the heaps are empty \n";
                        break;
		  }
                        
                for(int i=1;i<=nows;i++)
                        pheap[i]=sheap[i];
                nowp=nows;
                nows=0;
        }
        
        for(int p=1;p<=no;p++)
                obj[p].close();
        
        k_way vasi;
        vasi.Merge(no);
        vasi.output();
}
int main()
{
	minheap obj;
       obj.input();
       obj.replacement_selection();
	return 0;
}
