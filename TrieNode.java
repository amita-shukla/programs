package trees;

import java.util.HashMap;

public class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<>(); //store trie's children
	char c; //character that the trie holds
	boolean isWord; // if the current node is a word.
	int frequency; //no of words that begin have prefix upto this node.
	
}
