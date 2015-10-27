/*
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10]
Return : [-1, 4, -1, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]


The naive solution to this problem would be O(n^2)
Observe that at A[i-1]
All elements with index smaller than i - 1 and greater than A[i-1] are useless to us because they would never qualify for 
G[i], G[i+1], ...

Hence we can come up with stack as a solution as we need only the element most recently pushed or the number smaller than that.
Intermediate numbers are not needed.
*/

class Solution{
 public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: arr){
            if(s.isEmpty()){
                res.add(-1);
               
            }else{
               
                    
                    while(!s.isEmpty()){
                        int j = s.pop();
                        if(j<i){
                            res.add(j);
                            s.push(j);
                            break;
                        }
                    }
                    if(s.isEmpty())
                       res.add(-1);
                
            }
            s.push(i);
        }
        return res;
    }
	
}
/*
Similarly, the give question:
Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]
Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]
Output : [-1, -1, -1]
*/
class Solution{
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    Stack<Integer> s = new Stack<Integer>();
	    ArrayList<Integer> res = new ArrayList<>();
	    for(int i = a.size()-1;i>=0;i--){
	        if(s.isEmpty()){
	            res.add(0,-1);
	        }else{
	            while(!s.isEmpty()){
	                int num = s.pop();
	                if(num>a.get(i)){
    	                res.add(0,num);
	                    s.push(num);
	                    break;
	                }
	            }
	            if(s.isEmpty())
	                res.add(0,-1);
	        }
	        s.push(a.get(i));
	    }
	    return res;
	}
}
