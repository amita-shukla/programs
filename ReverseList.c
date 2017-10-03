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

/**
Another, shorter solution:
1->2->3->4->5->NULL
At any point, 
3->2->1->4->5 : make node '4' as head, as node '1' (temp) keeps moving towards the end
**/
listnode* reverseList(listnode* head) {
	listnode* temp = head;
    while(temp->next!=NULL){
        listnode* next = temp->next;
        temp->next = next->next;
        next->next = head;
        head = next;
    }
    return head;
}

//There is a recursive approach as well
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

/**
Same logic as the reverseList method, 
but have to maintain the pointer (temp) next to which the list has to be reversed
e.g. 1->2->3->4->5->null, m=2,n=4,
then temp=1(node at m-1), temp2=2(node at m), diff=no of times the reverse has to take place
catch: what if m=1? then, temp=null and temp2=head  have to manage this case separately.
**/
public ListNode reverseBetween(ListNode head, int m, int n) {
   ListNode temp=null;
   int count=m;
   //temp points to the node next from which the reversing starts
   while(count-->1){
       if(temp==null) temp=head; 
       else temp=temp.next;
   }

   int diff = n-m;
   ListNode temp2;
   if(temp==null) temp2=head; 
   else temp2=temp.next;
   while(diff-->0){
       ListNode next = temp2.next;
       temp2.next=next.next;
       if(temp==null){
           next.next=head;
           head=next;
       }else{
           next.next=temp.next;
           temp.next=next;
       }
   }
   return head;
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
