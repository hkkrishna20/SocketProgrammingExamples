#include<stdio.h>

#include<conio.h>

#include<stdlib.h>

#include<string.h>

void main()

{

FILE *in,*es,*address;

int progaddr,csaddr,cslth,value;

char type[10],addr[10],obj[10],mflag[10];

clrscr();

printf(“Enter the starting address(OS)\n”);

scanf(“%d”,&progaddr);

csaddr=progaddr;

in=fopen(“OBJECT.TXT”,”r”);

es=fopen(“ESTAB.TXT”,”w”);

address=fopen(“ADDRESS.TXT”,”w”);

fprintf(address,”%d”,progaddr);

fclose(address);

fscanf(in,”%s\t%s\t%s\t%s”,type,addr,obj,mflag);

while(!feof(in))

{

cslth=atoi(obj);

fprintf(es,”%s\t-\t%d\t%s\n”,addr,csaddr,obj);

do

{

fscanf(in,”%s\t%s\t%s\t%s”,type,addr,obj,mflag);

if(strcmp(type,”D”)==0)

{

value=csaddr+atoi(obj);

fprintf(es,”-\t%s\t%d\t-\n”,addr,value);

}

}while(strcmp(type,”E”)!=0);

csaddr=csaddr+cslth;

fscanf(in,”%s\t%s\t%s\t%s”,type,addr,obj,mflag);

}

fclose(in);

fclose(es);

getch();

}

OUTPUT:

Enter the starting address(OS)

4000

ESTAB.TXT
PROGA          -           4000    9
-                       A1       4006    -
-                       A2       4009    -
PROGB          -           4009    9
-                       B1       4015    -
-                       B2       4018    -