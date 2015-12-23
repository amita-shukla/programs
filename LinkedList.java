package linkedlists;
public class LinkedList {
	
	public static void main(String[] args){
		int[] inp = {1,2,3,4,5};
		LinkedListNode head = createList(inp);
		print(head);
		delete(head,3);
		print(head);
	}
	
	public static LinkedListNode createList(int[] arr){
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode last = head;
		for(int i=1; i<arr.length; i++){
			LinkedListNode newNode = new LinkedListNode(arr[i]);
			last.next = newNode;
			last = newNode;
		}
		return head;	
	}
	
	/**
	 * 
	 * @param head
	 * @param data
	 * deletes all instances of nodes with given data from a linked list
	 */
	public static void delete(LinkedListNode head, int data){
		LinkedListNode p = head;
		LinkedListNode q = null;
		//take care of the head pointer
		if(p.data == data){
			head = head.next;
			p = head;
		}
		while(p != null){
			if(p.data == data)
				q.next = p.next;
			else
				q = p;
			p = p.next;
		}
	}
	
	public static void print(LinkedListNode head){
		LinkedListNode temp = head;
		System.out.println("The Linked List is:");
		while(temp != null){
			System.out.print(" "+temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void appendToTail(LinkedListNode head, int d){
		LinkedListNode newNode = new LinkedListNode(d);
		LinkedListNode temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = newNode;
	}

}

