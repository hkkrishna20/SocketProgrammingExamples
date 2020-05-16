//ASSIGNMENT 6
// PROGRAM TO IMPLEMENT KEYSORTING

#include <iostream.h>
#define RECORD_SIZE 60
#include"iostream.h"
#include"string.h"
#include"fstream.h"

class fixed_text_buffer 
{
	char *buffer;
	int buffersize;
	int *fieldsize;
	int maxfields;
	int maxchars;
	int numfields;
	int nextfield;
	int numfieldvalues;
	int nextcharacter;

public:
	fixed_text_buffer(int maxfields,int maxchars=1000);
	fixed_text_buffer(int numfields,int *fieldsize);
	int numberoffields() const;
	void clear();
	int addfield(int fieldsize);
	int read(istream &);
	int write(ostream &);
	int pack(const char *);
	int unpack(char *);
	void print();
	void random_read(istream& file,int seek_pos);
	int init(int numfields,int maxchars=1000);
	int init(int numfields,int *fieldsize);
};

void fixed_text_buffer::random_read(istream&file,int seek_pos)
{
	file.seekg(seek_pos);
	file.tellg();

	read(file);
}

fixed_text_buffer::fixed_text_buffer(int maxfields,int maxchars)
{
	init(maxfields,maxchars);
}
fixed_text_buffer::fixed_text_buffer(int numfields,int *fieldsize)
{
	init(numfields,fieldsize);
}
int fixed_text_buffer::numberoffields() const
{
	return numfields;
}
void fixed_text_buffer::clear()
{
	nextfield=0;
	nextcharacter=0;
	buffer[0]='\0';
}
int fixed_text_buffer::addfield(int Fieldsize)
{
	if(numfields==maxfields)
		return false;
	if((buffersize+(Fieldsize)) > maxchars)
		return false;
	fieldsize[numfields]=Fieldsize;
	numfields++;
	buffersize+=Fieldsize;
	return true;
}

int fixed_text_buffer::read(istream & stream)
{
	stream.read(buffer,buffersize);
	return stream.good();
}
int fixed_text_buffer::write(ostream & stream)
{
	
	stream.write(buffer,buffersize);
	return stream.good();
}
int fixed_text_buffer::pack(const char *str)
{
	if(nextfield == numfields)
		return false;
	int len=strlen(str);
	int start=nextcharacter;
	int packsize=fieldsize[nextfield];
	strncpy(&buffer[start],str,packsize);
	nextcharacter+=packsize;
	nextfield++;
	for(int i=start+packsize;i<nextcharacter;i++)
		buffer[start]=' ';
	buffer[nextcharacter]='\0';
	if(nextfield == numfields)
	{
		nextfield=nextcharacter=0;
	}
	return true;
}
int fixed_text_buffer::unpack(char *str)
{
	if(nextfield == numfields)
		return false;
	int start=nextcharacter;
	int packsize=fieldsize[nextfield];
	strncpy(str,&buffer[start],packsize);
	str[packsize]='\0';
	nextcharacter +=packsize;
	nextfield++;
	if(nextfield == numfields)
		clear();
	return true;
}

void fixed_text_buffer::print()
{
	cout<<"buffer has maxfield  "<<maxfields
		<<" and actual "<<numfields<<endl
		<<"maxbytes "<<maxchars<<" and buffer size  "
		<<buffersize<<endl;
	for(int i=0;i<numfields;i++)
	{
		cout<<endl<<"\tfield "<<i<<"size "<<fieldsize[i]<<endl;
	}
}

int fixed_text_buffer::init(int Maxfields, int Maxchars)
{
	if(Maxfields <0)
		maxfields =0;
	if(Maxchars < 0)
		maxchars=0;
	maxfields=Maxfields;
	maxchars=Maxchars;
	fieldsize=new int[maxfields];
	buffer=new char[maxchars];
	buffersize=0;
	numfields=0;
	nextfield=0;
	return true;
}
int fixed_text_buffer::init(int numfield,int *fieldsize)
{
	int buffersize =1;
	for(int i=0;i<numfield;i++)
	{
		buffersize+=fieldsize[i];
	}
	init(numfields,buffersize);
	for(int j=0;j<numfields;j++)
		addfield(fieldsize[j]);
	return true;
}


class person
{
public:
	char surname[11];
	char name[11];
	char address[25];
	char city[16];
	char state[12];
	char pincode[7];
	person();
	void clear();
	int unpack(fixed_text_buffer &buffer);
	int pack(fixed_text_buffer &buffer)const;
	int initbuffer(fixed_text_buffer &buffer);
	void getdata();
	char *give_key();
	void print();


};

void person::print()
	{
	cout<<endl<<endl;
	    cout<<"Person: ";
		cout<<"\tsurname : "<<surname<<endl
			  <<"\tname    : "<<name   <<endl
			  <<"\taddress : "<<address<<endl
			  <<"\tcity    : "<<city   <<endl
			  <<"\tstate   : "<<state  <<endl
			  <<"\tpincode : "<<pincode<<endl;
	}

person::person()
{
	clear();
}
void person::clear()
{
	surname[0] = '\0';
	name[0]    = '\0';
	address[0] = '\0';
	city[0]    = '\0';
	state[0]   = '\0';
	pincode[0] = '\0';
}
char * person::give_key()
{
	return name;
}
int person::pack(fixed_text_buffer &buffer)const
{
	int result;
	buffer.clear();

	result = buffer.pack(surname);
	result = result && buffer.pack(name);
	result = result && buffer.pack(address);
	result = result && buffer.pack(city);
	result = result && buffer.pack(state);
	result = result && buffer.pack(pincode);
	
	return result;
}
int person::unpack(fixed_text_buffer &buffer)
{
	int result;

	result = buffer.unpack(surname);
	result = result && buffer.unpack(name);
	result = result && buffer.unpack(address);
	result = result && buffer.unpack(city);
	result = result && buffer.unpack(state);
	result = result && buffer.unpack(pincode);

	return result;
}


