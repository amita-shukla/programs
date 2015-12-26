package linkedlists;

public class KthLast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		LinkedListNode head = LinkedList.createList(input);
		LinkedListNode element = KthLast.findKthLast(head, 3);
		int ans = element.data;
		System.out.println("The kth last element is "+ans);
	}
	
	public static LinkedListNode findKthLast(LinkedListNode head, int k){
		LinkedListNode p = head;
		LinkedListNode q = p;
		while(k-- > 0) // test your code here
			p = p.next;
		
		while(p != null){
			p = p.next;
			q = q.next;
		}
		//test the position of q here
		return q;
	}

}
