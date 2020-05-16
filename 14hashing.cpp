/*  Program to build a Hashing ALgorithm
			ASSIGNMENT-14*/

#include<iostream.h>
#include<fstream.h>
#include<string.h>
class record
{
public:
	char name[20];
	char rno[20];
	void get();
	void put();
};
void record::get()
{
	cout<<"\n Enter the name:";
	cin>>name;
	cout<<"Enter the rollnumber:";
	cin>>rno;
}
void record::put()
{
	cout<<endl<<name<<"\t"<<rno<<"\t";
}
class hashing
{
	fstream main;
	record r;
public:

	void write();
	void read();
	int hash(char *);
	void menu();
};
void hashing::write()
{
	r.get();
	char buff[40];
	strcpy(buff,r.name);
	strcat(buff,r.rno);
	strcat(buff,"'\0'");
	int addr;
	addr=hash(r.rno);
	cout<<buff<<"\t"<<addr;
	main.open("main.txt",ios::in|ios::out);
	main.seekp(addr*sizeof(r),ios::beg);
	main.write(buff,sizeof(buff));
	main.close();
}
void hashing::read()
{
	char *buff,roll[20];
	buff = new char[40];
	cout<<"\n Enter the roll no";
	cin>>roll;
	int addr=hash(roll);  
	//main.open("main.txt",ios::in);
	main.open("main.txt",ios::in|ios::out);
	main.seekg(addr*sizeof(r),ios::beg);
	main.read(buff,sizeof(r));//read((char *)&buff,sizeof(r));

	cout<<buff;
	main.close();
	
}
int hashing::hash(char *s)
{
	int sum=0;
	for(int i=1; i<=strlen(s) ; i++)
		sum=(sum+(s[i])*s[i-1]);
	sum=sum%197;
	return sum;
}
void hashing::menu()
{
	
	int ch;
	cout<<"\n 1.write a record:\n 2.read a record:\n 3. exit:\n";
	cout<<"\n Enter the choice:";
	cin>>ch;
	switch(ch)
	{
	case 1:
		//main.open("main.txt");
		write();
		break;
	case  2:
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
	char ch='y';
	hashing file;
	while(ch=='y')
	{
		file.menu();
		cout<<"\n Do U want to continue (y/n):";
		cin>>ch;
	}
	return 0;
}
/*output

.write a record:
 2.read a record:
 3. exit:

 Enter the choice:1

 Enter the name:sar
Enter the rollnumber:1111
sar1111'        111
 Do U want to continue (y/n):y

 1.write a record:
 2.read a record:
 3. exit:

 Enter the choice:1

 Enter the name:sam
Enter the rollnumber:123
sam123' 75
 Do U want to continue (y/n):n
*/


