public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j : A) {
                if (((1 << i) & j) != 0) {
                    sum++;
                }
            }
            if ((sum % 3) != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}