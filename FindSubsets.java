/**
Find all possible subsets given an arrayList 'set'.
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in lexicographic order.
**/
public class Solution {
    static ArrayList<ArrayList<Integer>> sets;
    
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
	    
	    Collections.sort(a);
	    sets = new ArrayList<ArrayList<Integer>>();
	    sets.add(new ArrayList<Integer>());
	    backtrack(set,0,new ArrayList<Integer>());
	   
	    return sets;
	}
	
	public static void backtrack(ArrayList<Integer> set, int index, ArrayList<Integer> partial){
	    
	    for(int i=index; i< set.size(); i++){
	        ArrayList<Integer> subset = new ArrayList<>(partial);
	        subset.add(set.get(i));
	        sets.add(subset);
	        backtrack(set,i+1,subset);
	    }
	}
}

