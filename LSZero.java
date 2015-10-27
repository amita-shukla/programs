/*
Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array. 
*/
public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        if(a==null)
            return a;
        //hm<sum, index>
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(0,-1);
        int start=-1, end=-1, maxLen=0;
        int sum=0;
        for(int i=0;i<a.size();i++){
            sum += a.get(i);
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }else{
                int len = i- hm.get(sum);
                if(len>maxLen){
                    maxLen = len;
                    start = hm.get(sum)+1;
                    end = i;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(start>=0 && end >= 0){
            for(int i = start; i<=end; i++){
                res.add(a.get(i));
            }
        }
        return res;
    }
}