import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,8,2};
        mergesort(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * two routines: mergesort and merge
     * mergesort is recursive: takes l, r
     * termination condition: l > r
     * merge routine:
     *   create two arrays: left, right
     *   copy elements from a[l,m] to left
     *   copy elements from a[m+1, r] to right
     *   compare left[i] with right[j] (3 while loops are needed)
     *   fill a[k] with lesser value of the left[i] or right[k]
     * complexities:
     * O(nlg(n)) worst case
     * O(nlg(n)) best case
     * O(nlg(n)) average case
     * O(n) space
     * O(n) : merge routine time complexity
	 * inplace? no
	 * stable? yes
     *
     */
    private static void mergesort(int l, int r, int[] a) {
        if(l<r) {
            int m = l + (r-l)/2;
            mergesort(l, m, a);
            mergesort(m + 1, r, a);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = l, j =0; i <= m; i++, j++) left[j] = a[i];
        for (int i = m+1, j = 0; i <= r; i++, j++) right[j] = a[i];

        int i =0, j = 0, k = l;
        while(i< n1 && j < n2){
            if(left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k] = right[j];
            j++;
            k++;
        }
    }
}