/**
Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

**/
public class DpEditDistanceAlgorithm {
	public int minDistance(String a, String b) {
	    int m = a.length();
	    int n = b.length();
	    
	    int[][] dp = new int[m+1][n+1];
	    
	    for(int i = 0; i <= m; i++){
	        for(int j = 0; j <= n; j++){
	 
	            if(i == 0){
	                // If first string is empty, then
                    // isnert all characters of second string
	                dp[i][j] = j;
	            }else if(j == 0){
	                // If second string is empty, then
                    // remove all characters of second string
	                dp[i][j] = i;
	            }else if(a.charAt(i-1) ==  b.charAt(j-1)){
	                // If last characters are same, ignore last char
                    // and recur for remaining string
	                dp[i][j] = dp[i-1][j-1];
	            }else{
	                // If last character are different, consider all
                    // possibilities and find minimum
                    //dp[i][j-1]  Insert
                    //dp[i-1][j-1] Replace
                    //dp[i-1][j] Delete
	                dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
	            }
	        }
	    }
	    
	    return dp[m][n];
	}
}

