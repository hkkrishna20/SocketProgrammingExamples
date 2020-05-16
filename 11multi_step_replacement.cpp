				ASSIGNMENT-11&12

PROGRAM TO PERFORM SORTING A LARGE DISK FILE USING MULTI STEP MERGING AND REPLACEMENT SELECTION */

#include "fstream.h"
#include "math.h"
#include "stdlib.h"

#define MAX_RUNS 100
#define SIZE 100
#define MAX_RUN_SIZE 100
#define max 100



class heap
{
	int a[SIZE];
	void siftup(int i);
	void siftdown(int i);
public:
	heap();
	void build_heap();
	void insert(int num);
	int deletemin();
	void put_data();
	int empty();
	int no_of_elements();
};
heap::heap()
{
	int i;
	a[0] = 0; //no. of elements in heap
	for(i=1; i<SIZE; i++)
		a[i] = -1;
}
heap::no_of_elements()
{
	return a[0];
}

void heap::siftup(int i)
{//i is index of heap element to be sifted up
	int temp = a[i];
	int p =  i/2; //parent index
	while(temp < a[p] && i>1)
	{
		a[i] = a[p];
		i=p;
		p=i/2;
	}
	a[i] = temp;
}
void swap(int &a, int &b)
{
	int temp;

	temp = a;
	a    = b;
	b    = temp;
}

void heap::siftdown(int i)
{
	int lchild = 2*i;
	int rchild = 2*i+1;

	while(rchild <= a[0])
	{
		if(a[lchild] < a[i] && a[lchild] <= a[rchild] )
		{
			swap(a[lchild],a[i]);
			i = lchild;
			lchild = 2*i;
			rchild = 2*i+1;
		}
		else if(a[rchild] < a[i] && a[rchild] <= a[lchild] )
		{
			swap(a[rchild],a[i]);
			i = rchild;
			lchild = 2*i;
			rchild = 2*i+1;
		}
		else
			break;
	}
	if(lchild <= a[0] && a[lchild] < a[i])
		swap(a[lchild],a[i]);
}
void heap::build_heap()
{
	int n,i;

	cout<<endl<<"enter no. of elements in the heap: ";
	cin >>n;
	a[0] = n;
	cout<<endl<<"enter the elements: ";

	//build complete binary tree
	for(i=1; i<=n; i++)
		cin>>a[i];
	//heapify the binary tree
	for(i= n/2; i>=1; i--)
		siftdown(i);
}
void heap::insert(int num)
{
	int n;
	n = ++a[0];
	if(n>SIZE)
	{
		cout<<"memory limit exceeded. no insertion performed";
		a[0]--;
		return;
	}
	a[n] = num;
	siftup(n);
}
int heap::deletemin()
{
	int n,temp;
	if(a[0] == 0)
	{
		cout<<"empty heap. no deletion possible.";
		return -1;
	}
	temp = a[1];
	n = a[0]--;
	a[1] = a[n];
	siftdown(1);
	return temp;
}

void heap::put_data()
{
	int i;
	cout<<endl;
	cout<<"heap is: ";
	for(i=0; i<=a[0]; i++)
		cout<<" "<<a[i];
	cout<<endl;
}

int heap::empty()
{
	if(a[0] == 0)
		return 1;
	return 0;
}


class replacement_selection
{
	int *input;
	int no_of_input_elements;
	int **runs;
	int no_of_runs;
	int *no_of_elements;
	int current;
	int heap_size;
public:
	replacement_selection();
	void get_data();
	void create_runs();
	void put_data();
	void swap(heap *h1, heap *h2 );
	friend class list;
};

replacement_selection::replacement_selection()
{
	runs = new int * [MAX_RUNS];
	no_of_elements = new int[MAX_RUNS];

	for(int i=0; i<MAX_RUNS; i++)
	{
		runs[i] = new int[MAX_RUN_SIZE];
		no_of_elements[i] =0;
	}
	current =0;
}
	
void replacement_selection::get_data()
{
	cout<<"enter no. of elements: ";
	cin >>no_of_input_elements;

	input = new int[no_of_input_elements];


	cout<<"enter the elements: ";

	for(int i=0; i<no_of_input_elements; i++)
		cin>>input[i];
	
	cout<<"enter heap size: ";
	cin >>heap_size;
}

