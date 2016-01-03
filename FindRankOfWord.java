import java.util.Arrays;

public class FindRankOfWord {

	/**
	 * @param args
	 */

	public static final int M = 1000003;

	public static void main(String[] args) {
		String input = "dcba";
		int rank = 1;
		rank = findRank(input);
		System.out.println(rank);
	}

	private static int findRank(String s) {
		if(s.length()==1)
			return 1;
		
		String a = alphabetize(s);
		int nBefore = a.indexOf(s.charAt(0));//no. of chars in a before first char in s
		

		String rem = s.substring(1);
		
		int rank = findRank(rem);
		
		rank += nBefore*factorial(s.length()-1);
		
		return rank;
	}

	public static int findRankWrong(String s) {
		if (s == "" || s.length() == 1)
			return 1;

		int rank = 0;

		String alphabetized = alphabetize(s);
		System.out.println("alphabetized= "+ alphabetized);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == alphabetized.charAt(i))
				continue;

			char c = s.charAt(i);
			int pos = alphabetized.indexOf(c);
			int difference = Math.abs(i - pos);

			rank += difference * factorial(s.length() - i - 1);
		}

		return rank;
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		int fact = 1;
		while (n > 1) {
			fact = ((fact % M) * (n % M)) % M;
			n--;
		}
		return fact%M;
	}

	private static String alphabetize(String s) {
		char[] string = s.toCharArray();
		Arrays.sort(string);
		
		return String.valueOf(string);
	}

}
