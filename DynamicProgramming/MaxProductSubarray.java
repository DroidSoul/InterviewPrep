public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int localMin = A[0];
        int localMax = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = localMin;
            localMin = Math.min(A[i], Math.min(localMin * A[i], localMax * A[i]));
            localMax = Math.max(A[i], Math.max(temp * A[i], localMax * A[i]));
            max = Math.max(max, localMax);
        }
        return max;
    }
}