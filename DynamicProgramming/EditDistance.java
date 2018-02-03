public class Solution {
    public int minDistance(String A, String B) {
        if (A.length() == 0) {
      return B.length();
    }
    if (B.length() == 0) {
      return A.length();
    }
    int[][] dp = new int[A.length() + 1][B.length() + 1];
    for (int i = 0; i <= A.length(); i++) {
      for (int j = 0; j <= B.length(); j++) {
        if (i == 0) {
          dp[i][j] = j;
        }
        else if (j == 0) {
          dp[i][j] = i;
        }
        else {
          dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ?
                     dp[i - 1][j - 1] : 
                     Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    return dp[A.length()][B.length()];
    }
}