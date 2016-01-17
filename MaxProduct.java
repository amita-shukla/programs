/**
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

**/

//My solutiion:
public class MaxProduct {
    public int maxp3(ArrayList<Integer> a) {
        if(a.size()==3)
            return a.get(0)*a.get(1)*a.get(2);
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        for(int i = 0; i < a.size(); i++ ){
            int num = a.get(i);
            if(num>=0)
                pos.add(num);
            else
                neg.add(num);
        }
        
        Collections.sort(neg,Collections.reverseOrder());
        Collections.sort(pos,Collections.reverseOrder());
        
        if(pos.size()== 0)
            return neg.get(0) * neg.get(1) * neg.get(2);
            
        if(pos.size() == 1)
            return pos.get(0)*neg.get(0)*neg.get(1);
        
        if(pos.size() == 2){
          //  int opt3 = pos.get(0)*pos.get(1)*neg.get(0);
          //  int opt4 = pos.get(0) * neg.get(0)*neg.get(1);
          //  return (opt3>opt4)?opt3:opt4;
          return pos.get(0)*neg.get(neg.size()-1)*neg.get(neg.size()-2);
        }
        
        //pos.size() > 2
        int opt1 = pos.get(0) * pos.get(1) * pos.get(2);
        
        if(neg.size() == 0 || neg.size()==1)
            return opt1;

        int opt2 = neg.get(neg.size()-1) * neg.get(neg.size()-2) * pos.get(0);
        
        if(opt2 > opt1)
            return opt2;
            
        return opt1;
    }
}
/** Simpler approach:

public class MaxProduct {

	
    public int maxp3(ArrayList<Integer> A) {
        
        if (A == null || A.size() < 3)
            return 0;
            
        Collections.sort(A);
        int n = A.size();
        
        int max;
        
        max = A.get(n - 3) * A.get(n - 2) * A.get(n - 1);
        
        max = Math.max(max, A.get(0) * A.get(1) * A.get(n - 1));
        
        return max;
        
    }
}
**/
