/*   Program to build B-Tree
		ASSIGNMENT-13*/
#include<iostream.h>

class node
{
public:
	node()
	{
		numkeys=0;
	}
	char c[5];
	node *link[5];
	int numkeys;
	void initialize()
	{
		for(int i=0; i<5; i++)
		{
			this->link[i]=NULL;
			this->c[i]=0;
		}
	}
	int insert_node(char ch,node *ptr);
	int insert_index(char ,node* );
	int largestkey();
	int updatekey(char ,char );
	int split(node *newnode);
	/*int remov(char ,node*);*/
	node * searching(const char key);
	int remov_index(char );
	node * findparent();
	void print()
	{
		if(this == NULL)return ;
		for(int i=0; i<5;i++)
				cout<<"\nc["<<i<<"] ::"<<c[i];

		cout<<"\n\n";
	}	
	void display();


};




node * root;
int level,height;

class btree
{
protected:
	node * findleaf(const char key);
	node * newnode();
	node * fetch(node *);
	

public:


	btree()
	{
	
		int level=0;
		int height=1;
		root=new node;
		root->initialize();
		
	}
	void create();
	void insert(const char key);
	node * searching(const char key);
	void display();
	

};


void btree::create()
{
	char ch;
	int flag=0;
	while(1)
	{
		cout<<"\nENTER A CHARACTER KEY TO BE INSERTED:";
		cin>>ch;
		insert(ch);
		cout<<"\nCONTINUE?(y/n)";
		cin>>ch;
		if(ch!='y' && ch!='Y')
			break;
	}

}



void btree::insert(const char key)
{

	int newlargest=0,overflow;
	char prevkey,largestkey;
	node *thisnode, *new_node ,*parentnode;
	thisnode =findleaf(key);

	if(key > thisnode->largestkey())
	{
		newlargest =1;
		prevkey=thisnode->largestkey();
	}

	overflow=thisnode ->insert_node(key,NULL);
	
	
		if(newlargest)
		{
	
			node *temp=thisnode;
			while(1)
			{
				if(temp==root)
					break;
		
				temp=temp->findparent();
				temp->updatekey(prevkey,key);
			
			
			}

		}
	

	while(overflow)
	{
		largestkey=thisnode->largestkey();

		new_node = new node;
		new_node->initialize();
		int flag=thisnode->split(new_node);
	
		level--;
		
		if(level == 0 || flag == 0)
			break;


		parentnode = thisnode->findparent ();
		overflow = parentnode->updatekey(largestkey,thisnode->largestkey());
		overflow = parentnode->insert_node(new_node->largestkey(),new_node);
		thisnode = parentnode;
	}

	root->print();

	return ;
}


node * btree::findleaf(const char key)
{
	node* address=root;
	
	int flag=0;
	for(int i=0; i<5; i++)
		if(address->link[i]==NULL)
			continue;
		else
			flag = 1;
	if(flag == 0)
		return root;
	address = address->searching(key);
	if(address == NULL)
		return root;
	while(1)
	{
		
		if(address->searching(key) == NULL)
			break;
		address=address->searching(key);
			
	}


	return address;

	
	
}

node * node::findparent()
{
	char key = this->largestkey();
		node* address=root;
		node * parent =root,*grandparent;
	if(this == root)
		return root;

	else 
	{
		
		while(1)
		{
			if(address == this )//|| address == NULL)
				break;
			if(address == NULL)
				return grandparent;
			grandparent=parent;
			parent = address;

			address=address->searching(key);
			
		}
	}

	return parent;
	
}


int node::split(node * newnode)
{
	if(numkeys < 5) return 0;

	int midpt=(numkeys+1)/2;
	int numnewkeys=numkeys - midpt;

	if(numkeys >5 || numkeys <2)
		return 0;
	
	for(int i=midpt; i<numkeys ; i++)
	{
		newnode->c[i-midpt]=c[i];
		newnode->c[i]=0;
		c[i]=0;
		newnode->link[i-midpt]=link[i];
		newnode->c[i]=0;
		link[i]=NULL;
	}
	
	newnode->numkeys=numnewkeys;
	numkeys = midpt;

	if(this == root)
	{
		node *temp;
		temp=new node;
		temp->initialize();
		temp->c[0]=this->largestkey();
		temp->link[0]=this;
		temp->c[1]=newnode->largestkey();
		temp->link[1]=newnode;
		temp->numkeys=2;
		root=temp;
		level++;height++;
		return 0;
	}
	


	
	return 1;
}


int node::updatekey(char oldkey,char newkey)
{
	for(int i=0; i<5; i++)
	{
	
		if(c[i]==oldkey)
		{
			c[i]=newkey;	
		}
		
	}
	return 1;
}


int node::remov_index(char key)
{


	numkeys--;
	return 1;
}


int node::insert_node(const char key,node *ptr)
{
	int result;
	result=insert_index(key,ptr);
	if(numkeys >=5)return 1;
	if(!result )return 1;

	return 0;
}

int node::insert_index(const char key,node *ptr)
{
	int i=numkeys-1;
	if(numkeys == 5)
		return 0;

	for(i=numkeys-1; i>=0; i--)
	{
		if(key > c[i])
			break;
		c[i+1]=c[i];
		link[i+1]=link[i];
	}
	c[i+1]=key;
	link[i+1]=ptr;
	numkeys++;

	return 1;
}


int node::largestkey()
{
	if(numkeys>0)
		return c[numkeys-1];
	else return c[0];

}


/*node* btree::fetch(node* address)
{
	
	node * newnode=new node;
	newnode->initialize();
	return newnode;
}

node* btree::searching(const char key)
{
	node * leafnode;
	leafnode=findleaf(key);
	return leafnode->searching(key);
}
*/


node* node::searching(const char key)
{
	//node *n=NULL;
	for(int i=0; i<5 ; i++)
	{
		if(c[i]==0)
			break;
		
		if(c[i] >= key)
		{
			if(i > 0)
				return link[i-1];
			else
				return link[0];
		}
	}
	return link[i-1];
}

void node::display()
{	

	this->print();
	this->link[0]->print();	
	this->link[1]->print();
	this->link[2]->print();
	this->link[4]->print();
	

}

void btree::display()
{
	root->display();

}
	
		





void main()
{
	btree b;
	b.create();
	b.display();
}



















