package greedy;

import java.util.*;

public class GroupPeopleTogether {

	public static final int MOD = 10000003;

	public static void main(String[] args) {
		String s = "..xx...xx..xx..xxx...";
		String s2 = "....x..xx...x..";
		System.out.println(minMoves(s2.toCharArray()));
	}

	public static int minMoves(char[] seats) {
		Deque<int[]> dq = new ArrayDeque<>();

		int n = seats.length;

		int j = 0;

		while (j < n) {
			while (j < n && seats[j] == '.')
				j++;
			if (j == n)
				break;
			int startInd = j;
			while (j < n && seats[j] == 'x')
				j++;
			int endInd = j - 1;

			dq.addLast(new int[] { startInd, endInd });
		}

		int count = 0;

		while (dq.size() > 1) {
			int[] left = dq.peekFirst();
			int[] right = dq.peekLast();

			int lenLeft = left[1] - left[0] + 1;
			int lenRight = right[1] - right[0] + 1;

			if (lenLeft <= lenRight) {
				left = dq.pollFirst();
				count = (count % MOD + (lenLeft % MOD
						* (dq.peekFirst()[0] - left[1] - 1) % MOD)
						% MOD)
						% MOD;
				dq.peekFirst()[0] -= lenLeft;
			} else {
				right = dq.pollLast();
				count = (count % MOD + (lenRight % MOD
						* (right[0] - dq.peekLast()[1] - 1) % MOD)
						% MOD)
						% MOD;
				dq.peekLast()[1] += lenRight;
			}
		}
		return count;
	}

}
