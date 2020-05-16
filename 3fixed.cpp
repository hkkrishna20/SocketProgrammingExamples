#include<iostream.h>
#include<fstream.h>
#include<string.h>

class fixedbuffer
{
protected:
	char *buffer;
	int *field;
	int maxfields;
	int maxchars;
	int numfields;
	int numfieldvalues;
	int nextbyte;
	int buffersize;
public:
	fixedbuffer(int cmax=1000,int fmax=10)
	{
		maxchars=cmax;
		maxfields=fmax;
		buffer=new char[maxchars];
		field = new int[maxfields];
		buffersize = 50;
		numfields = 5;
		for(int i=0; i<numfields; i++)
			field[i]=10;
                                                 
	}
	void clear()
	{
		nextbyte=0;
	}
	int pack(const char *,int );
	int unpack(char *,int );
	void read(istream &);
	void write(ostream &);
	void display();
};

class employee:public fixedbuffer
{
	char name[10];
	char surname[10];
	char salary[10];
	char city[10];
	char state[10];
public:
	employee()
	{
		name[0]=0;
		surname[0]=0;
		salary[0]=0;
		city[0]=0;
		state[0]=0;
	}
	void readfile();
	int pack(fixedbuffer &);
	int unpack(fixedbuffer &);
	
};

void employee::readfile()
{
	cout<<"\nENTER EMPLOYEE 'S DETAILS:\n";
	cout<<"NAME   :";
	cin>>name;
	cout<<"\nSURNAME:";
	cin>>surname;
	cout<<"\nSALARY :";
	cin>>salary;
	cout<<"\nCITY   :";
	cin>>city;
	cout<<"\nSTATE  :";
	cin>>state;
	cout<<endl;
}

int employee::pack(fixedbuffer & f)
{
	clear();
	int result;
	result = f.pack(surname,0);
	result = result && f.pack(name,1);
	result = result && f.pack(salary,2);
	result = result && f.pack(city,3);
	result = result && f.pack(state,4);
	return result;
}

int employee::unpack(fixedbuffer & f)
{
	int result;
	result = f.unpack(surname,0);
	result = result && f.unpack(name,1);
	result = result && f.unpack(salary,2);
	result = result && f.unpack(city,3);
	result = result && f.unpack(state,4);
	return result;
}

void fixedbuffer::read(istream & stream)
{
	stream.read(buffer,buffersize);
}

void fixedbuffer::write(ostream & stream)
{
	stream.write(buffer,buffersize);
}

void fixedbuffer::display()
{
	cout<<buffer;
	cout<<"\nBUFFER SIZE:\t"<<buffersize<<"\n";

	cout<<endl;
}
int fixedbuffer::pack(const char * str,int num)
{
	int length=strlen(str);
	int start=nextbyte;

	if(nextbyte > maxchars)return false;
	memcpy(&buffer[start],str,length);
	for(int i=length+nextbyte; i < field[num]+nextbyte; i++)
	{
		buffer[i]=' ';
	}
	nextbyte += field[num];

	buffer[buffersize]=0;
	return true;
}

int fixedbuffer::unpack(char * str, int num)
{
	int length;
	int start=nextbyte;
	
	length=field[num];
	nextbyte += length+1;
	strncpy(str, &buffer[start],length);
	str[length]=0;
	return true;
}



int main()
{
	employee e;
	fixedbuffer buffer(100);
	buffer.clear();
	e.readfile();
	int flag;
	flag=e.pack(buffer);

	if(flag==1)
		cout<<"\n PACKING SUCCESS";
	else
		cout<<"\nPACKING FAILED";

	ofstream file("employee.txt");
	buffer.write(file);
	file.close();
	cout<<"\nBUFFER AFTER PACKING:"<<endl;
	buffer.display();

	ifstream ifile("employee.txt");
//delimbuffer inbuffer;
	buffer.read(ifile);
	buffer.clear();
	flag=e.unpack(buffer);

	if(flag==1)
		cout<<"\n UNPACKING SUCCESS";
	else
		cout<<"\nUNPACKING FAILED";


	cout<<"\nBUFFER AFTER UNPACKING:"<<endl;
	buffer.display();

	ifile.close();

	return 1;
}

/*		OUTPUT

ENTER EMPLOYEE 'S DETAILS:
NAME   :mahiya

SURNAME:vasan

SALARY :25,000

CITY   :TPT

STATE  :AP


 PACKING SUCCESS
BUFFER AFTER PACKING:
vasan     mahiya    25,000    TPT       AP
BUFFER SIZE:    50


 UNPACKING SUCCESS
BUFFER AFTER UNPACKING:
vasan     mahiya   25,000    TPT       AP
BUFFER SIZE:    50*/








