#include<stdio.h>
#include <string.h>
#include <conio.h>
#define MAX 10
int n,fn,j,i;
char attr[MAX][10];
long int fl[MAX],fr[MAX];
long int p[]={3,5,7,11,17,19,23,29,31,37,41,43};
long int getid(char *a,char s)
{
	int k,c1,f;
	char t1[50];
	long int val=1;
	while(1)
	{
		k=0;
		while((a[j]!=',')&&(a[j]!=s))
		t1[k++]=a[j++];
		t1[k]='\0';
		f=0;
		for(c1=0;c1<n;c1++)
		if(strcmp(attr[c1],t1)==0)
		{
			f=1;
			break;
		}
		if(f==0)
		{
			strcpy(attr[n++],t1);
			val*=p[n-1];
		}
		else
		val*=p[c1];
		if(a[j]==s)
		break;
		j++;
	}
	return val;
}
int main()
{
	short int k,c1,c2;
	char t[100],a[50];
	long int temp,cl,oldcl;
	printf("\n\tNo. of Functional Dependencies : ");
	scanf("%d",&fn);
	for(i=0;i<fn;i++)
	{
		j=0;
		printf("\tFunctional Dependency %d :",i+1);
		scanf("%s",t);
		fl[i]=getid(t,'-'); // getid returns the id (prime number) for an attribute
		j+=2;
		fr[i]=getid(t,'\0');
	}
	printf("\n\n\tAttribute to find Closure  :  ");
	scanf("%s",a);
	j=0;
	cl=getid(a,'\0');
	oldcl=cl;
	for(c2=0;c2<fn;c2++)
	{
		for(k=0;k<fn;k++)
		{
			if(cl%fl[k]==0)
			{
				temp=fr[k];
				for(c1=0;c1<n;c1++)
				if((temp%p[c1]==0)&&(cl%p[c1]==0))
				temp/=p[c1];
				cl*=temp;
			}
		}
		if(oldcl==cl)
		break;
		oldcl=cl;
	}
	printf("\n\n Closure is {");
	for(k=0;k<n;k++)
	if(cl%p[k]==0)
	printf(" %s,",attr[k]);
	printf("\b }\n");
	return 0;
	getch();
}
