//Program to implement a stack
#include <stdio.h>
#include <conio.h>
#include <process.h>
# define MAXSIZE 100
struct stack
{
  char item[MAXSIZE];
  int top;
};
void push(struct stack *p,char x);
int pop(struct stack *p);
void main()
{
  int i;
  char j;
  struct stack *p;
  char x,y;

  do{
  printf("\nEnter 1. For insertion\n2. For Deletion\n");
  scanf("%d",&i);
  switch(i){
    case 1:
      printf("Enter the element to be inserted: ");
      x=getch();
      push(p,x);
      break;
    case 2:
      j=pop(p);
      printf("\nthe deleted element is %c",j);
      break;
    default:
      printf("\nwrong value");
	   }
  printf("\nDo you want to continue? enter y");
  y=getch();
  }while(y=='y');
  getch();
}

void push(struct stack *p, char x)
{
  //check for overflow
  if(p->top==MAXSIZE-1)
  {
     printf("Stack overflows on Push\n");
     exit(1);
  }
  else
  {
    (p->top)++;
    p->item[p->top]=x;
  }
}

int pop(struct stack *p)
{
  int y;
  //check for underflow
  if(p->top==-1)
  {
    printf("The stack is empty\n");
    exit(1);
  }
  else
  {
    y=p->item[p->top];
    (p->top)--;
    return y;
  }
}
