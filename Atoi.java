/**
 Implement atoi to convert a string to an integer.
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters,
 no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values, I
 NT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */
public class AtoI {
    public static int atoi(String s){
        int num =0, start=0;
        boolean isNegative = false;
        while(start<s.length() && s.charAt(start)==' ')  start++;
//        if (start==s.length()) return 0;
        if(start<s.length() && s.charAt(start)=='-'){
            isNegative=true;
            start++;
        }else if(start<s.length() && s.charAt(start)=='+'){
            start++;
        }

        int end=start;
        while (end<s.length()){
            char c = s.charAt(end);
            if(!(c>='0'&&c<='9')) break;
            end++;
        }
        int numLen = end-start;
        if(numLen==0) return 0;
        for (int i = start; i < end; i++) {

            int k = s.charAt(i)-'0';
            //this kind of programming was done coz of the test case
            //s="-2147483648" (Integer.MIN_VALUE)
            if(!isNegative){
                num+=k*Math.pow(10,numLen-1);
                if(num==Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }else{
                num-=k*Math.pow(10,numLen-1);
                if(num==Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            numLen--;
        }
      //  if (isNegative) num*=-1;
        return num;

    }

    public static void main(String[] args) {
        System.out.println(atoi("12345678902"));
    }
}
