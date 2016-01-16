/**
N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.

Example:

Input : [0 1 0 1]
Return : 4

Explanation :
	press switch 0 : [1 0 1 0]
	press switch 1 : [1 1 0 1]
	press switch 2 : [1 1 1 0]
	press switch 3 : [1 1 1 1]
**/


public class Solution {
    public int bulbs(ArrayList<Integer> a) {
        int n = a.size();
        int[] arr = new int[n];
        
        int x = 0;
        for(int i= n-1; i>=0; i-- ){
            arr[i] = x;
            
            if(a.get(i) == 1 )
                x++;
        }
        
      //  System.out.println(Arrays.toString(arr));
      
        int state = 1;
        int count = 0;
        /**
        for(int i = 0; i < n; i++){
            if(a.get(i) == 1 && state == 1)
                continue;
            else{
                int onBulbs = 0;
                if(state == 1)
                    onBulbs = arr[i];
                else
                    onBulbs = n -1 - i - arr[i];
                
                if((onBulbs == (n-1-i)) && (state==1) &&(a.get(i)==1))
                    return count;
                else
                    count++;
                state = (state == 1)? 0 : 1;
            }
        }
        **/
        
        for(int i =0; i < n;i++){
            if((a.get(i)==1 && state == 1 ) || (a.get(i)==0 && state == 0))
                    continue;
            else{
                count++;
                if(state == 1){
                    state = 0;
                    int onBulbs = n -1 -i - arr[i];
                    if(onBulbs == (n-1-i))
                        return count;
                }else{
                    int onBulbs = arr[i];
                    if(onBulbs == (n-1-i))
                        return count;
                    state = 1;
                    //count++;
                }
            }
        }
        return count;    
    }
}

/**
Another solution:
int bulbs(vector<int> &A) {
    int state= 0, ans = 0;
    for (int i = 0;i < A.size();i++) {
	    if (A[i] == state) {
		    ans++;
		    state = 1 - state;
	    }
    }
		    return ans;
}
**/
