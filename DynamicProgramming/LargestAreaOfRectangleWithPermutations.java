public class Solution {
    public int solve(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    count[i][j] = i == 0 ? 1 : count[i - 1][j] + 1;
                }
                else {
                    count[i][j] = 0;
                }
            }
        }
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[j] = count[i][j];
            }
            Arrays.sort(arr);
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (n - j) * arr[j]);
            }
        }
        return max;
        
    }
}