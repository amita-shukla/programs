//Program for insertion in an array
#include <stdio.h>
#include <conio.h>
void insertion(int a[],int n, int pos, int item);
void main()
{
  int a[50],n,pos,item;
  clrscr();
  printf("Enter the number of elemnts\n");
  scanf("%d",&n);
  printf("enter the elements\n");
  for(int i=0;i<n;i++)
      scanf("%d",&a[i]);
  printf("enter the element to be inserted\n");
  scanf("%d",&item);
  printf("Enter the location at which the element has to be inserted\n");
  scanf("%d",&pos);
  insertion(a,n,pos,item);

  getch();
}
void insertion(int a[],int n, int pos, int item)
{
  for(int i=n-1;i>=(pos-1);i--)
    a[i+1]=a[i];
  a[pos-1]=item;
  n++;
  printf("New array after insertion:\n");
  for(int j=0;j<n;j++)
    printf("%d\n",a[j]);
}


