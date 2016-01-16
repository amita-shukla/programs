/**
 *  Sort the mice_position array m[].
    Sort the hole_position array h[].
    find the maximum of |m[i] - h[i]|.
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

