#include<stdio.h>
#include<stdlib.h>

struct node{
	int label; //represents the node number of the tree (0 indexed)
	int data;
	struct node *left;
	struct node *right;
};

typedef struct node *nodeptr;

nodeptr getnode(int,int);
void pretrav(nodeptr);
void createTree(nodeptr);

int main(){

	int data = -1;
	int label = 0;
	printf("Provide data for the root node\n");
	scanf("%d",&data);
	nodeptr root = getnode(label,data);
	
	createTree(root);
	
	printf("\n=====================Preorder Traversal====================\n");
	pretrav(root);
return 0;
}


nodeptr getnode(int label, int data){
	nodeptr node = (nodeptr)malloc(sizeof(nodeptr));
	node->label = label;
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

void pretrav(nodeptr root){
	if(root!=NULL){
		printf("%d\n",root->data);
		pretrav(root->left);
		pretrav(root->right);
	}
}


/** MY OWN CREATION :D **/
/** Create a tree by asking inputs for a node with a given label
	A root node has been given with its label and data.
**/
void createTree(nodeptr root){
	if(root == NULL)
		return;
	
	//Initialize left and right subtrees, which are currently null
	nodeptr left = root->left;
	nodeptr right = root->right;
	//input the left child
	int data = -1;
	printf("Provide data for the left child of node %d (Enter -1 if current node is leaf)\n",root->label);
	scanf("%d",&data);
	if(data != -1){
		left = getnode(2*(root->label)+1,data);
		root->left = left;
	}
	//input the right child
	data = -1;
	printf("Provide data for the right child of node %d (Enter -1 if current node is leaf)\n",root->label);
	scanf("%d",&data);
	if(data != -1){
		right = getnode(2*(root->label)+2,data);
		root->right = right;
	}
	
	createTree(left);
	createTree(right);
}


