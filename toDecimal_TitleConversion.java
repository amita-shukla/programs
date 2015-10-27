/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
	
	
My solution:
*/
public class Solution {
    static HashMap<Integer, Character> hm;
	public String convertToTitle(int num) {
	    hm =  new HashMap<>();
	    for(int i=0;i<26;i++){
	        Character c = (char)('A'+i);
	        hm.put(i+1,c);
	    }
	//    System.out.println(hm.toString());
	    int base=26;
	    StringBuilder title = new StringBuilder();
	    while(num>0){
	        num--;
	        int rem = num%base;
	        title.append(hm.get(rem+1));
	        num = num/base;
	    }
	   // title.append(hm.get(num));
	    return title.reverse().toString();
	}


//Or:

public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0){
        int r = n % 26; 
        n = n/26;
        if (r != 0){
            sb.append((char)(r - 1 + 'A')); //e.g if n=27, r=1, append(A)
        } else {
            sb.append('Z'); //e.g n=26, r=0, append(Z), take other examples like 52=AZ, 676=YZ
            n--;
        }

    }
    return sb.reverse().toString();
}
}
