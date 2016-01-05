package trees;

import java.util.HashMap;

public class Trie {

	static TrieNode root;

	public static void main(String[] args) {
		root = new TrieNode();
		/*
		 * addWord("the"); addWord("there"); addWord("their"); addWord("a");
		 * addWord("answer"); addWord("any"); addWord("by"); addWord("bye");
		 * System.out.println(searchPrefix("an"));
		 * System.out.println(searchPrefix("th"));
		 * System.out.println(searchPrefix("there"));
		 * System.out.println(searchWord("th"));
		 * System.out.println(searchWord("their"));
		 */
		addWord("zebra");
		addWord("dog");
		addWord("dog");
		addWord("duck");
		addWord("dove");
		System.out.println(shortestPrefix("zebra"));
		System.out.println(shortestPrefix("dog"));
		System.out.println(shortestPrefix("duck"));
		System.out.println(shortestPrefix("dove"));
	}

	public static void addWord(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode child;
			if (children.containsKey(c)) {
				child = children.get(c);
				child.frequency = child.frequency + 1;
				children.put(c, child);
			} else {
				child = new TrieNode();
				child.c = c;
				child.frequency = 1;
				children.put(c, child);
			}

			children = child.children;

			// set leaf node
			if (i == word.length() - 1)
				child.isWord = true;
		}

	}

	public static boolean searchWord(String word) {
		TrieNode node = searchNode(word);
		if (node != null && node.isWord)
			return true;
		return false;
	}

	public static boolean searchPrefix(String prefix) {
		TrieNode node = searchNode(prefix);
		if (node != null)
			return true;
		return false;
	}

	private static TrieNode searchNode(String str) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode child = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				child = children.get(c);
				children = child.children;
			} else {
				return null;
			}

		}
		return child;
	}

	/**
	 * Find shortest unique prefix to represent each word in the list.
	 * 
	 * Example:
	 * 
	 * Input: [zebra, dog, duck, dove] Output: {z, dog, du, dov} 
	 */
	
	public static String shortestPrefix(String str) {
		HashMap<Character, TrieNode> children = root.children;
		int index = 0;
		int minFreq = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// System.out.println("char c 1 = "+c);
			// System.out.println("char c = "+c+" "+children.containsKey(c));
			TrieNode child = null;
			if (children.containsKey(c)) {// since the word exists, it will

				child = children.get(c);
				if (child.frequency < minFreq) {
					minFreq = child.frequency;
					index = i;
				}
			}
			children = child.children;
		}

		return str.substring(0, index + 1);
	}

}
