public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : A) {
            sum = sum > 0 ? sum + val : val;
            max = Math.max(max, sum);
        }
        return max;
    }
}