public class Solution {
    public int numDecodings(String A) {
        if (A == null || A.length() == 0 || A.charAt(0) == '0') {
            return 0;
        }
        if (A.length() <= 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 2; i <= A.length(); i++) {
            int third = A.charAt(i - 1) != '0' ? second : 0;
            int temp = Integer.valueOf(A.substring(i - 2, i));
            if (temp >= 10 && temp <= 26) {
                third += first;
            }
            first = second;
            second = third;
        }
        return second;
        
    }
}