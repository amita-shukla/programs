// Program to search an element in a 2D array
#include <stdio.h>
#include <conio.h>
void main()
{
  clrscr();
  int a[10][10],i,j,flag=0,m,n,item;
  printf("Enter the size of the array");
  scanf("%d %d",&m,&n);
  printf("\nEnter the elements of the array\n");
  for(i=0;i<m;i++)
  { printf("\n");
    for(j=0;j<n;j++)
      scanf("%d",&a[i][j]);
  }
  printf("Enter the item to be searched\n");
  scanf("%d",&item);
  for(i=0;i<m;i++)
  {
    for(j=0;j<n;j++)
    {
      if(a[i][j]==item)
      {
	printf("The element is present\n");
	flag=1;
	break;
      }
    }
  }
  if(flag==0)
    printf("the element is not present\n");
  getch();
}