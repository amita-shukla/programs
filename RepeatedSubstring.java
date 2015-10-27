/*=================================================================================================================
REPEATSTR
Given a string, 
Find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

=================================================================================================================
*/
public class Solution {
	public int lengthOfLongestSubstring(String a) {
	   HashMap<Character,Integer> hm = new HashMap<>();
	   int start=0, maxLen=0;
	   for(int i=0;i<a.length();i++){
	       char c = a.charAt(i);
	       if(hm.containsKey(c) && hm.get(c)>=start){
	           int len = i-start;
	           if(len>maxLen)
	                maxLen = len;
	           start = hm.get(c)+1;
	       }
	       hm.put(c,i);
	   }
	   int len = a.length()-start;
	   if(len>maxLen)
	        maxLen = len;
	   return maxLen;
    }
}

