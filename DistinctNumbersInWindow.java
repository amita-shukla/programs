package me.amitashukla;

import java.util.*;

/**
 * Created by amita on 22/9/17.
 */
public class DistinctNumbersInWindow {
    public static ArrayList<Integer> dNumsIncomplete(List<Integer> inp, int k) {
        ArrayList<Integer> res  = new ArrayList<>();
        HashSet<Integer> hs  = new HashSet<>();
      /*  if(inp.size()>2){
            hs.add(inp.get(0));
            hs.add(inp.get)
        }*/
        for(int i=0,count=1;i<inp.size();i++,count++){
            hs.add(inp.get(i));
            if(i>k){
                System.out.println(hs);
                res.add(hs.size());
                hs.remove(inp.get(i-k+1));
                count=0;
            }

        }

        return res;
    }

    public static ArrayList<Integer> dNums(List<Integer> inp, int k) {
        ArrayList<Integer> res =  new ArrayList<>();
        HashMap<Integer,Integer> numCount = new HashMap<>();
        for (int i = 0, count = 1; i < inp.size(); i++, count++) {
            int num = inp.get(i);
            if (!numCount.containsKey(num)){
                numCount.put(num,1);
            }else{
                numCount.put(num,numCount.get(num)+1);
            }
            int prvs;
            if(count<k) {
                continue;
            }else if(count==k){
                res.add(numCount.size());
                prvs = inp.get(0);
            }else{
                //count>k
                res.add(numCount.size());
                prvs = inp.get(i-k+1);
            }
            if(numCount.get(prvs)==1){
                numCount.remove(prvs);
            }else{
                numCount.put(prvs,numCount.get(prvs)-1);
            }
        }
        return res;
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> inp, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        int n = inp.size();

        if(k>n)
            return ans;


        HashMap<Integer, Integer> hm = new HashMap<>();
        // for first window
        for (int i = 0; i < k; i++) {
            int num = inp.get(i);
            if (hm.containsKey(num))
                hm.put(num, hm.get(num) + 1);
            else
                hm.put(num, 1);
        }

        ans.add(hm.size());

        // for windows afterwards
        for (int i = 1; i <= (n - k); i++) {
            int prev = inp.get(i - 1);
            int next = inp.get(i + k - 1);
            if(hm.containsKey(next)){
                hm.put(next, hm.get(next)+1);
            }else{
                hm.put(next, 1);

            }

            hm.put(prev, hm.get(prev)-1); //reduce count

            if(hm.get(prev)==0)
                hm.remove(prev);

            ans.add(hm.size());
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 1, 3, 4, 3};
        System.out.println(dNums(Arrays.asList(arr),3));
    }
}
