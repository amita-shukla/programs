import java.util.Arrays;
import java.util.PriorityQueue;

/*
A heap is an almost complete binary tree :
  a tree that follows the condition: if a non leaf node has a right child, it must have a left child
A heap can be a max heap or min heap
max heap contains the top of heap as the max value
  for a max heap: parent node is always greater than child nodes

3 important formulas:
  for an index i in array:
    parent(i) = (i-1)/2
    leftchild(i) = 2i+1
    rightchild(i) = 2i + 2

2 applications of heaps: heap sort, priority queues
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
        heapsort(arr);
        System.out.println(Arrays.toString(arr));

        // priority queue: maintains a min heap, peek returns minimum element
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10); pq.add(5); pq.add(3); pq.add(4); pq.add(1);
        System.out.println(pq.peek());

    }
	
	/*
	max-heapify: O(lg(n))
	heapsort: 
	  worst case: O(nlg(n))
	  best case: O(nlg(n))
	  average case: O(nlg(n))
	  space: O(1) [no auxiliary space is used]
	*/
    private static void heapsort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length-1; i >= 1; i--) {
            int swap = a[i];
            a[i] = a[0];
            a[0] = swap;

            maxHeapify(a, i, 0);

        }
    }

    /*
    given an array, make it a max-heap.
    i.e. arrange it such that the max-heap property is satisfied
     */
    private static void buildMaxHeap(int[] a){
        // find last non leaf node
        int lastNodeIndx = a.length-1;
        int idxOfParentOfLastNode = (lastNodeIndx - 1)/2; // formula for parent(i) = (i-1)/2 (i is zero based)

        for (int i = idxOfParentOfLastNode; i >=0 ; i--) {
            maxHeapify(a, a.length, i);
        }
    }

    /*
    here n = heap size (1 based - it's not an index it's a size)
    in a number of situations, we need to reduce the size of heap
    so we can reduce n, all elements more than n are the ones that have been sorted (or discarded)
     */
    private static void maxHeapify(int[] a, int n, int i) {
        int largest = i;
        int left = 2*i + 1; // formula for left idx
        int right = 2*i + 2; // left idx + 1

        // find the largest among parent, left, right child.
        if(left < n && a[left] > a[largest]) largest = left;
        if(right < n && a[right] > a[largest]) largest = right;
        if(largest!=i) {
            // make the largest element the parent
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;
            // heapify the tree now
            maxHeapify(a, n, largest);
        }
    }
}
/*
       10(0)
    5(1)   3(2)
4(3)  1(4)
 */