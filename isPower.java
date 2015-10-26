/*
Check if a Number is a perfect power.
i.e., for given an integer X, return true if it can be written in the form X=A^B, where A and B are integers.

-----------------x
Q.
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. 
A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

------------------x
For every possible value of B, check for every possible value of A.

Note:- A sieve[Intger.MAX_VALUE] or sieve[X+1] gives out of memory error if
		X=10240000
*/		
class MySolution{
public boolean isPower(int X) {
        if(X==0)
            return false;
        if(X==1)
            return true;
        int B = 2;
        while(B<32){
            int limit = (int) Math.pow(Integer.MAX_VALUE,(1.0/B));
           
            for(int A=2; A<= limit; A++){
                int val = ((int) Math.pow(A,B));
           
                if(X==val){
           
                    return true;
                }
            }
            B++;
        }
        return false;
    }
 }
