/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example : 
Given 
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Famous problem of 'palindromic partioning'
Based on matrix chain multiplication
http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/

**/
public class DpPalin {
    boolean[][] isPalin;
    int[][] cuts;
	public int minCut(String str) {
	    int n = str.length();
	    
	    isPalin = new boolean[n][n];
	    cuts = new int[n][n];
	    
	    //a string os single length is a palin and no. of cuts = 0 
	    for(int i = 0; i < n ; i++){
	        isPalin[i][i] = true;
	        cuts[i][i] = 0;
	    }
	    
	    //consider strings of length l
	    for(int l = 2; l <= n; l++){
	        //starting index = i
	        for(int i = 0; i < n-l+1; i++){
	            //ending index = j
	            int j = i+l-1;
	            //first, check if str at i to j make a palin 
	            //for a string with len 2,checking palin is easy
	            if(l == 2){
	                isPalin[i][j] = (str.charAt(i)==str.charAt(j));
	            }else{
	                isPalin[i][j] = (str.charAt(i)==str.charAt(j) && isPalin[i+1][j-1]);
	            }
	            
	            //now lets fill up no. of cuts
	            
	            if(isPalin[i][j])
	                cuts[i][j] = 0;
	           else{
	               cuts[i][j] = Integer.MAX_VALUE;
	               for(int k = i; k < j; k++){
	                   cuts[i][j] = Math.min(cuts[i][j], cuts[i][k]+cuts[k+1][j]+1);
	               }
	           }
	        }
	    }
	    return cuts[0][n-1];
	}
}

