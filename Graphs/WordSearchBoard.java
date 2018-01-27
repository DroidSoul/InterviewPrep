public class Solution {
    public int exist(String[] A, String B) {
        if (A == null || A.length == 0 || A[0].length() == 0) {
            return 0;
        }
        if (B == null || B.length() == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                if (helper(A, i, j, 0, B)) {
                    return 1;
                }
            }
        }
        return 0;
    }
    private boolean helper(String[] A, int row, int col, int index, String B) {
        if (index == B.length()) {
            return true;
        }
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length() || B.charAt(index) != A[row].charAt(col)) {
            return false;
        }
        return helper(A, row + 1, col, index + 1, B) || helper(A, row - 1, col, index + 1, B) || helper(A, row, col + 1, index + 1, B) || helper(A, row, col - 1, index + 1, B);
    }
}