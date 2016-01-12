/**
Multiply Dp. Catalan numbers can be calculated as follows.
Problem:

Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.

**/
public class DpCatalanNumber {

	public int numTrees(int n) {
	   int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i)
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j-1] * dp[i-j];
                
        return dp[n];
	}
	
}
