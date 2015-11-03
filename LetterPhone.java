/*
===============================================================================================
Given a digit string, return all possible letter combinations that the number could represent.

	The digit 0 maps to 0 itself.
	The digit 1 maps to 1 itself.

Example:
	Input: Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
===============================================================================================
For every integer, you have 1/3/4 options. Try appending every letter in the option to the 
string and move forward.

Something like this:
						             ""                                   <---- partial string
						 2/       2/               2\
					    "a"       "b"               "c"
				  3/   3\  3\    3/ 3\   3\     3/ 3\    3\
			     "ad" "ae" "af" "bd" "be" "bf" "cd" "ce" "cf"

As you see above, we can start over an empty string and then move down the tree.
(Each branch stands for a new recursive call)
Also, observe that each call will end when we are done with traversing all the given digits,
	(here "23")

===============================================================================================
*/
public class Solution {
    static ArrayList<String> res;
    static HashMap<Integer, String> hm;
	public ArrayList<String> letterCombinations(String digits) {
	    res = new ArrayList<>();
	    hm = new HashMap<>();
	    hm.put(0,"0");
	    hm.put(1,"1");
	    hm.put(2,"abc");
	    hm.put(3,"def");
	    hm.put(4,"ghi");
	    hm.put(5,"jkl");
	    hm.put(6,"mno");
	    hm.put(7,"pqrs");
	    hm.put(8,"tuv");
	    hm.put(9,"wxyz");
	    
	    String partial = "";
	    backTrack(digits,0,partial);
	    return res;
	}
	
	public static void backTrack(String digits, int pos, String partial){
	    //System.out.println("pos="+pos);
	    if(pos==digits.length()){
	       res.add(partial);
	       return;
	    }
	   
	   int digit = digits.charAt(pos) - '0';
	   String letters = hm.get(digit);
	   
	   for(int i=0; i<letters.length(); i++){
	       String temp = letters.substring(i,i+1);
	      //System.out.println("temp="+temp);
	       partial = partial.concat(temp); //made a mistake here by doing partial.concat(temp),
										  // thinking the partial string will get updated.
										//remember, a new string object is returned on concat().
	     //  System.out.println("partial="+partial);
	       backTrack(digits,pos+1,partial);
	       if(partial.length()!=0)
	            partial = partial.substring(0,partial.length()-1);
	   }
	   return;
	}
}


