/**
 * Created by amita on 12/9/17.
 * You are given a sorted array that has been rotated. Poosible problems:
 * 1. find the minimum
 * 2. search an element
 * 3. rotation count
 */
public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int minIndex = findMinimumIndex(arr);
        System.out.println(minIndex);
        System.out.println("index of 6 is " + searchKey(arr,6));
    }

    /**
     * @param arr rotated array O(lg(n))
     * @return INDEX of the minimum element in a rotated sorted array
     */
    public static int findMinimumIndex(int[] arr) {
        int low = 0, high = arr.length - 1;
        //for a rotated array, arr[low]>arr[high]
        while (arr[low] > arr[high]) {
            int mid = (low + high) / 2;
            //the part that is unsorted contains the minimum element
            if (arr[low] > arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
        //return arr[low] to return the minimum element instead
    }

    public static int searchKey(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int pivot = findMinimumIndex(arr);
        if (arr[pivot] == key) {
            return pivot;
        }


        //search in the right part, which is sorted
        low = pivot + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        //search the left part separately, which is also sorted
        low = 0;
        high = pivot - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * The number of times a sorted array has been rotated
     * @param arr
     * @return
     */
    public int rotationCount(int[] arr){
        return findMinimumIndex(arr);
    }

    public static int binarySearch(int arr[], int key)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high)
        {
            int mid = (low+high)/2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}

