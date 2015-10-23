// Program to merge two sorted arrays
#include <stdio.h>
#include <conio.h>
void merge(int a[],int b[],int n1, int n2);
void main()
{
  int n1,n2,i,a[20],b[20];
  printf("Enter the size of the first array\n");
  scanf("%d",&n1);
  printf("Enter the first sorted array\n");
  for(i=0;i<n1;i++)
    scanf("%d",&a[i]);
  printf("Enter the size of second array\n");
  scanf("%d",&n2);
  printf("Enter the elements of the second sorted array\n");
  for(int j=0;j<n2;j++)
    scanf("%d",&b[j]);
  merge(a,b,n1,n2);
  getch();
}

void merge(int a[],int b[],int n1,int n2)
{
  int i=0,j=0,k=0,c[20];
  while((i<n1)&& (j<n2))
  {
    if(a[i]<=b[j])
    {
     c[k]=a[i];
     i++;
     k++;
    }
    else
    {
      c[k]=b[j];
      k++;
      j++;
    }
  }
  while(i<n1)
  {
    c[k]=a[i];
    i++;
    k++;
  }
  while (j<n2)
  {
    c[k]=b[j];
    j++;
    k++;
  }
  printf("the merged array is:");
  for(k=0;k<(n1+n2);k++)
    printf("%d",c[k]);
}