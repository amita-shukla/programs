#include <stdio.h>
#include <conio.h>
typedef struct node{
  int data;
  struct node *next;
}node;
node* create(int n);
void print(node*);
int count(node*);
void main()
{
  node *head;
  int n;
  printf("Enter the number of items\n");
  scanf("%d",&n);
  head = create(n);

}
node* create(int n)
{
  node *head,*p;
  int i;

}