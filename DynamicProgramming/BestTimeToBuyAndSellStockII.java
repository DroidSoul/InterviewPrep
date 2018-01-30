public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 0) {
                max += A[i] - A[i - 1];
            }
        }
        return max;
    }
}