void replacement_selection::create_runs()
{
	int x,y,z,i=0,j;

	heap h1,h2;

	for(j=0; j<heap_size && j<no_of_input_elements; j++)
	{
		x = input[current++];
		h1.insert(x);
	}
	while(current != no_of_input_elements)
	{
		y = input[current++];
		z = h1.deletemin();

		runs[i][no_of_elements[i]++] = z;
		if(h1.empty())
		{
			swap(&h1,&h2);
			i++;
		}
		if(y<z)
			h2.insert(y);
		else
			h1.insert(y);

	}
	while(!h1.empty())
	{
		z = h1.deletemin();
		runs[i][no_of_elements[i]++] = z;
	}
	if(!h2.empty())
		i = i+1;
	while(!h2.empty())
	{
		z = h2.deletemin();
		runs[i][no_of_elements[i]++] = z;
	}
	no_of_runs = i+1;
}
void replacement_selection::put_data()
{
	cout<<endl<<"sorted runs are:";

	for(int i=0; i<no_of_runs; i++)
	{
		cout<<endl<<"sorted run " <<i+1<<" is: ";
		for(int j=0; j<no_of_elements[i]; j++)
			cout<<"  "<<runs[i][j];
	}
}
void replacement_selection::swap(heap *h1, heap *h2)
{
	heap temp;

	temp = *h1;
	*h1   = *h2;
	*h2   = temp;
}
class replacement_selection;

class list: public replacement_selection
{
	int num_lists;
	int * * lists;
	int * current;
	int * num_elements;

public:

	void get_data();
	int give_next_item(int i);
	int give_num_lists();
	void build_list(replacement_selection s);
};
void list::build_list(replacement_selection s)
{
	num_lists = s.no_of_runs;
	
	lists = new int * [num_lists];
	current = new int [num_lists];
	num_elements = new int [num_lists];

	for(int i=0; i<num_lists; i++)
	{
		num_elements[i] = s.no_of_elements[i];
		lists[i] = new int[num_elements[i]];
		current[i] =0;
		for(int j=0; j<num_elements[i]; j++)
			lists[i][j] = s.runs[i][j];
	}
}
	
int list::give_num_lists()
{
	return num_lists;
}
void list::get_data()
{
	cout<<"\nEnter the number of lists: ";
	cin>>num_lists;

	lists       = new int * [num_lists];
	current     = new int [num_lists];
	num_elements = new int [num_lists];

	for(int i=0; i<num_lists; i++)
	{
		cout<<"\nenter the number of elements in "<<i<<" list: ";
		cin>>num_elements[i];
	
		lists[i]  = new int [num_elements[i]];
		current[i]= 0;
		
		cout<<"\n enter the numbers of "<<i<<" list in ascending order ";
			
		for(int j=0; j<num_elements[i]; j++)
			cin>>lists[i][j];
	}
}
int list::give_next_item(int i)
{
	int x;
	if(current[i]<num_elements[i])
	{
		x=current[i]++;
		return lists[i][x];
	}
	return -1;
}



class selection_tree
{
	int a[SIZE]; //complete binary tree
	int n; //no.of elements in tree = a[0]
	list l;
public:
	void build_tree(list l);
	int remove();
	void update_node(int i);
};
void selection_tree::build_tree(list ls) 
{

	l=ls;
	int h=ceil(log(l.give_num_lists())/log(2) )+ 1;
	n= pow(2,h)-1;
	
	//leaf nodes initialisation
	for(int i= (n+1)/2,j=0; i<n; i++,j++)
		a[i]=l.give_next_item(j);
	//non-leaf nodes initialisation
	for(i=n/2; i>0; i--)
	{
		 if(a[2*i]==-1)
			a[i]=a[2*i+1];
		 else if(a[2*i+1]==-1)
			 a[i]=a[2*i];
		 else
			 a[i]=a[2*i]<a[2*i+1] ? a[2*i]:a[2*i+1];
	}
	
}
int selection_tree::remove()
{
	if(a[1] == -1)
		return -1;

	//int x=a[1];
	
	update_node(1);

    int x=a[1];

	return x;
}
void selection_tree::update_node(int i)
{
	if(i>n/2)
	{
		a[i]=l.give_next_item(i-(n+1)/2);
		return;
	}
	if(a[2*i] == a[i])
		update_node(2*i);
	if(a[2*i+1] == a[i])
		update_node(2*i+1);

	if(a[2*i] == -1)
		a[i] = a[2*i+1];
	else if(a[2*i+1] == -1)
		a[i] = a[2*i];
	else
		a[i] = a[2*i] < a[2*i+1] ? a[2*i] : a[2*i+1];
}

class multi_merge
{
	int k;
	int *m;
	int di,n[100];

	fstream file,newfile;
public:
	multi_merge()
	{
		cout<<"\nENTER THE VALUE OF K::";
		cin>>k;
		
	}
	void create_largefile();
	//int random();
	void write();
	void generate();
	void read();
	void sorting(int* ,int );
	void merg(int );
	void display(int *s,int n)
	{
		for(int j=0; j<n; j++)
			cout<<s[j]<<"  ";
		cout<<"\n\n";
	}
};

void multi_merge::generate()
{
	int i;
	

	file.open("data.txt",ios::out);
	for(i=0;i<max;i++)
	{
        int c=(rand()%100);
       
		file<<"\n"<<c;

	}
	file.close();
}

