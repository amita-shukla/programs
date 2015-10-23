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
int delbgn(nodeptr *);
int delafter(nodeptr);
int delend(nodeptr *);
void main()
{
  nodeptr list;
  int n,choice;
  clrscr();
  printf("\nEnter number of items\n");
  scanf("%d",&n);
  list=create(n);
  print(list);

  printf("\nEnter\n1. For deletion of first node\n2. For deletion at a given location\n3. For deletion of the end node\n");
  scanf("%d",&choice);
  if(choice==1)
  {
   int value;
   value=delbgn(&list);
   printf("The deleted item is: %d\n",value);
   print(list);
  }
  else if(choice==2)
  {
    int i,value,location;
    printf("\nEnter the location of the node to be deleted\n");
    scanf("%d",&location);
    nodeptr temp;
    temp=list;
    for(i=1;i<(location-1);i++)
      temp=temp->next;
    value=delafter(temp);
    printf("item deleted=%d\n",value);
    print(list);
  }
  else
  {
    int value;
    value=delend(&list);
    printf("Item deleted= %d\n",value);
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
  p=list;
  printf("Enter items\n");
  scanf("%d",&(p->data));
  for(i=1; i<n; i++)
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
  printf("The Linked list is: \n");
  while(p != NULL)
  {
    printf("<- %d ->", p->data);
    p=p->next;
  }
}

int delbgn(nodeptr *list)
{
  int value;
  nodeptr p;
  p=*list;
  //p->data=value;
  value=p->data;
  //p=p->next;
  *list=p->next;
  free(p);
  return value;
}

int delafter(nodeptr p)
{
  nodeptr q;
  int x;
  if(p== NULL || (p->next==NULL))
  {
    printf("Void deletion\n");
    return NULL;
  }
  else
  {
    q=p->next;
    x=q->data;
    p->next=q->next;
    free(q);
    return x;
  }
}

int delend(nodeptr *list)
{
  nodeptr p,q;
  int value;
  p=*list;
  //q=NULL;
  //value = p->data;
  while((p->next != NULL))
  {
    q=p;
    p=p->next;
    value=p->data;
  }
  free(p);
  q->next=NULL;
  return value;
}
