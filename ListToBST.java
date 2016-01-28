/**
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

Example :

Given A : 1 -> 2 -> 3
A height balanced BST:

      2
    /   \
   1     3

**/
public class ListToBST {
	public TreeNode sortedListToBST(ListNode a) {
	    ListNode begin = a;
	    ListNode last = a;
	    while(last.next != null)
	        last = last.next;
	   
	    TreeNode root = listToBST(begin, last);
	    return root;
	}
	
	public static TreeNode listToBST(ListNode begin, ListNode last){
	    
	    if(begin == last){
	        TreeNode root = new TreeNode(begin.val);
	        root.left = null;
	        root.right = null;
	        return root;
	    }
	    
	    if(begin.next == last){
	        TreeNode root = new TreeNode(begin.val);
	        root.right = new TreeNode(last.val);
	        root.left = null;
	        return root;
	    }
	    
	    //move to the middle of linked list
	    ListNode slow = begin;
	    ListNode fast = begin;
	    ListNode prvs = null;
	    
	    while(fast.next != last.next && fast.next.next != last.next){
	        prvs = slow;
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    ListNode mid = slow;
	    
	    TreeNode root = new TreeNode(mid.val);
	  //  System.out.println(" mid= "+mid.val);
	    root.left = listToBST(begin, prvs);
	    root.right = listToBST(mid.next, last);
	    
	    return root;
	}
}
