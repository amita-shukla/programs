/**

Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary
Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

**/

package graph;

import java.util.*;

public class WordConvert {

	public static void main(String[] args) {
		// String start = "hit";
		// String end = "cog";
		// String[] list = { "hot", "dot", "dog", "lot", "log" };
		String start = "bb";
		String end = "ab";
		String[] list = { "bb", "ab" };
		WordConvert wc = new WordConvert();
		int l = wc.ladderLength(start, end, Arrays.asList(list));
		System.out.println(l);
	}

	public int ladderLength(String start, String end, List<String> dictionary) {
		HashSet<String> dict = new HashSet<>(dictionary);

		int minLength = BFS(start, end, dict);

		return minLength;
	}

	public int BFS(String start, String end, HashSet<String> dict) {

		HashSet<String> visited = new HashSet<>();
		Queue<String> Q = new LinkedList<>();
		HashMap<String, String> parent = new HashMap<>();

		dict.add(end);
		// System.out.println(dict.toString());
		// Init source
		Q.add(start);
		visited.add(start);
		parent.put(start, null);

		// int count = 1;

		while (!Q.isEmpty()) {
			String s = Q.remove();

			// find neighbors: all words possible by changing a single char and
			// is contained in dict
			HashSet<String> neighbors = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < 26; j++) {
					StringBuilder temp = new StringBuilder(s);
					temp.setCharAt(i, (char) ('a' + j));

					if (dict.contains(temp.toString())) {
						// System.out.println("temp = "+temp);
						if (!visited.contains(temp.toString())) {
							// System.out.println(" s = " + s + " temp = " +
							// temp);

							neighbors.add(temp.toString());

						}
					}
				}
			}

			for (String v : neighbors) {
				visited.add(v);
				parent.put(v, s);
				Q.add(v);
			}
			
			// Q.addAll(neighbors);
		}
		

		return findMinDistance(start, end, parent);

	}

	public int findMinDistance(String start, String end,
			HashMap<String, String> parent) {
		
		if (start.equals(end))
			return 1;
		else if (!parent.containsKey(end))
			return 0;
		else
			return findMinDistance(start, parent.get(end), parent) + 1;
	}
}
