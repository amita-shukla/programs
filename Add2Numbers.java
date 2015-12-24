package linkedlists;

public class Add2Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// add: 17+495=512
		int[] arr = { 7, 1 };
		int[] arr2 = { 5, 9, 4 };

		LinkedListNode sum = Add2Numbers.add(LinkedList.createList(arr),
				LinkedList.createList(arr2));

		LinkedList.print(sum);
	}

	public static LinkedListNode add(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode temp1 = head1;
		LinkedListNode temp2 = head2;
		int n1 = 0, n2 = 0;

		// find the length of the lists
		while (temp1 != null) {
			n1++;
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			n2++;
			temp2 = temp2.next;
		}
		//System.out.println("n1= "+n1+ " n2 = "+n2);
		if (n1 > n2) {
			// pad list2
			int diff = n1 - n2;
			temp2 = head2;
			while (temp2.next != null)
				temp2 = temp2.next;
			while (diff-- > 0) {
				LinkedListNode pad = new LinkedListNode(0);
				temp2.next = pad;
				temp2 = pad;
			}
		} else if (n2 > n1) {
			// pad list1
			int diff = n2 - n1;
			temp1 = head1;
			while (temp1.next != null)
				temp1 = temp1.next;
			while (diff-- > 0) {
				LinkedListNode pad = new LinkedListNode(0);
				temp1.next = pad;
				temp1 = pad;
			}
		}

		LinkedListNode result = null;
		LinkedListNode temp3 = result;

		int carry = 0;

		temp1 = head1;
		temp2 = head2;

		// traverse through the lists
		while (temp1 != null) {
			int a = temp1.data;
			int b = temp2.data;
			
			int c = (a + b + carry) % 10;
			carry = (a + b + carry) / 10;
			
			//System.out.println("carry= "+carry+" c= "+c);
			LinkedListNode node = new LinkedListNode(c);
			if (result == null) {
				result = node;
				temp3 = result;
			} else {
				temp3.next = node;
				temp3 = node;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if (carry > 0) {
			LinkedListNode node = new LinkedListNode(carry);
			temp3.next = node;
		}
		return result;
	}
}
