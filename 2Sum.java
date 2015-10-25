/*
==========================================================================================================================
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function.
Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. 
If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
==========================================================================================================================
*/
public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int target) {
	    if(a.size()<2)
	        return new ArrayList<Integer>();
	   ArrayList<Integer> res = new ArrayList<>();
	   HashMap<Integer, Integer> hm = new HashMap<>();
	   hm.put(a.get(0),1);
	   for(int i=1; i<a.size();i++){
	       int num2 = a.get(i);
	       int num1 = target - num2;
	       if(hm.containsKey(num1)){
	           res.add(hm.get(num1)); //index of num1
	           res.add(i+1); //index of num2
	           break;
	       }
	       //insert in hm
	       if(!hm.containsKey(num2))
	            hm.put(num2,i+1);
	   }
	   return res;
	}
}
