#include <stdio.h>
#include <conio.h>
#include <alloc.h>
struct node{
  int data;
  struct node *next;
};
typedef struct node *nodeptr;
nodeptr create(int);
void print(nodeptr);
void insafter(nodeptr, int);
void insend(nodeptr *, int);
void main()
{
  nodeptr list,temp;
  int n,choice,location,value;
  clrscr();
  printf("\nEnter number of items\n");
  scanf("%d",&n);
  list=create(n);
  print(list);

    temp=list;
    printf("Enter 1. For insertion at the beginning\n 2.For insertion at given location\n 3. Fro inserion at the end\n");
    scanf("%d",&choice);
    if(choice==1) {
      printf("Enter the item to be inserted\n");
      scanf("%d",&value);
      insbgn(*list,value);
      printf("----");}
    else if(choice==2){
      printf("Enter the location at which insertion has to take place\n");
      scanf("%d",&location);
      printf("Enter the item to be inserted\n");
      scanf("%d",&value);
      int i;
      for (i=1;(i<location-1);i++)
      {
	temp=temp->next;

      }
      insafter(temp,value);
      print(list);
      }
    else
    {
      printf("Enter the item to be inserted\n");
      scanf("%d",&value);
      insend(*list,value);
      print(list);
     }
  getch();
}

nodeptr create(int n)
{
  nodeptr list, p;
  int i;
  list=(nodeptr)malloc(sizeof(nodeptr));
  list->next=NULL;
  printf("Enter data");
  scanf("%d",&(list->data));
  p=list;
  //printf("enter data for subsequent nodes\n");
  for(i=1;i<n;i++)
  {
    p->next=(nodeptr)malloc(sizeof(nodeptr));
    p=p->next;
    scanf("%d",&(p->data));
    p->next=NULL;
  }
  return (list);
}

void print(nodeptr p)
{
printf("The created Linked list is:\n");
  while(p!=NULL)
  {
    printf("<- %d ->",p->data);
    p=p->next;
  }
}

void insafter(nodeptr p, int x)
{
   nodeptr q;
   if(p==NULL)
   {
     printf("void insertion\n");
   }
   q=(nodeptr)malloc(sizeof(nodeptr));
   q->data=x;
   q->next=p->next;
   p->next=q;
   printf("\ninserted\n");

}

void insend(nodeptr *plist, int x)
{
  nodeptr p, q;
  p=(nodeptr)malloc(sizeof(nodeptr));
  p->data=x;
  p->next=NULL;
  if(*plist == NULL)
    *plist=p;
  else
  {
    for(q=*plist;q->next !=NULL; q=q->next)
    ;
    q->next=p;
  }
}

void insbgn(nodeptr *plist, int