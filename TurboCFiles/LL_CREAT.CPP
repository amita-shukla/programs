// Program for creation of a linked list
//unsccessful!! :(
#include <stdio.h>
#include <conio.h>
#include <alloc.h>
#include <process.h>
struct node{
  char info;
  struct node *next;
};
typedef struct node *nodeptr;
nodeptr list=NULL;
void insert(nodeptr, int);
nodeptr getnode();
void insbgn(nodeptr *, char);
void insafter(nodeptr p,char x);
void insend(nodeptr *, char);
void search(nodeptr *,char y);
void main()
{ int n, i;
  nodeptr j,q;
  char x,y;

  printf("Enter the number of nodes\n");
  scanf("%d",&n);
  insert(list,n);


  printf("Linked List Created\n");
//  printf("Linked list Created is:");
//   display();
  printf("Enter the item to be searched\n");
  y=getche();
  search(&list,y);

  getch();
}

nodeptr getnode()
{
  nodeptr node;
  node=(nodeptr)malloc(sizeof(nodeptr));
  if(node==NULL)
  {
    printf("Unable to Create a node\n");
    exit(1);
  }
  else
  {
    return node;
  }
}

void insafter(nodeptr q, char x)
{
  nodeptr r;
  if(q==NULL)
  {
    printf("Void insertion\n");
    exit(1);
  }
  else
  {
    r=getnode();
    r->info=x;
    r->next=q->next;

  }
}

void search(nodeptr *plist, char y)
{
  nodeptr p;
  for(p=*plist;p!= NULL;p=p->next)
  {  if(p->info==y)
     { printf("The item is found\n");
      break;}
  }
      printf("item not found\n");
}

void insert(nodeptr list, int n)
{
  int i=1;
  char x;
  for(i=1;i<=n;i++)
  {
    printf("Enter the item to be inserted at node %d ",i);
    x=getche();
    printf("\n");
    if(i==1)
      insbgn(&list,x);
    else if(i==n)
      insend(&list,x);
    else
      {
	nodeptr p,q;
	p=list;
	q->next=p;
	insafter(q,x);
      }
  }
  printf("Nodes inserted with the given info\n");
}
void insbgn(nodeptr *plist,char x)
{
  nodeptr p;
  p=getnode();
  p->info=x;
  p->next=NULL;
  *plist=p;
}
void insend(nodeptr *plist, char x)
{
  nodeptr p,q;
  p=getnode();
  p->info=x;
  p->next=NULL;
  for(q=*plist;q->next !=NULL;q=q->next)
  ;
  q->next=p;
}