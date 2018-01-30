public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestSubsequenceLength(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] inc = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }
        int[] dec = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = A.length - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, inc[i] + dec[i] -1);
        }
        return max;
        
        
    }
}