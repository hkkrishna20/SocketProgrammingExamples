#include<bios.h>

#include<conio.h>

#define COM1 0

#define DATA_READY 0×100

#define SETTINGS(0×80|0×02|0×00|0×00)

#include<stdio.h>

int main(void)

{

char msg[1000], msg_in[1000];

char str[1000];

int status, out, in, i=0, extra;

FILE *fp;

int choice;

char c[1000];

printf(“\n1. Send or 2.Receive”);

scanf(“%d”, &choice);

switch(choice)

{

case 1:

{

bioscom(0,SETTINGS,COM1);

printf(“Enter the file name\n”);

scanf(“%s”, str);

while(1)

{

status=bioscom(3,0,COM1);

if(status && DATA_READY)

{

fp=fopen(str,”r”);

while((c[i]=getc(fp))!=EOF)

{

bioscom(1,c[i],COM1);

printf(“%c”, c[i]);

i++;

}

break;

}

}

}

case 2:

{

bioscom(0, SETTINGS, COM1);

fp1 = fopen(“str.c”, “w”);

while(1)

{

status=bioscom(3,0,COM1);

if(status && DATA_READY)

{

while((sam=bioscom(2,0,COM1)&0x7f!=0)

{

msgbox[i]=sam;

printf(“%c”, msgbox[i]);

fprintf(fp1, “%c”, msgbox[i]);

i++;

}

break;

}

}

}

}

getch();

return(0);

}
