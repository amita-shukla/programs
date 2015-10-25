/*
Given an array of strings, return all groups of strings that are anagrams. 
Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4. 
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

Ordering of the result : You should not change the relative ordering of the words / phrases within the group. 
Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j. 
 
Note: 
	1. You do not need to use LinkedHashMap here. It is because the relative ordering 'within' each group is considered.
	   As we are moving sequentially, its better to use HashMap as it is faster.
	2. No it's not required. get returns a reference to the list stored in the map. 
	   So whatever modification you do on the list obtained with get (add, remove...) will be reflected on the list in the map too, 
	   because they are the same object. Hence, no need to remove the element, add an element and put it back to the map.
	3. It is a known fact that one should declare an object as interface type and not any specific implementation type. 
	   It prevents code that uses those objects from depending on methods of those objects it doesn't need, 
	   which makes the code less coupled, and therefore easier to change.
	   For example, if you find out later you really need a LinkedHashMap, you can safely make that change without affecting any other code.
	4. However, there's a trade off, because you're artificially limiting the code that can take your object as a parameter. 
	   Say there's a function somewhere that requires a HashMap for some reason. 
	   If you return a Map, you can't pass your object into that function. 
	   You have to balance the likelihood of sometime in the future needing the extra functionality that's in the more concrete class 
	   with the desire to limit coupling and keep your public interface as small as possible.


My Solution: */
public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    Map<String, ArrayList<Integer>> lhm = new LinkedHashMap<>();
		for(int i=1;i<=a.size();i++){
			String s = a.get(i-1);
			String word = alphabetize(s);
			if(!lhm.containsKey(word)){
				ArrayList<Integer> indices = new ArrayList<>();
				indices.add(i);
				lhm.put(word, indices);
			}else{
				ArrayList<Integer> indices = lhm.get(word);
				indices.add(i);
				lhm.remove(word);
				lhm.put(word, indices);
			}
		}
		
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(Map.Entry<String,ArrayList<Integer>> entry: lhm.entrySet()){
			ans.add(entry.getValue());
		}
		return ans;

	}
	public static String alphabetize(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		//System.out.println(String.valueOf(c));
		
		//System.out.println(Arrays.toString(c));
		return String.valueOf(c);
	}
	
/*The Solution:*/
class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
	    int i = 1;
	    
	    for (String str : A) {
	        
	        char [] array = str.toCharArray();
	        Arrays.sort(array);
	        String sorted = new String(array);
	        
	        if (hashMap.containsKey(sorted)) {
	            ArrayList<Integer> list = hashMap.get(sorted);
	            list.add(i);
	        } else {
	            ArrayList<Integer> list = new ArrayList<>();
	            list.add(i);
	            hashMap.put(sorted, list);
	        }
	        
	        i++;
	        
	    }
	    
	    for (Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()) {
	        res.add(entrySet.getValue());
	    }
	    
	    return res;
	}
}
