/*Given a number N, find all factors of N.

Example:

if N = 6,

factors = {1, 2, 3, 6}

Make sure the returned array is sorted.

Pseudo code for the finding the factors of a number:
	A = emptyList
	for i=1 to sqrt(n)
		if(n%i==0)
			A.add(i);
			A.add(n/i);

But the above code will add the sqrt(n) twice:
once in the statement A.add(i); and other time A.add(n/i);
therefore the modified algorithm is:

	A = emptyList
	for i=1 to sqrt(n)
		if(n%i==0)
			A.add(i);
			if(i != sqrt(n))
				A.add(n/i);

				
To give sorted result:
*/
public class Solution {
	public ArrayList<Integer> allFactors(int a) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int sqrt = (int)Math.sqrt(a);
	    int i=1;
	    while(i<= sqrt){
	        if((a%i)==0){
	            list.add(i);
	        }
	        i++;
	    }
	    
	    int j=list.size()-1;
	    while(j>=0){
	        if(a/(list.get(j))!=list.get(j)){
	            list.add(a/(list.get(j)));
	        }
	        j--;
	    }
	    return list;
	}
}

