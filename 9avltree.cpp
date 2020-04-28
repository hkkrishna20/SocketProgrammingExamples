/* program to do promiry operations on Index files using AVL trees
	ASSIGNMENT-9*/


#include <fstream.h>
#include <string.h>
#include <math.h>

#include <iostream.h>


class avltree
{
	int data;
	int index;
	avltree *lchild,*rchild,*root;	
public:
	avltree()
	{
		root=NULL;
	}
	void create();

	void insert(int );
	void delet(int );
	void deletnode();

	void adjust();
	void check(avltree * );

	avltree * findparent(avltree * );
	avltree * find_inorder_successor(avltree * );

	void lrotate(avltree *);
	void rrotate(avltree *);


	void showtree();
	void indexing();

	int height(avltree * );
	int max(int a,int b)
	{
		if(a<=b)
			return b;
		return a;
	}

	void display(avltree *);
}*node;


// function definitions.....
void avltree::create()
{
	node = NULL;
	int temp;
	char ch;
	do
	{
		cout<<"\nENTER THE DATA: ";
		cin>>temp;
		insert(temp);
		cout<<"\nONE MORE NODE: (Y/N): ";
		cin>>ch;
	}while(ch=='y' || ch=='Y');
	
}

void avltree::insert(int num)
{
	avltree *n;
	n=new avltree;
	n->data=num;
	n->index=0;
	n->lchild=NULL;
	n->rchild=NULL;

	if(root==NULL)
		root=n;

	else
	{
		avltree *temp=root,*parent=root;
		while(temp != NULL)
		{
			if(n->data <= temp->data)
			{
				parent = temp;
				temp= temp->lchild;
			}

			else
			{
				parent = temp;
				temp= temp->rchild;
			}
		}


		if(n -> data <= parent->data)
			parent->lchild=n;
		else
			parent->rchild=n;
	}
	root->indexing();	
	adjust();
}

void avltree::deletnode()
{
	int temp;
	char ch;
	do
	{
		cout<<"\nENTER THE DATA TO DELET: ";
		cin>>temp;
		delet(temp);
		display(root);
		cout<<"\nONE MORE NODE: (Y/N): ";
		cin>>ch;
	}while(ch=='y' || ch=='Y');
	
}

void avltree::delet(int key)
{
	avltree *temp=root,*del;
	while(1)
	{
		if(temp == NULL)
		{ 
			cout<<"\nNOT FOUND\n";
			return;
		}
		if(temp->data == key)
		{
			del=temp;
			break;
		}
		else if(temp->data < key)
			temp=temp->rchild;
		else if(temp->data > key)
			temp=temp->lchild;
	}
	
	 if(del->lchild == NULL && del->rchild ==NULL)
	{	
		if(del == root)
			root=NULL;
		else
		{
		avltree * parent=findparent(del);

		if(parent ->rchild == del)
			parent ->rchild = NULL;
		else 
			parent ->lchild =NULL;
		delete del;
		}

	}

	else if(del->lchild != NULL && del->rchild == NULL)
	{
		if(del==root)
			root=root->lchild;
		else
		{
		avltree * parent=findparent(del);

		if(parent->data < del->data)
			parent->rchild = del->lchild;
		else
			parent->lchild = del->lchild;
		}
	}
	else if(del->lchild == NULL && del->rchild != NULL)
	{
		if(del == root)
			root=root->rchild;
		else
		{
		avltree * parent=findparent(del);

		if(parent->data < del->data)
			parent->rchild = del->rchild;
		else
			parent->lchild = del->rchild;
		}
	}
	else if(del == root)
	{
		int flag=0;
		avltree * succ=find_inorder_successor(del);
		avltree * parent=findparent(succ);
		//cout<<succ->data; 
		if(parent == root)
		{
			succ->lchild = root ->lchild;
			root = succ;
		}

		else if(succ->rchild != NULL)
		{
			parent->lchild=succ->rchild;
			succ->rchild = root->rchild;
			succ->lchild = root ->lchild;
			root = succ;
		}
	
		else
		{
			parent->lchild=NULL;
			succ->rchild=root->rchild;
			succ->lchild=root->lchild;
			root = succ;
		}
	
	}
	else
	{
		avltree *parent = findparent(del);
		avltree * succ=find_inorder_successor(del);
		avltree * sparent=findparent(succ);
		if(succ ->rchild!=NULL)
		{
			succ->lchild = del->lchild;
			if(del != sparent)
			  succ->rchild->rchild=del->rchild;
		}
		else
		{
			succ->lchild=del->lchild;
			if(del != sparent)
				succ->rchild=del->rchild;
		}
		if(sparent->data < succ->data)
			sparent->rchild = NULL;
		else
			sparent->lchild = NULL;


		if(parent->data < del->data)
			parent->rchild = succ;
		else
			parent->lchild = succ;
	}

	root->indexing();
	adjust();
}



