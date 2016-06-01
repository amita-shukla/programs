import java.util.Arrays;

/**
 * Given a rod of length n and a table of prices, Find the maximum obtainable
 * revenue.
 * 
 * @author Amita
 * 
 */

public class RodCut {
	static int[] dpTopDown;

	public static void main(String args[]) {
		int[] p = { -1, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int n = 7;
		System.out.println("max rev = "+ bottomUpRodCut(n, p));
		System.out.println("max rev = "+extendedBottomUpRodCut(n, p));
		

		dpTopDown = new int[n + 1];
		Arrays.fill(dpTopDown, -1);
		System.out.println("max rev = "+topDownRodCut(n, p));

		/*
		// print dpTopDown
		for (int i = 0; i < dpTopDown.length; i++)
			System.out.println(dpTopDown[i]);
			*/
	}

	/**
	 * Bottom up method: Solves size wise, solutions to smaller subproblems used
	 * for bigger subproblems
	 * 
	 * @return maximum revenue
	 */

	public static int bottomUpRodCut(int n, int p[]) {
		int[] dp = new int[n + 1];
		dp[1] = p[1];
		for (int i = 1; i <= n; i++) {
			int max = p[i];
			for (int j = 1; j <= i / 2; j++) {
				max = Math.max(max, dp[j] + dp[i - j]);
			}
			dp[i] = max;
		}

		return dp[n];
	}

	/**
	 * Top down memoization: Normal recursion. first checks if a solution
	 * already exists.
	 */

	public static int topDownRodCut(int n, int[] p) {
		if (dpTopDown[n] != -1)
			return dpTopDown[n];

		if (n == 1) {
			dpTopDown[1] = p[1];
			return p[1];
		}

		// find max(p[n],p[i]+p[n-i]) 1 <= i <= n
		int max = p[n];
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, p[i] + topDownRodCut(n - i, p));
		}
		dpTopDown[n] = max;
		return dpTopDown[n];
	}

	/**
	 * Extended bottom up rod cut. Computes a solution matrix, which indicates
	 * the optimum position to cut the rod.
	 */
	
	public static int extendedBottomUpRodCut(int n, int[] p){
		int[] dp = new int[n+1];
		int[] sol = new int[n+1];
		
		for(int i = 1; i <= n; i++){
			int max = p[i];
			sol[i] = i;
			for(int j = 1; j <= i/2; j++ ){
				int newMax = Math.max(max, dp[j]+dp[i-j]);
				if(newMax > max){
					sol[i] = j;
					max = newMax;
				}
			}
			dp[i] = max;
		}
		
		/*
		for(int i =0 ;i <=n;i++)
			System.out.print(" "+ sol[i]);
		System.out.println();
		printSol(n,sol);
		*/
		return dp[n];
	}
	
	/**
	 * Print solution
	 */
	
	public static void printSol(int i, int[] s){
		
		if(i==1){
			System.out.print(" "+s[i]);
			return;
		}
		
		if(s[i]==i){
			System.out.print(" "+s[i]);
			return;
		}
		
		printSol(i-1,s);
		System.out.print(" "+s[i]);
	}
}
