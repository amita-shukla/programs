/**
path with minimum sum
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
You can only move either down or right at any point in time. 
**/
public class DpMinPath {
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size();
	    int n = a.get(0).size();
	    int[][] dp = new int[m][n];
	    
	    dp[0][0] = a.get(0).get(0);
	    
	    for(int j = 1; j < n; j++)
	        dp[0][j] = dp[0][j-1] + a.get(0).get(j);
	        
	    for(int i = 1; i < m; i++)
	        dp[i][0] = dp[i-1][0] + a.get(i).get(0);
	        
	   for(int i = 1; i < m; i++){
	       for(int j = 1; j < n; j++){
	           dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + a.get(i).get(j);
	       }
	   }
	    
	    return dp[m-1][n-1];
	}
}