void multi_merge::create_largefile()
{
	int num;
	//n=new int[max];
	generate();

	
	file.open("data.txt",ios::in);

	cout<<"\n\nNUMBERS BEFORE SORTING \n\n";
	for( int i=0; i<max; i++)
	{
		//cin>>n[i];
		file>>num;
		cout<<num<<"  ";
		n[i]=num;
	}
	 di=max/k;
	 
	file.close();
	//read();
}

void multi_merge::read()
{
	int m1[100];
	int m[100];
	newfile.open("new.txt",ios::in|ios::out);
	file.open("data.txt",ios::in|ios::out);
	di=max/k;
	cout<<di<<endl;
	cout<<"\n\n"<<k<<"  SORTED LISTS BEFORE MERGING \n";
	for(int i=0; i<k; i++)
	{
		file.seekg(di*i*sizeof(int),ios::beg);
		file.read((char*)&m,(sizeof(int)*di));
		for(int j=0; j<di; j++)
			m1[j]=n[j+i*di];
		sorting(m1,di);
		display(m1,di);
	}
	merg(di);
}

void multi_merge::sorting(int *s,int n)
{
   int i,j;
   for(i=0;i<n;i++)
   {
       for(j=0;j<n-1;j++)
       {
	   if(s[j]>s[j+1])
	   {
	      int temp=s[j];
	      s[j]=s[j+1];
	      s[j+1]=temp;
	   }
       }
   }
   
   	
}

void multi_merge::merg(int di)
{
	int i=0,j,s[10][10];
	file.open("new.txt",ios::in|ios::out);

	for( i=0; i<k; i++)
	{
		for(int j=0; j<di; j++)
		{
			s[i][j]=n[i*di+j];
		}
		sorting(s[i],di);
	}

	sorting(n,max);

	cout<<"\n  CONTENTS OF FILE AFTER MERGING \n\n";

	for( j=0; j<max; j++)
	{
		newfile.open("new.txt",ios::in);
		newfile<<n[j];
		cout<<n[j]<<"  ";
	}
}


void main()
{
	int ch;
	cout<<"\nSELECT	 CHOICE FOR SORTING\n\n1.MULTI STEP MERGEING\n\n2.REPLACEMENT SELECTION\n\t";
	cin>>ch;
	if(ch==1)
	{
		multi_merge m;
		m.create_largefile();
		m.read();
		
	}
	else if(ch==2)
	{
		replacement_selection s;
	list l;
	selection_tree t;
	int x;
	//cout<<"\tprogram to perform replacement selection. "<<endl;

	s.get_data();
	s.create_runs();
	s.put_data();
	l.build_list(s);
	t.build_tree(l);

	cout<<endl<<"SORTED FILE IS: ";
	while((x=t.remove())!=-1)
		cout<<x<<" ";
	

	}
}




/*OUTPUT:

  
SELECT   CHOICE FOR SORTING

1.MULTI STEP MERGEING

2.REPLACEMENT SELECTION
        1

ENTER THE VALUE OF K::10


NUMBERS BEFORE SORTING

41  67  34  0  69  24  78  58  62  64  5  45  81  27  61  91  95  42  27  36  91
  4  2  53  92  82  21  16  18  95  47  26  71  38  69  12  67  99  35  94  3  1
1  22  33  73  64  41  11  53  68  47  44  62  57  37  59  23  41  29  78  16  3
5  90  42  88  6  40  42  64  48  46  5  90  29  70  50  6  1  93  48  29  23  8
4  54  56  40  66  76  31  8  44  39  26  23  37  38  18  82  29  41  10


10  SORTED LISTS BEFORE MERGING
0  24  34  41  58  62  64  67  69  78

5  27  27  36  42  45  61  81  91  95

2  4  16  18  21  53  82  91  92  95

12  26  35  38  47  67  69  71  94  99

3  11  11  22  33  41  53  64  68  73

23  29  37  41  44  47  57  59  62  78

6  16  35  40  42  42  48  64  88  90

1  5  6  29  46  48  50  70  90  93

8  23  29  31  40  54  56  66  76  84

18  23  26  29  37  38  39  41  44  82


  CONTENTS OF FILE AFTER MERGING

0  1  2  3  4  5  5  6  6  8  11  11  12  16  16  18  18  21  22  23  23  23  24
  26  26  27  27  29  29  29  29  31  33  34  35  35  36  37  37  38  38  39  40
  40  41  41  41  41  42  42  42  44  44  45  46  47  47  48  48  50  53  53  54
  56  57  58  59  61  62  62  64  64  64  66  67  67  68  69  69  70  71  73  76
  78  78  81  82  82  84  88  90  90  91  91  92  93  94  95  95  99

  



  
SELECT   CHOICE FOR SORTING

1.MULTI STEP MERGEING

2.REPLACEMENT SELECTION
        2
enter no. of elements: 5
enter the elements: 6 4 8 2 9
enter heap size: 3

sorted runs are:
sorted run 1 is:   4  6  8  9
sorted run 2 is:   2
SORTED FILE IS: 2 4 6 8 9 


  */






	