void avltree::check(avltree * temp)
{
	if(temp == NULL)
		return;
	if(temp->index == 2 || temp->index == -2)
		node=temp;
	check(temp->lchild);
	check(temp->rchild);	
}

avltree * avltree::findparent(avltree * temp)
{
	avltree *parent=root,*temp1=root;
	while(temp1 != NULL)
	{
		if(temp->data == temp1->data && temp==temp1)
			return parent;
		if(temp->data <= temp1->data)
		{
			parent =temp1;
			temp1=temp1->lchild;
		}
		else
		{
			parent = temp1;
			temp1 = temp1->rchild;
		}
	}
}


void avltree::adjust()
{
	check(root);
	avltree * temp=node,*parent,*grandparent;
	if(temp==NULL)
		return;
	parent=findparent(temp);
	grandparent=findparent(parent);
	if(temp->rchild != NULL)
	{
		if(temp ->index == 2 && temp->rchild->index <= 1)
		{
			temp=temp->rchild;
			lrotate(temp);
		}
		if(temp->index == 2 && temp->rchild->index == -1)
		{
			temp=temp->rchild;
			rrotate(temp->lchild);
			lrotate(node->rchild);
		}

	}
	if(temp->lchild != NULL)
	{
		if(temp ->index == -2 && temp->lchild->index >= -1)
		{
			temp = temp->lchild;
			rrotate(temp);
		}
		if(temp->index == -2 && temp->lchild->index == 1)
		{
			temp = temp->lchild;
			lrotate(temp->rchild);
			rrotate(node->lchild);
		}
	}
}
void avltree::lrotate(avltree * temp)
{
	avltree * parent,*grandparent;
	parent = findparent(temp);
	grandparent = findparent(parent);
	if(parent == root)
	{
		parent->rchild=temp->lchild;
		temp->lchild=parent;
		root = temp;
	}
	else
	{
		if(grandparent->lchild == parent)
		{
			grandparent->lchild=temp;
			parent->rchild=temp->lchild;
			temp->lchild=parent;
		}
		else if(grandparent ->rchild == parent)
		{
			grandparent->rchild=temp;
			parent->rchild=temp->lchild;
			temp->lchild=parent;
		}
	}
	root->indexing();
}

void avltree::rrotate(avltree * temp)
{
	avltree * parent,*grandparent; 
	parent = findparent(temp);
	grandparent = findparent(parent);
	if(parent == root)
	{
		parent->lchild=temp->rchild;
		temp->rchild=parent;
		root = temp;
	}
	else
	{
		if(grandparent->lchild == parent)
		{
			grandparent->lchild=temp;
			parent->lchild=temp->rchild;
			temp->rchild=parent;
		}
		else if(grandparent ->rchild == parent)
		{
			grandparent->rchild=temp;
			parent->lchild=temp->rchild;
			temp->rchild=parent;
		}
	}
	root->indexing();
}

avltree * avltree::find_inorder_successor(avltree * ptr)
{
	avltree * temp=ptr->rchild;
	if(temp==NULL)
		return temp;
	while(temp->lchild != NULL )
	{
		temp=temp->lchild;
	}
	return temp;
}


void avltree::indexing()
{
	if(this==NULL)
		 return;

	this->index=height(this->rchild)-height(this->lchild);
	this->rchild->indexing();
	this->lchild->indexing();
}

int avltree::height(avltree * temp)
{
	if(temp == NULL )
		return 0;
	else
		return ( max(height(temp->lchild),height(temp->rchild))+1);
}



void avltree::showtree()
{
	root->indexing();
	cout<<"\nNODE\tINDEX\n";
	display(root);
}


void avltree::display(avltree *temp)
{
	if(temp == NULL)
		return;
	cout<<"   "<<temp->data<<"\t";
	cout<<temp->index<<"\n";
	if(temp->lchild!=NULL)
		display(temp->lchild);
	if(temp->rchild!=NULL)
		display(temp->rchild);
}



int main()
{
	avltree a;
	a.create();
	a.showtree();
	a.deletnode();
	a.showtree();
	return 0;
}
/*output*
ENTER THE DATA: 1

ONE MORE NODE: (Y/N): y

ENTER THE DATA: 2

ONE MORE NODE: (Y/N): y

ENTER THE DATA: 3

ONE MORE NODE: (Y/N): y

ENTER THE DATA: 4

ONE MORE NODE: (Y/N): y

ENTER THE DATA: 5

ONE MORE NODE: (Y/N): y

ENTER THE DATA: 6

ONE MORE NODE: (Y/N): n

NODE    INDEX
   4    0
   2    0
   1    0
   3    0
   5    1
   6    0

ENTER THE DATA TO DELET: 2
   4    0
   3    -1
   1    0
   5    1
   6    0

*/

				
			
			


	
