import java.util.Arrays;

/*
worst case: O(n^2) when array is all increasing or decreasing sorted order
best case: O(nlg(n)) when the pivot position is in the middle
average case: O(nlg(n)) 
space: O(1) if we don't consider the recursion stack, else O(lg(n))
inplace: yes
stable: no

quicksort is preferred over merge sort for arrays
mergesort is preferred over quicksort for linkedlists
*/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] a, int l, int r) {
        if(l < r) {
            int m = partition(a, l, r);
            quicksort(a, l, m-1);
            quicksort(a, m+1, r);
        }
    }

    /*
    choose a pivot element : last element at idx r
    returns the idx of the correct position of pivot
    
    start from p-1
    then parse the array, compare with pivot, if it's less then increment i 
    and swap the current idx with i+1
    */
    public static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;
        for (int j = l; j < r; j++) {
            if(a[j] < pivot){
                i++;

                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
            }
        }
        int swap = a[i+1];
        a[i+1] = a[r];
        a[r] = swap;
        return i+1;
    }
}
