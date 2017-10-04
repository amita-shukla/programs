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


/**
 Given a string, find the length of the longest substring without repeating characters.
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
 "pwke" is a subsequence and not a substring.
 */

public class LongestSubsWithoutRepeat
{
    /**
     * Use a hashmap to maintain index of each character, keeping record of maxlength
     * As a character repeats, you are done with that window (i.e. from start to i),
     * increment start to index just after the repeated char (shift the window)
     * 
     * You take max of start and ind+1 so that you do not end up choosing an already parsed window
     * e.g "abba" as a repeats, the window wud have otherwise shifted to index 0, 
     *      even after processing repeated character b
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int start=0,maxLen=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i< s.length();i++){
            Character c = s.charAt(i);
            if(hm.containsKey(c)){
                int ind = hm.get(c);
                start = Math.max(start,ind+1);
            }
            maxLen = Math.max(maxLen,i-start+1);
            hm.put(c,i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}


