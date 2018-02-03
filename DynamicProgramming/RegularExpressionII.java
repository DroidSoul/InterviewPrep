public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        if (B == null || B.length() > 0 && B.charAt(0) == '*') {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < B.length(); i += 2) {
            if (B.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (B.charAt(j - 1) != '*') {
                    if (dp[i - 1][j - 1] == 1 && isMatch(A.charAt(i - 1), B.charAt(j - 1))) {
                        dp[i][j] = 1;
                    }
                }
                else {
                    if (dp[i][j - 2] == 1 || dp[i - 1][j] == 1 && 
                        isMatch(A.charAt(i - 1), B.charAt(j - 2))) {
                            dp[i][j] = 1;
                        }
                }
            }
        }
        return dp[A.length()][B.length()];
    }
    public boolean isMatch(char p, char q) {
        return p == q || q == '.';
    }
}