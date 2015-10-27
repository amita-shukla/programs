/*
A sorted array has been rotated so that the elements might appear in the order 3456712. 
How would you find the minimum element? You may assume that the array has
all unique elements.

1.Sequential Search. this can be done in O(n) time by finding the point where the
array elements show a decreasing trend. But this doesn't make use of the fact that 
elements are sorted.

2.Binary search: Iterate over only that sub array such that arr[low]>arr[high], i.e.,
the sub aray that contains the min element.
*/
class Solution{
	public static int findMin(int[] arr) {
		int low = 0, high = arr.length - 1;
		// if arr[low]>arr[high], the subarray b/w low to high contains min
		while (arr[low] > arr[high]) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}
}