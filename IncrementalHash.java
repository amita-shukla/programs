/**
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once
and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
**/

public class Solution {
  
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    if (b == null)
			return new ArrayList<Integer>();
		HashMap<String, Integer> hm = new HashMap<>();
		// fill map
		for (int i = 0; i < b.size(); i++) {
			String word = b.get(i);
			if (hm.containsKey(word)) {
				hm.put(word, hm.get(word) + 1);
			} else {
				hm.put(word, 1);
			}
		}

		int wsize = b.get(0).length();
		int lsize = b.size();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i <= (a.length() - (lsize * wsize)); i++) {
			HashMap<String, Integer> current = new HashMap<>();
			int j;
			for (j = i; j < (i+(lsize * wsize)); j += wsize) {
				String word = a.substring(j, j + wsize);
				if (hm.containsKey(word)) {
					if (current.containsKey(word)) {
						current.put(word, current.get(word) + 1);
						if (current.get(word) > hm.get(word)) {
							break;
						}
					} else {
						current.put(word, 1);
					}
				}else{
					break;
				}
			}
			if (j == (i+(lsize*wsize)) && hm.equals(current)) {
				res.add(i);
			}
		}
		return res;
	}
}
