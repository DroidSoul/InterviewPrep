public class Solution {
    public int wordBreak(String A, String[] B) {
        if (A == null || A.length() == 0) {
            return 1;
        }
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String str : B) {
            set.add(str);
            maxLen = Math.max(maxLen, str.length());
        }
        int[] dp = new int[A.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= Math.min(maxLen, i); j++) {
                if (dp[i - j] == 1 && set.contains(A.substring(i - j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[A.length()];
    }
}