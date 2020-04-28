#include<iostream.h>
#include<fstream.h>
#include<string.h>
class lengthbuffer
{
protected:
	char *buffer;
	int max;
	int nextbyte;
	int buffersize;
public:
	lengthbuffer(int cmax=1000)
	{
		max=cmax;
		buffer=new char[max];
		buffersize =0;
	}

	void clear()
	{
		nextbyte=0;
	}

	int pack(const char *);
	int unpack(char *);
	void read(istream &);
	void write(ostream &);
	void display();
};

class account:public lengthbuffer
{
	char name[10];
	char city[10];
	char bank[10];
	char acno[10];
	char balance[10];
public:
	int pack(lengthbuffer &);
	int unpack(lengthbuffer &);
	void readfile();
};

void account::readfile()
{
	cout<<"\nENTER CUSTOMER 'S DETAILS:\n";
	cout<<"NAME   :";
	cin>>name;
	cout<<"\nCITY:";
	cin>>city;
	cout<<"\nBANK NAME :";
	cin>>bank;
	cout<<"\nACCOUNT NUMBER   :";
	cin>>acno;
	cout<<"\nBALANCE  :";
	cin>>balance;
	cout<<endl;
}

int account::pack(lengthbuffer & f)
{
	clear();
	int result;
	result = f.pack(name);
	result = result && f.pack(city);
	result = result && f.pack(bank);
	result = result && f.pack(acno);
	result = result && f.pack(balance);
	return result;
}

int account::unpack(lengthbuffer & f)
{
	int result;
	result = f.unpack(name);
	result = result && f.unpack(city);
	result = result && f.unpack(bank);
	result = result && f.unpack(acno);
	result = result && f.unpack(balance);
	return result;
}

void lengthbuffer::read(istream & stream)
{
	stream.read(buffer,buffersize);
}

void lengthbuffer::write(ostream & stream)
{
	stream.write(buffer,buffersize);
}

void lengthbuffer::display()
{
		cout<<buffer;
	cout<<"\nBUFFER SIZE:\t"<<buffersize<<"\n";

	cout<<endl;
}

int lengthbuffer::pack(const char * str)
{
	int length=strlen(str);
	int start=nextbyte;

	nextbyte += (length+sizeof(length));
	if(nextbyte > max)
		return false;

	memcpy(&buffer[start] , &length , sizeof(length));
	strncpy(&buffer[start+sizeof(length)], str, length);

	buffersize = nextbyte;
	return true;
}

int lengthbuffer::unpack(char * str)
{
	int length;
	if(nextbyte >= buffersize)
		return false;
	int start=nextbyte;
	memcpy(&length , &buffer[start], sizeof(length));
	nextbyte += length+sizeof(length);

	if(nextbyte > buffersize)
		return false;

	strncpy(str, &buffer[start + sizeof(length)], length);

	str[length] =0;

	return true;
}
int main()
{
	account a;
	lengthbuffer buffer(100);
	buffer.clear();
	a.readfile();
	int flag;
	flag=a.pack(buffer);

	if(flag==1)
		cout<<"\n PACKING SUCCESS";
	else
		cout<<"\nPACKING FAILED";

	ofstream file("account.txt");
	buffer.write(file);
	file.close();
	cout<<"\nBUFFER AFTER PACKING:"<<endl;
	buffer.display();

	ifstream ifile("account.txt");
	buffer.read(ifile);
	buffer.clear();
	flag=a.unpack(buffer);

	if(flag==1)
		cout<<"\n UNPACKING SUCCESS";
	else
		cout<<"\nUNPACKING FAILED";


	cout<<"\nBUFFER AFTER UNPACKING:"<<endl;
	buffer.display();

	ifile.close();

	return 1;
}
/*				OUTPUT

ENTER CUSTOMER 'S DETAILS:
NAME   :sarwan

CITY:TPT

BANK NAME :SBI

ACCOUNT NUMBER   :603431

BALANCE  :56


 PACKING SUCCESS
BUFFER AFTER PACKING:
?
BUFFER SIZE:    40


 UNPACKING SUCCESS
BUFFER AFTER UNPACKING:
?
BUFFER SIZE:    40*/




