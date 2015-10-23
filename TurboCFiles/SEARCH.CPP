//Program for searching of an array using sequential search
#include <stdio.h>
#include <conio.h>
int search(int a[],int key,int n);
void main()
{
  int a[50],key,n,j;
  clrscr();
  printf("enter no. of elements\n");
  scanf("%d",&n);
  printf("enter elements:\n");
  for(int i=0;i<n;i++)
  {
    scanf("%d",&a[i]);
  }
  printf("enter the element to be searched");
  scanf("%d",&key);
  j=search(a,key,n);
  if(j==-1)
    printf("the element not found");
  else
    printf("the element is found at location %d",j+1);
  getch();
}

int search(int a[],int key, int n)
{ int i=0;
  while(i<n && key!=a[i])
  {
    i++;
  }
  if(i==n)
    return -1;
  return i;
}