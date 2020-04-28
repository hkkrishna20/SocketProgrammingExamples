/*      ASSIGNMENT-8 
       SECONDARY INDEX*/
#include<iostream.h>
#include<fstream.h>
#include<stdio.h>
class record
{
public:
	char name[10];
	int rollno;
	int roomno;
	void get();
	void put();
};
void record::get()
{	
    cout<<"Enter the name:";
     cin>>name;
	cout<<"Enter the rollno:";
	cin>>rollno;
	cout<<"Enter the roomno:";
	cin>>roomno;
}
void record::put()
{
	cout<<"\n name \n   rollno \n  roomno \n";
	cout<<"\n"<<name<<"\n"<<rollno<<"\n"<<roomno<<"\n";
	
}
class prim
{
public:
	int sc,ref,next;
};
class seco
{
public:
	int se,ref;
};
class file
{
	fstream data,pri,sec,list;
	record r;
	prim p;
	seco q;
	int numrec,rollno,i;
public:
	void load();
	void menu();
	void add();
	void updata();
	void read();
	void print(int);
	void update_pri();
	void update_sec();
};
void file::load()
{
	numrec=0;
	data.open("data.txt",ios::in);
	while(1)
	{
		data.read((char *)&r,sizeof(r));
		if(data.fail())
		break;
		numrec++;
	}
	data.close();
}
void file::print(int x)
{
	pri.open("pri.txt",ios::in);
	pri.seekg(x*sizeof(p),ios::beg);
	pri.read((char *)&p,sizeof(p));
	pri.close();
	data.open("data.txt",ios::in);
	data.seekg(p.ref*sizeof(r),ios::beg);
	data.read((char *)&r,sizeof(r));
	data.close();
	r.put();
	if(p.next!=-1)
	{
	
		print(p.next);
	
	}

}
void file::add()
{
r.get();
data.open("data.txt",ios::app);
data.write((char *)&r,sizeof(r));
data.close();
update_pri();
update_sec();
numrec++;
}
void file::update_pri()

{
	pri.open("data.txt",ios::app);
	pri.seekg(0,ios::end);
	i=pri.tellg();
	i=(i/sizeof(p));
	p.sc=rollno;
	p.ref=numrec;
	p.next=-1;
	pri.write((char *)&p,sizeof(p));
	pri.close();
}
void file::update_sec()
{
	sec.open("sec.txt",ios::in);
	while(1)
	{
		sec.read((char *)&q,sizeof(q));
		if(sec.fail())
		{
           
			sec.close();
			q.se=r.roomno;
			q.ref=i;
			sec.open("sec.txt",ios::app);
			sec.write((char *)&q,sizeof(q));
			sec.close();
			break;
		
		}
		if(r.roomno==q.se)
		{
			sec.close();
			int sub=q.ref;
			long int temp;
			while(sub!=-1)
			{
				pri.open("pri.txt",ios::in);
				pri.seekg(sub*sizeof(p),ios::beg);
				temp=pri.tellg();
				temp=temp/sizeof(p);
				pri.close();
				sub=p.next;
				break;
			}
			pri.open("pri.txt",ios::ate|ios::out);
			pri.seekp(temp,ios::beg);
			p.next=i;
			pri.write((char *)&p,sizeof(p));
			pri.close();
			break;
		}
	}

	
}
void file::read()
{
	cout<<"\n Enter the secondary key:";
	int secondary;
	cin>>secondary;
	sec.open("sec.txt",ios::in);
	while(1)
	{
		sec.read((char *)&q,sizeof(q));
		if(sec.fail())
		{
			cout<<"\n No such record:";
			break;
		}
		if(q.se==secondary)
		{
			print(q.ref);
			break;
		}
	}

	sec.close();
}
void file::menu()
{
	cout<<"\n 1.add a record:";
	cout<<"\n 2.read by secondary record:";
	cout<<"\n 3.exit:";
	int opt;
	cout<<"\n Enter Ur choice:";
	cin>>opt;
	
	switch(opt)
	{
	case 1:
		add();
		break;
	case 2:
		read();
		break;
	case 3:
		cout<<"wrong choice:";
		break;
	default:
		break;
	}
}
int main()
{
	file temp;
	char ch='y';
	temp.load();
	while(ch=='y')
	{
		temp.menu();
		cout<<"\n Do you want to continue:";
		cin>>ch;
	}
	return 0;
}










































































































