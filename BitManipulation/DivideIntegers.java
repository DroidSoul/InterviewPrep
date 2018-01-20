public class Solution {
    public int divide(int A, int B) {
        if (B == 0) {
            return Integer.MAX_VALUE;
        }
        if (A == 0) {
            return 0;
        }
        int res = 0;
        boolean neg = (((A ^ B) >> 31) & 1) == 1;
        if (A == Integer.MIN_VALUE) {
            if (B == -1) {
                return Integer.MAX_VALUE;
            }
            if (B == Integer.MIN_VALUE) {
                return 1;
            }
            res++;
            A += Math.abs(B);
        }
        if (B == Integer.MIN_VALUE) {
            return 0;
        }
        A = Math.abs(A);
        B = Math.abs(B);
        int digit = 0;
        while ((A >> 1) >= B) {
            B <<= 1;
            digit++;
        }
        while (digit >= 0) {
            if (A >= B) {
                res += 1 << digit;
                A -= B;
            }
            B >>= 1;
            digit--;
        }
        return neg ? -res : res;
    }
}