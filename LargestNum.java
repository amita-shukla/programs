/**
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
**/
public class Solution{
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
	    List<Integer> b = new ArrayList<Integer>(a);
	    
	    Collections.sort(b, new Comparator<Integer>(){
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            
            String s1 = o1.toString().concat(o2.toString());
		    String s2 = o2.toString().concat(o1.toString());
           
            long n1= Long.parseLong(s1);
            long n2= Long.parseLong(s2);
		
			if (n1>n2)
				return -1;
			else if (n1==n2)
				return 0;
			else
				return 1;
	        }
	        
	    });
	    
	    StringBuilder answer = new StringBuilder();
	    int cons0=0;
	    for(int i=0; i<b.size();i++){
	        if(b.get(i)==0){
	            cons0++;
	        }
	    	answer.append(b.get(i));
	    }
	    if(cons0==b.size())
	        return String.valueOf(0);
	    return answer.toString();
	}
	
	

}

