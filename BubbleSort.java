import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {4,6,1,8,2};
        int[] arr = {4,1,3,9,7};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * swap each element that is in incorrect order
     * outer loop: the number of passes = length of array
     * inner loop: compare each element to its next one
     *
     * O(n^2) : Worst case - reversed array
     * O(n) : best case - already sorted
     * O(n^2) : average case
     * O(1) : space
     * inplace: yes
     * stable: yes
     */
    private static void bubblesort(int[] a) {
        for (int n = 1; n <= a.length; n++) {
            for (int j = 0; j < a.length-1; j++) {
               if(a[j]>a[j+1]) {
                   int s = a[j+1];
                   a[j+1] = a[j];
                   a[j] = s;
               }
            }
        }
    }
}
/*
dry run:
4 6 1 8 2
i j
4 6 1 8 2
  i j
4 1 6 8 2
    i j
4 1 6 8 2
      i j
4 1 6 2 8
*/