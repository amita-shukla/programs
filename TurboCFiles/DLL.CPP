#include <stdio.h>
#include <conio.h>
#include <alloc.h>
#include <process.h>
typedef struct node{
  int data;
  struct node *left, *right;
}node;
node * create(int);
void print(node *);
int deletion(node *,int);
void main()
{
  int choice,loc,value;
  clrscr();
  char c;
  do{
  printf("Enter 1. for creation\n 2. for deletion\n 3. exit \n");
  scanf("%d",&choice);
  switch(choice)
  {     node *HEAD;
    case 1:
      {

	int n,number;
	printf("\nEnter number of items");
	scanf("%d",&n);
	HEAD=create(n);
	print(HEAD);
      }
      break;
    case 2:
    {
      printf("Enter the location of the node to be deleted\n");
      scanf("%d",&loc);
      value=deletion(HEAD,loc);
      printf("Value deleted= %d",value);
    }
    break;
    case 3:
      exit(0);
      break;
    default:
      printf("Wrong choice ");
  }
  printf("Do you want to continue? press y\n");
  c=getche();
  }while(c=='y');
  getch();
}
node * create(int n)
{
  node *head,*p;
  int i;
  head=(node*)malloc(sizeof(node));
  head->right=NULL;
  printf("Enter data for the first node\n");
  scanf("%d",&head->data);
  p=head;
  for(i=1;i<n;i++)
  {
    node *q;
    q=(node*)malloc(sizeof(node));
    p->right=q;
    q->left=p->right;
    q->right=NULL;
    printf("Enter data for node %d\n",i-1);
    scanf("%d",&q->data);
    p=p->right;
  }
  return (head);
}
void print(node *p)
{
  while(p!=NULL)
  {
    printf("<-%d->",p->data);
    p=p->right;
  }
}
int deletion(node *p, int loc)
{
  int i=1;
  while(i!=loc)
  {
   i++;
   p=p->right;
  }
  node *l,*r;
  int value;
  if(p==NULL)
  {
    printf("Void deletion\n");

  }
  else
  {
    value=p->data;
    l=p->right;
    r=p->right;
    l->right=p->right;
    r->left=p->left;
    free(p);
    return value;
  }
}