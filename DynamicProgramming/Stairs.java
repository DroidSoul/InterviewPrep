public class Solution {
    public int climbStairs(int A) {
        if (A <= 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 2; i <= A; i++) {
            int temp = first;
            first = second;
            second += temp;
        }
        return second;
    }
}