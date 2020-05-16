/*   ASSIGNMENT-10
    K-WAY MERGE*/
#include "iostream.h"
#include "math.h"

#define SIZE 100

class list
{
	int num_lists;
	int * * lists;
	int * current;
	int * num_elements;
public:

	void get_data();
	int give_next_item(int i);
	int give_num_lists();

};
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
	for(int i= (n+1)/2,j=0; i<=n; i++,j++)
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

	int x=a[1];
	
	update_node(1);

    //int x=a[1];

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

void main()
{
	list l;
	selection_tree s;
	int x;

	l.get_data();
	s.build_tree(l);
	
	cout<<"\nThe merged list is: ";
	while((x=s.remove())!=-1)
		cout<<x<<" ";
}




/*OUTPUT
enter the number of lists:2

enter the number of elements in 0 list:4

enter the number of 0 list in ascending order 1 2 3 4

enter the number of elements in 1 list:2

enter the number of 1 list in ascending order 2 3

the merged list is 1 2 3 4*/
