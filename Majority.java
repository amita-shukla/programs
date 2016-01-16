/**
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 

For this problem, I simply used a hashmap:
**/

public class Majority {
	public int majorityElement(final List<Integer> a) {
	    HashMap<Integer, Integer> hm = new HashMap<>();
	    int limit = (int) Math.floor(a.size()/2);
	    
	    for(int i = 0; i < a.size(); i++){
	        int key = a.get(i);
	        if(hm.containsKey(key)){
	            int count = hm.get(key);
	            hm.put(key, count+1);
	            if(count >= limit){
	                return key;
	            }
	        }else{
	            hm.put(key,1);
	        }
	    }
	    return a.get(0);
	}
}

/**
However, another approach may be:
If we cancel out each occurrence of an element e with all the other elements that are different from e
then e will exist till end if it is a majority element.
Loop through each element and maintains a count of the element that has the potential of
being the majority element.
If next element is same then increments the count, otherwise decrements the count.
If the count reaches 0 then update the potential index to the current element and reset count to 1.

int majorityElement(vector<int> &num) {
            int majorityIndex = 0;
            for (int count = 1, i = 1; i < num.size(); i++) {
                num[majorityIndex] == num[i] ? count++ : count--;
                if (count == 0) {
                    majorityIndex = i;
                    count = 1;
                }
            }

            return num[majorityIndex];
        }
**/
