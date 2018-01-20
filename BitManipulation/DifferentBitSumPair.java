public class Solution {
    public int cntBits(int[] A) {
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < 31; i++) {
            int zeroSum = 0;
            int oneSum = 0;
            for (int num : A) {
                if (((1 << i) & num) != 0) {
                    oneSum++;
                }
                else {
                    zeroSum++;
                }
            }
            res += (int)((2L * zeroSum * oneSum) % mod);
            res %= mod;
        }
        return res;
    }
}