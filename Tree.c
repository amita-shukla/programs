//yet to be checked.
#include <stdio.h>
#include <stdlib.h>

struct node{
	int data;
	struct node *left;
	struct node *right;
};

typedef struct node *nodeptr;

nodeptr getnode(int);
void pretrav(nodeptr);
void intrav(nodeptr);
void posttrav(nodeptr);

int main(){
	/** create a tree here as per your wish **/
	nodeptr root = getnode(1);
	nodeptr two = getnode(2);
	nodeptr three = getnode(3);
	
	root->left = two;
	root->right = three;
	
	//and so on...
	printf("preorder trversal\n");
	pretrav(root);
	printf("inorder trversal\n");
	intrav(root);
	printf("postorder trversal\n");
	posttrav(root);
	printf("\n");
	
return 0;
}

nodeptr getnode(int data){
	nodeptr node = NULL;
	node = (nodeptr)malloc(sizeof(nodeptr));
	node->data = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

/**
1. visit root
2. visit left subtree
3. visit right subtree
**/
void pretrav(nodeptr root){
	if(root != NULL){
		printf(" %d",root->data);
		pretrav(root->left);
		pretrav(root->right);
	}
}


/**
1. visit left subtree
2. visit root
3. visit right subtree
**/
void intrav(nodeptr root){
	if(root != NULL){
		intrav(root->left);
		printf(" %d",root->data);
		intrav(root->right);
	}
}


/**
1. visit left subtree
2. visit right subtree
3. visit root
**/
void posttrav(nodeptr root){
	if(root != NULL){
		posttrav(root->left);
		posttrav(root->right);
		printf(" %d",root->data);
	}
}


