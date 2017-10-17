/**Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
**/

public ListNode swapPairs(ListNode head) {
    if(head==null) return null;
    ListNode p = head, q = null;
    while(p!=null && p.next!=null){
        ListNode next = p.next;
        p.next = next.next;
        next.next = p;
        //adjust the previous pointer pointing to the reversed node
        if(p==head) head = next;
        if(q!=null) q.next = next;
        //move the q and p
        q = p;
        p=p.next;
    }
    return head;
}