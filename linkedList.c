#include<stdio.h>
#include<stdlib.h>

struct node{
	int data;
	struct node *next;
};

typedef struct node *nodeptr;

nodeptr getnode(int);
void insafter(nodeptr, int);
void insend(nodeptr, int);
void insbgn(nodeptr *, int);
void print(nodeptr);

int main(){

	printf("Creating linked list...");
	int n;
	printf("Enter number of items\n");
	scanf("%d",&n);
	printf("Enter the numbers:\n");
	nodeptr head = NULL;
	nodeptr last = NULL;
	int i;
	for(i=0; i<n; i++){
		int data=0;
		scanf("%d",&data);
		nodeptr p = getnode(data);
		if(i==0){		
			head = p;
			last = head;
		}else{
			last->next = p;
			last = p;
		}
	}
	printf("The linked list is:\n");
	print(head);
	printf("\n");
	printf("What else you want to do?\n");
	printf("1. Insertion at the end\n2. Insertion at the beginning\n3. Insertion after a given node\n4. Do nothing as always\n");
	int choice;
	scanf("%d",&choice);
	while(choice!=4){
	int data;
		if(choice == 1){
		//insend
			printf("Enter the number:\n");
			scanf("%d",&data);
			insend(head,data);
			/*note: I could've used last ptr for insertion at the end. 
			But for now I am trying tenenbaum impelementations.*/	
			printf("The linked list now is:\n");
			print(head);
			printf("\n");
		}else if(choice == 2){
		//insbn			
			printf("Enter the number:\n");
			scanf("%d",&data);
			nodeptr *headptr = &head;
			insbgn(headptr,data);
			printf("The linked list now is:\n");
			print(head);
			printf("\n");
		}else if(choice == 3){
		//insafter
			printf("Enter the node number after which to insert\n");
			int index;
			scanf("%d",&index);
			nodeptr temp = head;
			while(index > 1){
				temp = temp->next;
				index--;
			}
			printf("Enter the number to insert");
			scanf("%d",&data);
			insafter(temp, data);
			printf("The linked list now is:\n");
			print(head);
			printf("\n");
		}else{
			printf("You have entered wrong option choice\n");
		}
		printf("What else?\n");
		scanf("%d",&choice);
	}	
	
return 0;
}


nodeptr getnode(int data){
	nodeptr p = NULL;
	p  = (nodeptr)malloc(sizeof(nodeptr));
	p->data = data;
	p->next = NULL;
	return p;
}

void insbgn(nodeptr *headptr, int data){
	nodeptr p = getnode(data);
	p->next = *headptr;
	*headptr = p;
}

void insend(nodeptr head, int data){
	nodeptr p = head;
	while(p->next != NULL)
		p = p->next;
	p->next =  getnode(data);	
}

void insafter(nodeptr p, int data){
	nodeptr q = getnode(data);
	q->next = p->next;
	p->next = q;
}

void print(nodeptr head){
	nodeptr p = head;
	while(p != NULL){
		printf("%d ",p->data);
		p = p->next;	
	}
}

