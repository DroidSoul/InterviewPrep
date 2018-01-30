public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 0; i < A.length - 1; i++) {
            int diff = A[i + 1] - A[i];
            for (int j = 2; j >= 1; j--) {
                local[j] = Math.max(local[j] + diff, global[j - 1] + Math.max(diff, 0));
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[2];
    }
}