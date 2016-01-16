/**
 *  
	There are N Mice and N holes are placed in a straight line. 
	Each hole can accomodate only 1 mouse. 
	A mouse can stay at his position, move one step right from x to x + 1, 
	or move one step left from x to x − 1. 
	Any of these moves consumes 1 minute.
	Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 
 	1. Sort the mice_position array m[].
    2. Sort the hole_position array h[].
    3. find the maximum of |m[i] - h[i]|.
    
 **/
public class MiceAndHoles {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        
        int l = Math.min(a.size(),b.size());
        int max = 0;
        for(int  i = 0; i < l; i++){
            int x = a.get(i);
            int y = b.get(i);
            
            int diff = Math.abs(x-y);
            
            if(diff> max)
                max = diff;
        }
        
        return max;
    }
}

