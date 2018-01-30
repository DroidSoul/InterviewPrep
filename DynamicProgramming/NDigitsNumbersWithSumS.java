public class Solution {
    public int solve(int A, int B) {
        int mod = 1000000007;
        int[][] table = new int[A + 1][B + 1];
        table[0][0] = 1;
        table[1][0] = 1;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                    for (int k = 0; k <= 9; k++) {
                        int x = i - 1;
                        int y = j - k;
                        if (x == 0 && y < 0 || x > 0 && y <= 0) {
                            continue;
                        }
                        table[i][j] += table[x][y];
                        table[i][j] %= mod;
                    }
            }
        }
        return table[A][B];
    }
}