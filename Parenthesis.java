/**
Given n pairs of parentheses, 
write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Make sure the returned list of strings are sorted.

**/
public class Solution {
    static ArrayList<String> res;
	public ArrayList<String> generateParenthesis(int n) {
	    
	    res = new ArrayList<>();
	    
	   // for (int i = 1; i <= n; i++)
        //{
            brackets("", 0, 0, n);
        //}
        return res;
        
	}    
    private static void brackets(String output, int open, int close, int pairs)
    {
        if((open==pairs)&&(close==pairs))
        {
            res.add(output);
        }
        else
        {
            if(open<pairs)
                brackets(output + "(", open+1, close, pairs);
            if(close<open)
                brackets(output + ")", open, close+1, pairs);
        }
    }
	
}

