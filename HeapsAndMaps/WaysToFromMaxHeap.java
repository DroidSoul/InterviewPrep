import java.math.BigInteger;
public class Solution {
    public int solve(int A) {
        int mod = 1000000007;
        if (A <= 2) {
            return 1;
        }
        int[] res = new int[A + 1];
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i<= A; i++) {
            int k = base2(i);
            int rem = 1 + i - exp2(k);
            int left = exp2(k - 1) - 1 + Math.min(exp2(k - 1), rem);
            int right = i - 1 - left;
            res[i] = (int)((((helper(i - 1, left, mod) * res[left]) % mod) * res[right]) % mod);
        }
        return res[A];
    }
    public long helper(int n, int k, int mod) {
        BigInteger res = BigInteger.valueOf(1);
        int first = k;
        int second = k;
        while (first > 0) {
            res = res.multiply(BigInteger.valueOf(n--));
            first--;
        }
        while (second > 0) {
            res = res.divide(BigInteger.valueOf(second--));
        }
        return (res.mod(BigInteger.valueOf(mod))).longValue();
    }
    public int base2(int n) {
        int res = 0;
        while (n > 0) {
            res++;
            n >>= 1;
        }
        return res - 1;
    }
    public int exp2(int k) {
        return 1 << k;
    }
}