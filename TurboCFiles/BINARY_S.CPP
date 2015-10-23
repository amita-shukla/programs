#include <stdio.h>
#include <conio.h>
#include <alloc.h>
struct nodetype{
  int info;
  struct nodetype *left;
  struct nodetype *right;
};
typedef struct nodetype *nodeptr;
//prototypes
nodeptr getnode();
nodeptr maketree(int);
void setleft(nodeptr, int);
void setright(nodeptr, int);

void main()
{
nodeptr ptree;
nodeptr p, q;
int number;
clrscr();
scanf("%d",&number);
ptree= maketree(number);
while(scanf("%d",&number)!=EOF)
{
p=q=ptree;
while(number != p->info && q != NULL)
{
  p=q;
  if(number < p->info)
    q=p->left;
  else
    q=p->right;
}
if (number == p->info)
  printf("%d is dupicate\n", number);
else if(number < p->info)
  setleft(p, number);
else
  setright(p, number);
}
getch();
}

nodeptr maketree(int x)
{
 nodeptr p;
 p=getnode();
 p->info=x;
 p->left= NULL;
 p-> right=NULL;
 return p;
}

nodeptr getnode()
{
  nodeptr p;
  p=(nodeptr)malloc(sizeof(struct nodetype));
  return p;
}

void setleft(nodeptr p, int x)
{
  if(p==NULL)
    printf("void insertion\n");
  else if(p->left != NULL)
    printf("invalid inserion\n");
  else
    p->left=maketree(x);
}

void setright(nodeptr p, int x)
{
  if(p==NULL)
    printf("void insertion\n");
  else if(p->right != NULL)
    printf("invalid insertion\n");
  else
    p->right=maketree(x);
}