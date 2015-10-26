/*reverse a linked List:
1. Iterative Solution:
	Take 3 pointers: p, q, r
*/
listnode* reverseList(listnode* A) {
    if(A->next==NULL)
        return A;
    listnode* q = A;
    listnode* p = q->next;
    listnode* r = p->next;
    while(r!=NULL){
        p->next=q; //reverse the link of node p
		//iterate forward
        q=p;
        p=r;
        r=r->next;
    }
	//the last reversal
    p->next=q;
    q=p;// Why did I do this? 
    //p=r;
    A=p;
	A->next = NULL;
    return A;
}

//There is a recursive approach as well:
/**
 * @input A : Head pointer of linked list 
 * 
 * @Output head pointer of list.
 */
listnode* reverseList(listnode* A) {
    if(A==NULL)
        return NULL;
    listnode *p;
    listnode *q;
    if(A->next == NULL){
        return A;
    }
    p = reverseList(A->next);
	//reverse at the last
    q = A->next;
    q->next=A;
    A->next = NULL;
    return p;
}

//Reverse a list from m to n:
listnode* reverseBetween(listnode* head, int m, int n) {
     listnode* newHead = listnode_new(-1);
    newHead->next = head;
    listnode* prev = newHead;
    int i;
    for(i = 0 ; i < m-1 ; i++){
        prev = prev->next;
    }
    listnode* reversedPrev = prev;
        //position m
        prev = prev->next;
        listnode* cur = prev->next;
        for(i = m ; i < n ; i++){
            prev->next = cur->next;
            cur->next = reversedPrev->next;
            reversedPrev->next = cur;
            cur = prev->next;
        }
    return newHead->next;
}


//Note::

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 * 
 * typedef struct ListNode listnode;
 * 
 * listnode* listnode_new(int val) {
 *     listnode* node = (listnode *) malloc(sizeof(listnode));
 *     node->val = val;
 *     node->next = NULL;
 *     return node;
 * }
 */