int person::initbuffer(fixed_text_buffer &buffer)
{
	int result;

	result=buffer.addfield(10);
	result=result && buffer.addfield(10);
	result=result && buffer.addfield(10);
	result=result && buffer.addfield(10);
	result=result && buffer.addfield(10);
	result=result && buffer.addfield(10);

	return result;
}


void person::getdata()
{
		cout<<"enter the data to make a record"<<endl;

		cout<<"\t1.surname :  ";
		cin>>surname;
		cout<<endl<<"\t2.name :   ";
		cin>>name;
		cout<<endl<<"\t3.address :    ";
		cin>>address;
		cout<<endl<<"\t4.city :   ";
		cin>>city;
		cout<<endl<<"\t5.state :   ";
		cin>>state;
		cout<<endl<<"\t6.pincode :    ";
		cin>>pincode;
		cout<<endl<<endl;
}



class key_sort
{
	int max_keys;
	int num_keys;
	char **keys;
	int *rrn;	//relative record number
public:
	key_sort(int maxkeys=100);
	~key_sort();
	int read_keys(istream & f);
	int sort();
	void create_sorted_file(istream & unsorted_file, ostream & empty_file);
	void print();
};
key_sort::key_sort(int maxkeys)
{
	num_keys=0;
	max_keys=maxkeys;
	keys=new char *[max_keys];
	rrn =new int [max_keys];
}
key_sort::~key_sort()
{
	delete[] keys;
	delete[] rrn;

}
int key_sort::sort()
{
	int i,j;
	char *temp;
	int tempi;
	for(i=0;i<num_keys;i++)
	{//apply selection sort on keys
		for(j=i+1; j<num_keys; j++)
		{
			if(strcmp(keys[i],keys[j])>0)
			{
				//swap the keys
				temp    = keys[i];
				keys[i] = keys[j];
				keys[j] = temp;

				//swap the relative record number
				tempi	= rrn[i];
				rrn[i]  = rrn[j];
				rrn[j]  = tempi;
			}
		}
	}
	return 1;
}
void key_sort::print()
{
	for(int i=0; i<num_keys; i++)
		cout<<endl<<keys[i];
}

int key_sort::read_keys(istream& unsorted_file)
{
	fixed_text_buffer b(6);
	person p;
	p.initbuffer(b);
	b.clear();
	int i=0;
	while(i<2)
	{
		b.read(unsorted_file);
		if(unsorted_file.fail())
			break;
		p.unpack(b);
		p.print();
		keys[num_keys] = strdup(p.give_key());
		rrn[num_keys]=num_keys;
		num_keys++;
		i++;
	}
	return 1;
}
void key_sort::create_sorted_file(istream& unsorted_file, ostream& sorted_file)
{
	fixed_text_buffer b(6);
	person p;
	p.initbuffer(b);
	for(int i=0; i<num_keys; i++)
	{
		b.random_read(unsorted_file, rrn[i]*RECORD_SIZE);
		b.write(sorted_file);

	}
}

#ifdef INSERT
void main()
{
	int num_of_record;
	fstream f;
	f.open("karthik",ios::out);
	person p;
	fixed_text_buffer b(6);
	p.initbuffer(b);
	cout<<"enter the number of records";
	cin>>num_of_record;

	for(int i=0;i<num_of_record;i++)
	{
		p.getdata();
		p.pack(b);
		b.write(f);
	}
	f.close();
}
#endif

#ifdef KEY_SORT
void main()
{

	fstream f,sorted_file;
	f.open("karthik",ios::in);
	sorted_file.open("new_file",ios::out);
	key_sort k;
	k.read_keys(f);
	k.print();
	k.sort();
	k.create_sorted_file(f,sorted_file);
	k.print();
	f.close();
	sorted_file.close();
}
#endif

#ifdef BUFFER
void main()
{

	fstream f;
	f.open("karthik",ios::out);
	fixed_text_buffer b(6);
	person p,q;
	p.initbuffer(b);
	p.getdata();
	p.pack(b);
	b.write(f);
	f.close();

	
	f.open("karthik",ios::in);
	b.read(f);
	//p.clear();
	q.unpack(b);
	q.print();
	f.close();
}	
#endif


void main()
{
	// creation a unsorted file
	fstream f,g;

	int num_of_record;

	f.open("unsorted_file",ios::out);
	person p;
	fixed_text_buffer b(6);
	p.initbuffer(b);
	
	cout<<"\nenter the number of records";
	cin>>num_of_record;

	for(int i=0;i<num_of_record;i++)
	{
		p.getdata();
		p.pack(b);
		b.write(f);
	}
	f.close();

	//creation 	of sorted file 

	f.open("unsorted_file",ios::in);

	g.open("sorted_file",ios::out);
	key_sort k;
	k.read_keys(f);
	k.print();
	k.sort();
	k.create_sorted_file(f,g);
	k.print();
	f.close();
	g.close();


}
/*output
Enter how many records U r going to Enter :2

Enter the following:
Name :sarwan
college :svu
Branch :cse
Enter the following:
Name :paul
college :sss
Branch :eee
Enter the record no to be searched:1
sarwan
svu
cse
*/