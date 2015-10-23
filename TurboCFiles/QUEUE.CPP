//Program to implement a queue
//Array implementation
#include <stdio.h>
#include <conio.h>
#include <process.h>
#define MAXSIZE 50
struct queue{
  char item[MAXSIZE];
  int f,r;
};
void enqueue(struct queue *p, char y);
int dequeue(struct queue *p);
void display(struct queue *q);
void main()
{
  int choice;
  char c,y,x;
  struct queue *p;
  clrscr();
  do{
    printf("Enter 1. For insertion \n2. For deletion\n3. For display\n4. Exit");
    scanf("%d",&choice);
    switch(choice)
    {
      case 1:
	printf("Enter the item to be inserted\n");
	y=getch();
	enqueue(p,y);
	break;
      case 2:
	x=dequeue(p);
	printf("Item deleted is %c\n",x);
	break;
      case 3:
	display(p);
	break;
      case 4:
	exit(0);
	break;
      default:
	printf("Wrong Value\n");
    }
    printf("Do you want to continue? press y\n");
    c=getch();
  }while(c=='y');
  getch();
}
void enqueue(struct queue *p, char y)
{
  if(p->r==MAXSIZE-1)
  {
    printf("Queue overflows on insertion\n");
    exit(1);
  }
  else
  {
    (p->r)++;
    p->item[p->r]=y;
    printf("Item inserted\n");
  }
  if(p->f==-1)//if the queue is empty
  {
    p->f=0;
    return;
  }
}
int dequeue(struct queue *p)
{ char x;
  if(p->f==-1)
  {
    printf("The queue is empty\n");
    exit(1);
  }
  else
  {
    x=p->item[p->f];

  }
  //check for emptyness
  if(p->f==p->r)
    p->f=p->r=0;
  else
    (p->f)++;
  return x;
}
void display(struct queue *q)
{
  int j;
  for(j=q->f;j<=(q->r);j++)
  {
    printf("%c",(q->item[j]));
    printf("\n");
  }
}