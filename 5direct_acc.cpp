/* Program to implement direct access
   to fixed length records
   based on relative record number (RRN).
         ASSIGNMENT-5*/  
 
#include<iostream.h>
#include<fstream.h>
using namespace std;
class student
{
private:
	char name[10];
	char college[10];
        char branch[10];
public:
	void read_from_con();
	void direct_access();
	void seek();
};

void student::read_from_con()
{
		cout<<"Enter the following:\n";
		
		cout<<"Name :";
		cin>>name;
		
		cout<<"college :";
		cin>>college;
		
              cout<<"Branch :";
		cin>>branch;
}

void student::direct_access()
{
	ofstream obj("List.txt");
	
	cout<<"Enter how many records U r going to Enter :";
	int n;
	cin>>n;
	cout<<endl;
	
	for (int i=1;i<=n;i++)
	{
		read_from_con();
              
		//write to file
		obj.width(10);
		obj<<name;
		
		obj.width(10);
		obj<<college;
		
		obj.width(10);
		obj<<branch<<endl;
	}
	obj.close();
	
	seek();
}
void student::seek()
{
	ifstream obj("List.txt");
	
	int n;
	cout<<"Enter the record no to be searched:";
	cin>>n;
	
	obj.seekg((n-1)*30+1);
	
	obj>>name>>college>>branch;

	cout<<name<<endl;
	cout<<college<<endl;	
	cout<<branch<<endl;

	obj.close();
}
int main()
{
	student obj;
	obj.direct_access();
	return 0;
}
/*outpu/
Enter how many records U r going to Enter :2\

Enter the following:
Name :college :sarwan
Branch :cse
Enter the following:
Name :sarwan
college :svuce
Branch :cse
Enter the record no to be searched:2
sarwan
svuce
cse*/
