package me.amitashukla;

import java.util.ArrayList;

/**
 * Created by amita on 16/9/17.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

 Example:

 Given “25525511135”,

 return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)

 Brute force works here.

 Essentially you have to place 3 dots in the given string.

 Try out all the possible combinations for the 3 dots.

 Corner case:

 25011255255

 25.011.255.255 is not valid as 011 is not valid.
 25.11.255.255 is not valid either as you are not allowed to change the string.
 250.11.255.255 is valid.
 */
public class ValidateIpAddress {
    public static ArrayList<String> restoreIpAddresses(String a) {
        //an ip address is invalid if its length <4 or >12
        if(a.length()<4 || a.length()>12)
            return null;
        StringBuilder sb =  new StringBuilder(a);
        //start by marking the dots between every digit
        //index of prvs point
        int index = -1;
        ArrayList<String> res =  placePoint(sb,0, index, new ArrayList<>());
        return  res;
    }

    /**
         *
        * @param sb The running string
        * @param pntCnt the number of dots inserted in the string so far
        * @param index the index of last dot placed
        * @param partial the array list containing the solutions so far
        * @return
     */     
    private static ArrayList<String> placePoint(StringBuilder sb, int pntCnt, int index, ArrayList<String> partial) {
         //if 3 dots have been placed, return partial after validating the rest of the string
        if(pntCnt==3){
            if(validate(sb,index+1,sb.length()-1)) {
                partial.add(sb.toString());

            }

            return partial;
        }

        //if pntCnt < 3 iterate from the last index of dot to upto 3 digits. a dot must be put after atmost 3 digits
        //i=index+2 coz index = dot index, index+1=index of digit after the dot index+2= index just after the next digit,
        // where we can put the next dot
        for(int i = index+2, count = 1;i<sb.length() && count<=3; i++){
            //validate the string from index+1 (remember, there is a dot at index) to i-1 (will be placing the dot at
            // index i)
            if(validate(sb,index+1,i-1)){
                //if validate=true, create a new string and insert the dot
                StringBuilder sb1 = new StringBuilder(sb);
                sb1.insert(i,".");
                //recurse further for placing the next dot
                placePoint(sb1,pntCnt+1,i,partial);
            }
            //if validation fails, continue with the same sb
            count++;
        }
        return partial;
    }

    private static boolean validate(StringBuilder sb, int index, int i) {
        //an ip can't start with 0 unless it is the only digit
        //(refer the example above)
        if(sb.charAt(index)-'0'==0 && index!=i){
            return false;
        }

        //atoi
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

/**
ANOTHER SOLUTION
public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) return new ArrayList<>();
        return getParts(s, 3);
    }
    
    private ArrayList<String> getParts(String s, int dots) {
        ArrayList<String> parts = new ArrayList<>();
        if (dots == 0) {
            if (isValidOctet(s)) {
                parts.add(s);
            }
            return parts;
        }
        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            String octet = s.substring(0, i);    
            if (isValidOctet(octet)) {
                for (String part : getParts(s.substring(i), dots - 1)) {
                    parts.add(octet + "." + part);
                }
            }
        }
        return parts;
    }
    
    boolean isValidOctet(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int octet = Integer.parseInt(s);
        return octet < 256;
    }
    
**/
}
