/**
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]

**/

public class DpStairs {
    static int[] dp = new int[10000000];
	public int climbStairs(int a) {
	    if(a == 0){
	        dp[0] = 0;
	        return 0;
	    }
	    if(a == 1){
	        dp[1] = 1;
	        return 1;
	    }
	    if(a == 2){
	        dp[2] = 2;
	        return 2;
	    }
	    
	    
	   if(dp[a] != 0)
	        return dp[a];
	   
	   dp[a] = climbStairs(a-1) + climbStairs(a-2);
	   return dp[a];
	}
}

