#include <stdio.h>
#include <conio.h>
#include <alloc.h>
struct node{
 int data;
 struct node *next;
 int pos;
 };
typedef struct node *nodeptr;
nodeptr create(int);
void print(nodeptr);
void main()
{
  nodeptr list;
  int n;
  clrscr();
  printf("Enter the number of items to be inserted\n");
  scanf("%d",&n);
  list=create(n);
  print(list);
  getch();
}

nodeptr create(int n)
{
  nodeptr list,p;
  int i;
  list=(nodeptr)malloc(sizeof(nodeptr));
  list->next=NULL;
  printf("Enter data\n");
  scanf("%d",&(list->data));
  p=list;
  list->pos=0;
  //printf("enter data for subsequent nodes\n");
  for(i=1;i<n;i++)
  {
    p->next=(nodeptr)malloc(sizeof(nodeptr));
    p=p->next;
    scanf("%d",&(p->data));
    p->pos=i;
    p->next=NULL;
  }
  return (list);
}

void print(nodeptr list)
{
  nodeptr p;
  p=list;
printf("The created Linked list is:\n");
  while(p!=NULL)
  {
    printf("<- %d -> <- %d ->\n",p->pos,p->data);
    p=p->next;
  }
}
