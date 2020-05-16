//ASSIGNMENT-7             
//PROGRAM TO IMPLEMENT SIMPLE INDEX FOR A DATA FILE
#include<iostream.h>
#include<stdlib.h>
//#include"record.h"
#include<string.h>
#include<fstream.h>

fstream fd,fi,fn;

class record
{
public:
	char name[10];
	char rollno[10];
	char college[16];
    record()
    {
	 name[0]=0;
	 rollno[0]=0;
	 college[0]=0;
     }
	  
};
record r;


class pkey
{
public:
	char key[20];
	int no;
      record *addr;
	  // int rf;
pkey()
{
 key[0]=0;
// rf=0;
}
}p;


class index
{
  public:
	  void create();
	 void insert(int n);
	 void sort();
	 /*void remove(char *key);*/
	 void search(char *key,int);
	 void display(record r,pkey p);
};

void index::insert(int n)
{
	fd.open("data.txt",ios::in|ios::out);
	fi.open("index.txt",ios::in|ios::out);

	cout<<"\n\n\nENTER THE NAME::";
	cin>>r.name;
	cout<<"\nENTER THE ROLL NUMBER::";
	cin>>r.rollno;
	cout<<"\nENTER THE COLLEGE::";
	cin>>r.college;
	strcpy(p.key,r.rollno);
	p.no=n;
	//strcat(p.key,r.rollno);

	cout<<"\nPRIMARY KEY IS::"<<p.key<<"  "<<p.no<<endl;
	fi.seekp(n*sizeof(p),ios::beg);
	fd.seekp(n*sizeof(r),ios::beg);
	fi.write((char *)&p,sizeof(p));
	fd.write((char*)&r,sizeof(r));
   fd.close();
   fi.close();
}

void index::sort()
{
   int n,i=0;
   fn.open("recn.txt",ios::in);
   fn>>n;
   fn.close();

   pkey *k,temp;
   k=new pkey[100];

   fi.open("index.txt",ios::in|ios::out);
   while(1)
   {
     fi.read((char *)&p,sizeof(p));
     if(fi.fail())break;
     k[i++]=p;
   }
   fi.close();

   for(int i=0;i<n;i++)
   {
       for(int j=0;j<n-1;j++)
       {
	  if(strcmp(k[j].key,k[j+1].key)>0)
	  {
	     temp=k[j];
	     k[j]=k[j+1];
	     k[j+1]=temp;
	  }
       }
   }
   fi.open("index.txt",ios::in|ios::out);
   for(int i=0;i<n;i++)
       fi.write((char *)&k[i],sizeof(k[i]));
   fi.close();

}

void index::search(char *key,int num)
{
 
  long int df;
  record *raddr;
  raddr=NULL;
  char *buff;
  buff=new char[sizeof(r)];

  fi.open("index.txt",ios::in|ios::out);

  while(1)
  {

     fi.read((char *)&p,sizeof(p));
     if(fi.fail())
		 break;
     if(strcmp(key,p.key)==0)
     {
		raddr=p.addr;
		break;
     }

  }
  fi.close();
  df=(num)*sizeof(r);

  if(raddr==NULL)
     cout<<"\n\n THERE IS NO RECORD WITH THIS KEY"<<endl;

  else
  {
     cout<<"\n\n SEARCH RESULT IS::";
     fd.open("data.txt",ios::in|ios::out);
	 //r=raddr;
     fd.seekg(df,ios::beg);
     fd.read((char *)&r,sizeof(r));//cout<<buff;*/
     cout<<r.name<<"\t"<<r.rollno<<"\t"<<r.college<<endl;
     fd.close();
  }

}


void index::display(record r,pkey p)
{
  cout<<"\n\n\t\t /*  CONTENTS OF INDEX FILE */"<<endl;
  fi.open("index.txt",ios::in|ios::out);
  while(1)
  {
    fi.read((char *)&p,sizeof(p));
    if(fi.fail())break;
    cout<<"\n\n";
    cout<<"\t"<<p.key<<"\t"<<p.no<<endl;
  }
  fi.close();
//getch();

  cout<<"\n\n\n\t\t /*  CONTENTS OF DATA FILE */"<<endl;

  fd.open("data.txt",ios::in|ios::out);
  while(1)
  {
     fd.read((char *)&r,sizeof(r));
     if(fd.fail())break;
     cout<<"\n\n";
     cout<<"\t"<<r.name<<"\t"<<r.rollno<<"\t"<<r.college<<endl;
  }
     fd.close();
}


int main()
{
 index k();
 char *name;
 name=new char();
 int n=0;
 int x,nam;

// clrscr();
 while(1)
 {
   cout<<"\n\n\nOPTIONS FOR INDEX FILE::\n\n1.INSERTION\n\n2.SEARCHING\n\n3.REMOVING\n\n4.DISPLAY\n\n5.EXIT"<<endl;
   cout<<"\n\nENTER UR CHOICE::";
   cin>>x;

   if(x==1)
   {
      fn.open("recn.txt",ios::in);
      fn>>n;
      fn.close();

      k.insert(n);
      n++;
      fn.open("recn.txt",ios::out);
      fn<<n;
      fn.close();
   }

   else if(x==2)
   {
      cout<<"\n\nENTER THE KEY(ROLL NO:) FOR SEARCHING::";
	  cin>>name;
	  cout<<"\nENTER KEY NUMBER::";
	  cin>>nam;
      k.search(name,nam);
   }

   else if(x==3)
   {
      /*i.remove(name);*/
   }

   else if(x==4)
   {
      sort();
      k.display(r,p);
   }

   else if(x==5)
      exit(1);

   else
      cout<<"\n\n CHECK UR OPTION "<<endl;
 }
return 0;
}


