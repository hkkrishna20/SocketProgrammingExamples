/* Program to implement  Extendible Hashing
			ASSIGNMENT-15*/
#include<iostream.h>
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#include<ctype.h>

class ext;
ext *root=NULL;
int flag=0;

class ext
{
 public:
  ext *left;
  ext *right;
  int array[5];
  char nam[5][20];
  int asize;
  ext()
  {
   asize=0;
  }
  int make(char *key);
  int hash(char *);
  void insert();
  void search(ext *ptr,char *p);
  void display(ext *,int);
  void display1();
//void del();
  void create();
};

int ext::hash(char *p)
{
 int len=strlen(p);
 for(int i=0;i<len;i++)
  p[i]=toupper(p[i]);
 if(len%2==1)
  len++;
 int sum=0;
 for(i=0;i<len;i+=2)
  sum=(sum+100*p[i]*p[i+1])%19937;
 return sum;
}

int ext::make(char *key)
{
 int ret=0;
 int mask=1;
 int hasv=hash(key);
 for(int j=0;j<10;j++)
 {
  ret=ret<<1;
  int lowbit=hasv & mask;
  ret=ret |lowbit;
  hasv=hasv>>1;
 }
 return ret;
}

void ext::create()
{
 // clrscr();
  cout<<"\n \n";
  cout<<"              1.insertion\n";
  cout<<"              2.deletion\n";
  cout<<"              3.display\n";
  cout<<"              4.exit\n";
  int opt;
  cout<<"enter ur option:";
  cin>>opt;
  switch(opt)
  {
   case 1:
	  insert();
	  break;
   case 2:
	  // del();
	   break;
   case 3:
	  display1();
	  break;
   case 4:
	  exit(0);
   default:
	   cout<<" \n U ENTERTED A WRONG OPTION:\n";
	   getch();
	   create();
  }
}

void ext::display1()
{
 display(root,0);
 getch();
 create();
}

void ext::display(ext *t,int level)
{
 if(t)
 {
  display(t->right,level+1);
  cout<<"\n";
  for(int i=0;i<level;i++)
   cout<<"   ";
  cout<<" * ";
  for(i=0;i<t->asize;i++)
  cout<<t->nam[i]<<"  ";
  display(t->left,level+1);
 }
}


void ext::search(ext *ptr,char *p)
{
 int key=make(p);
 int count=0;
 int l=1;
 int a;
 ext *parent;
 if(!root)
 {
  cout<<"KEY NOT FOUND:";
  getch();
  return;
 }
 else
 {
  ptr=root;
  parent=root;
  while(parent)
  {
   l=1<<count;
   a=key & l;
   ptr=parent;
   if(a==0)
    parent=parent->right;
   else
    parent=parent->left;
   count++;
  }
 }
 for(int i=0;i<ptr->asize;i++)
  if(!strcmp(ptr->nam[i],p))
  {
   cout<<endl<<" KEY FOUND";
   getch();
   return;
  }
 cout<<"\n KEY NOT AVAILABLE:";
 getch();
}

void ext::insert()
{
 ext *p;
// clrscr();
 char name[32];
 cout<<"\n PLZ  ENTER UR  NAME:\n";
 cin>>name;
 int key=make(name);
 int count=0;
 int l=1;
 int a;
 ext *parent;
 if(!root)
 {
  p=new ext;
  root=p;
  p->left=NULL;
  p->right=NULL;
  a=key & 1;
 }
 else
 {
  p=root;
  parent=root;
  while(parent)
  {
   l=1<<count;
   a=key & l;
   p=parent;
   if(a==0)
    parent=parent->right;
   else
    parent=parent->left;
   count++;
  }
 }
// if(a==0||a!=0)
// {
  if(p->asize<5)
  {
   p->array[p->asize]=12;
   cout<<"size..."<<(p->asize+1)<<"\n";
   getch();
   strcpy(p->nam[p->asize++],name);
  // return;
   create();
  }
  else
  {
   cout<<"\n BUCKET OVERFLOW  SPLITING   THE BUCKET\n";
   getch();
   p->asize=0;
   p->right=new ext;
   p->right->left=NULL;
   p->right->right=NULL;
   p->left=new ext;
   p->left->left=NULL;
   p->left->right=NULL;
   int h=0;
   int  c=count;
   for(int i=0;i<5;i++)
   {
    int key1=make(p->nam[i]);
    h=1<<c;
    int g=key1 & h;
    if(g==0)
    {
     cout<<"RIGHT BUFFER"<<"\n";
     cout<<p->nam[i]<<"\n";
     p->right->array[p->right->asize]=12;
     strcpy(p->right->nam[p->right->asize++],p->nam[i]);
    }
    else
    {
     cout<<"LEFT BUFFER"<<"\n";
     cout<<p->nam[i]<<"\n";
     p->left->array[p->left->asize]=12;
     strcpy(p->left->nam[p->left->asize++],p->nam[i]);
    }
    getch();
   }
   int key1=make(name);
   h=1<<c;
   int g=key1& h;
   if(g==0)
   {
    cout<<" NEW KEY INSERTED IN TO RIGHT BUFFER"<<"\n";
    p->right->array[p->right->asize]=12;
    strcpy(p->right->nam[p->right->asize++],name);
    getch();
   }
   else
   {
    cout<<" NEW KEY INSERTED IN TO LEFT BUFFER"<<"\n";
    p->left->array[p->left->asize]=12;
    strcpy(p->left->nam[p->left->asize++],name);
    getch();
   }
  }
// }
 create();
}

int main()
{
  //clrscr();
  ext sh;
  sh.create();
  char n[20];
  getch();
 getch();
  return 0;
}
