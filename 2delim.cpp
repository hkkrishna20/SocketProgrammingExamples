			
#include<iostream.h>
#include<fstream.h>
#include<string.h>

class delimbuffer
{
protected:
	char *buffer;//character to hold fields
	char delim;
	int buffersize;
	int nextbyte;
	int max;
public:
	delimbuffer(int Max=1000)
	{
		delim='|';
		buffersize=0;
		nextbyte=0;
		max=Max;
		buffer= new char[max];
	}
	void clear()
	{
		nextbyte=0;
	}

	int pack(char *str);
	int unpack(char *str);
	void read(istream &);
	void write(ostream &);
	void display();
};

class student:public delimbuffer
{

	char name[10];
	char rollno[10];
	char branch[10];
	char college[10];
	char city[10];
public:
	student()
	{
		name[0]=0;
		rollno[0]=0;
		branch[0]=0;
		college[0]=0;
		city[0]=0;
	}
	void readfile();
	int pack(delimbuffer &);
	int unpack(delimbuffer &);
};

void student::readfile()
{
	cout<<"\nENTER STUDENT'S DETAILS:\n"<<"NAME  :";
	cin>>name;
	cout<<"\nROLL NO:";
	cin>>rollno;
	cout<<"\nBRANCH  :";
	cin>>branch;
	cout<<"\nCOLLEGE :";
	cin>>college;
	cout<<"\nCITY    :";
	cin>>city;
	cout<<"\n";
}

int student::pack(delimbuffer & d)
{
	int result;
	result = d.pack(name);
	result = result && d.pack(rollno);
	result = result && d.pack(branch);
	result = result && d.pack(college);
	result = result && d.pack(city);
	return result;
}

int student::unpack(delimbuffer & d)
{
	int result;
	result = d.unpack(name);
	result = result && d.unpack(rollno);
	result = result && d.unpack(branch);
	result = result && d.unpack(college);
	result = result && d.unpack(city);
	return result;
}

	


int delimbuffer::pack(char *str)
{
	int length;
	length=strlen(str);
	int start=nextbyte;
	nextbyte += length+1;
	if(nextbyte > max)return false;
	memcpy(&buffer[start],str,length);
	buffer[start+length]=delim;

	buffersize=nextbyte;

	buffer[buffersize]=0;
	return true;
}



int delimbuffer::unpack(char *str)
{
	int length=-1;
	int start=nextbyte;
	for(int i=start; i<buffersize ;i++)
		if(buffer[i]==delim)
		{
			length=i-start;
			break;
		}
	if(length==-1)
		return false;
	nextbyte += length+1;
	strncpy(str, &buffer[start], length);
	str[length]=0;
	return true;
}


void delimbuffer::display()
{
		cout<<buffer;
	cout<<"\nBUFFER SIZE:\t"<<buffersize<<"\n";

	cout<<endl;
}

void delimbuffer::read(istream & stream)
{
	stream.read(buffer,buffersize);
}

void delimbuffer::write(ostream & stream)
{
	stream.write(buffer, buffersize);
}



int main()
{
	student s;
	delimbuffer buffer(100);
	buffer.clear();
	s.readfile();
	int flag;
	flag=s.pack(buffer);

	if(flag==1)
		cout<<"\n PACKING SUCCESS";
	else
		cout<<"\nPACKING FAILED";

	ofstream file("student.txt");
	buffer.write(file);
	file.close();
	cout<<"\nBUFFER AFTER PACKING:"<<endl;
	buffer.display();

	ifstream ifile("student.txt");
	buffer.read(ifile);
	buffer.clear();
	flag=s.unpack(buffer);

	if(flag==1)
		cout<<"\n UNPACKING SUCCESS";
	else
		cout<<"\nUNPACKING FAILED";


	cout<<"\nBUFFER AFTER UNPACKING:"<<endl;
	buffer.display();

	ifile.close();

	return 1;
}




/*   OUTPUT

ENTER STUDENT'S DETAILS:
NAME  :kkk

ROLL NO:555

BRANCH  :CSE

COLLEGE :SVUCE

CITY    :TPT


 PACKING SUCCESS
BUFFER AFTER PACKING:
kkk|555|CSE|SVUCE|TPT|
BUFFER SIZE:    28


 UNPACKING SUCCESS
BUFFER AFTER UNPACKING:
kkk|555CSE|SVUCE|TPT|
BUFFER SIZE:    28*/








