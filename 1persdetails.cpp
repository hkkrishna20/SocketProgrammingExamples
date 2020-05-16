			
			//Assignment-1
#include<iostream.h>
#include<fstream.h>
#include<string.h>
//class to specify details of person 

 class Person
{
public : 
	char fname[20];
	char lname[20];
	char zipcode[10];
	char state[10];
	Person();
};
Person:: Person() 
{
fname[0]=0;
lname[0]=0;
state[0]=0;
zipcode[0]=0;
}

//read fields of person into file


//#include "Person.cpp"
istream & operator >>(istream & stream,Person &p)
{
cout<<"Enter Last name:";
stream.getline(p.lname,20); 
if(strlen(p.lname)==0)
return stream;
cout<<"Enter First name:";
stream.getline(p.fname,20);
cout<<"Enter State:";
stream.getline(p.state,10);
cout<<"Enter Zipcode:";
stream.getline(p.zipcode,10);                                       
return stream;
}


//main function reads the details of persons


//#include "readper.cpp"
ostream & operator << (ostream  & stream,Person &p)
{
stream<<p.lname<<p.fname<<p.state<<p.zipcode;
return stream;
}

int main() {
char filename[20];
Person p;
cout<<"Enter filename:";
cin.getline(filename,19);
ofstream stream(filename,ios::out);
if(stream.fail()) {
cout<<"File open is failed";
return 0;
}
while(1) {
cin>>p;
if(strlen(p.lname)==0)
break;
stream<<p;
cout<<p;
}
}

/*     OUTPUT
Enter filename:kishor
Enter Last name:kumar
Enter First name:kishor
Enter State:AP
Enter Zipcode:535101
kumarkishorAP535101Enter Last name:
*/
 
