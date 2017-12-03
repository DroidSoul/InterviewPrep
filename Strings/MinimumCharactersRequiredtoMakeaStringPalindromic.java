public class Solution {
    public int solve(String A) {
        if (A == null || A.length() <= 1) {
            return 0;
        }
        for (int j = A.length(); j >= 2; j--) {
            if (isTrue(A.substring(0, j))) {
                return A.length() - j;
            }
        }
        return A.length() - 1;
    }
    public boolean isTrue(String str) {
        if (str.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}