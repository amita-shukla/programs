class InsertionSort{
    public static void main(String[] args){
        int[] arr = {4,6,1,8,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
	* algo:
     * start from j = 1. key = a[j]
     * now take i = j-1
     * compare a[i] with key if a[i]>key
     * shift a[i] to right.
     * keep shifting until i = 0 or as long as a[i] > key
     * when you have shifted towards right, a new space gets created. place the key there.
     * at the end of one loop. all elements at the left of key are smaller than it.
	 
	 * complexity analysis:
	 * O(n^2) worst case: reverse sorted
	 * O(n) best case: already sorted
	 * O(n^2) average case: random order, half elements for an element may be greater or less
	 * O(1) space: uses no extra space
	 * inplace: yes
	 * stable: yes
     */

    private static void insertionSort(int[] a) {
        for (int j = 1; j< a.length; j++){
            int key = a[j];
            int i = j-1;
            while(i>=0 && a[i]> key){
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
	
	
}

/*
insertion sort dry run
 4 3 2 10 12 1 5 6
 i j

  3 4 2 10 12 1 5 6 key = 3
  i j
  
  3 4 4 10 12 1 5 6 key = 2
  i   j
  3 3 4 10 12 1 5 6 key = 2
i     j
  2 3 4 10 12 1 5 6
      i j
  2 3 4 10 12 1 5 6 key = 10
      i 
  2 3 4 10 12 1 5 6 key = 12
        i  
  2 3 4 10 12 1 5 6 key = 1		
           i  
  2 3 4 10 12 12 5 6 key = 1
         i
  2 3 4 10 10 12 5 6 key = 1
      i
  2 3 4 4 10 12 5 6 key = 1
    i
  2 3 3 4 10 12 5 6 key = 1
  i
  2 2 3 4 10 12 5 6 key = 1
i  
  1 2 3 4 10 12 5 6
             i  j

  1 2 3 4 10 12 12 6 key = 5			 
           i
  1 2 3 4 10 10 12 6 key = 5
        i 
  1 2 3 4 5 10 12 6 
                  j
  1 2 3 4 5 10 12 6 key = 6
               i
  1 2 3 4 5 10 12 12 key = 6
             i
  1 2 3 4 5 10 10 12 key = 6
          i
  1 2 3 4 5 6 10 12
*/