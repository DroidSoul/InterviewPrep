public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = A[0];
        for (int i = 1; i < A.length; i++) { 
            max = Math.max(A[i] - min, max);
            min = Math.min(min, A[i]);
        }
        return max;
    }
}