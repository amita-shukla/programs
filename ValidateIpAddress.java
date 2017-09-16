package me.amitashukla;

import java.util.ArrayList;

/**
 * Created by amita on 16/9/17.
 */
public class ValidateIpAddress {
    public static ArrayList<String> restoreIpAddresses(String a) {
        if(a.length()<4 || a.length()>12)
            return null;
        StringBuilder sb =  new StringBuilder(a);
        //index of prvs point
        int index = -1;
        ArrayList<String> res =  placePoint(sb,0, index, new ArrayList<>());
        return  res;
    }

    private static ArrayList<String> placePoint(StringBuilder sb, int pntCnt, int index, ArrayList<String> partial) {
        if(pntCnt==3){
            if(validate(sb,index+1,sb.length()-1)) {
                partial.add(sb.toString());

            }

            return partial;
        }

        for(int i = index+2, count = 1;i<sb.length() && count<=3; i++){
            if(validate(sb,index+1,i-1)){
                StringBuilder sb1 = new StringBuilder(sb);
                sb1.insert(i,".");
                placePoint(sb1,pntCnt+1,i,partial);
            }
            count++;
        }
        return partial;
    }

    private static boolean validate(StringBuilder sb, int index, int i) {
        //if first index char = 0 then validate false
        if(sb.charAt(index)-'0'==0 && index!=i){
            return false;
        }

        int place = i-index;
        int sum = 0;
        for (int j=index;j<=i;j++){
            sum += ((sb.charAt(j)-'0')*Math.pow(10,place));
            if(sum>255){
                return false;
            }
            place--;
        }
        return true;
    }

    public static void main(String[] args) {
     /*   StringBuilder sb = new StringBuilder("ab");
        sb.insert(0,",");
        System.out.println(sb.toString());*/
     String a = "1111";
     String b = "25525511135";
     String c = "25011255255";
     String d = "0";
        System.out.println(restoreIpAddresses(c));
    }

}
