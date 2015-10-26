/*==========================================================================================================
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different sub-sequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1

==========================================================================================================
*/
class Solution {
public int colorful(int num) {
	    String numS = String.valueOf(num);
	    HashSet<Integer> products = new HashSet<>();
	    //find all substrings
	    for(int i = 0; i < numS.length(); i++){
	        for( int j =1 ; j <= (numS.length()-i); j++){
	            String sub = numS.substring(i,i+j);
	            Integer subI = Integer.parseInt(sub);
	            int product = findProd(subI);
	            if(!products.add(product)){ //if product couldn't be added in the set
	                return 0;
	            }
	        }
	    }
	    return 1;
	}
	
	public static int findProd(int num){
	    int prod=1;
	    while(num!=0){
	        prod *= (num%10);
	        num=num/10;
	    }
	    return prod;
	}
}	
/*==========================================================================================================
NOte: 
1. substring method takes 1st parameter inclusive and second as exclusive.
 */
