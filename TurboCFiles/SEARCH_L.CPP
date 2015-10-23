#include <stdio.h>
#include <conio.h>
#include <alloc.h>
struct node
{
  int data;
  struct node *next;
};
typedef struct node *nodeptr;
nodeptr create(int);
void print(nodeptr);
void search(nodeptr, int);
void main()
{
  nodeptr list;
  int n,item;
  clrscr();
  printf("\nEnter number of items\n");
  scanf("%d",&n);
  list=create(n);
  print(list);
  printf("Enter the item to be searched\n");
  scanf("%d",&item);
  search(list,item);
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

void search(nodeptr list, int x)
{
  nodeptr p;
  int flag=0;
  p=list;
  while(p != NULL)
  {
    if(p->data==x)
     { flag=1;
      break;}
    p=p->next;
  }
  if(flag==1)
    printf("item found\n");
  else
    printf("item not found\n");

}