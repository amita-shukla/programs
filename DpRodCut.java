import java.util.Arrays;

/**
 * Given a rod of length n and a table of prices, Find the maximum obtainable
 * revenue.
 * 
 * @author Amita
 * 
 */

public class DpRodCut {
	static int[] dpTopDown;

	public static void main(String args[]) {
		int[] p = { -1, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int n = 4;
		System.out.println(bottomUpRodCut(n, p));

		dpTopDown = new int[n + 1];
		Arrays.fill(dpTopDown, -1);
		System.out.println(topDownRodCut(n, p));

		// print dpTopDown
		for (int i = 0; i < dpTopDown.length; i++)
			System.out.println(dpTopDown[i]);
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
}
