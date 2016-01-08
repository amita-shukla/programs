package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stocks {

	public static void main(String[] args) {
		
		Integer[] inp = {1,2};
		int size = inp.length;
		System.out.println(maxDiff(inp,size));
		List<Integer> arr = Arrays.asList(inp); 
		System.out.println(maxDiff(arr));
	}
	
	public static int maxDiff(Integer arr[], int arr_size)
	{
	  int max_diff = arr[1] - arr[0];
	  int min_element = arr[0];
	  int i;
	  for(i = 1; i < arr_size; i++)
	  {       
	    if (arr[i] - min_element > max_diff)                               
	      max_diff = arr[i] - min_element;
	    if (arr[i] < min_element)
	         min_element = arr[i];                     
	  }
	  return max_diff;
	}    


	public static int maxDiff(List<Integer> arr)
	{
		
	  int max_diff = arr.get(1) - arr.get(0);
	  int min_element = arr.get(0);
	  int i;
	  for(i = 1; i < arr.size(); i++)
	  {       
	    if (arr.get(i) - min_element > max_diff)                               
	      max_diff = arr.get(i) - min_element;
	    if (arr.get(i) < min_element)
	         min_element = arr.get(i);                     
	  }
	  return max_diff;
	}    

}
