public class Solution {
	public long reverse(long a) {
	    long res = 0;
	    for (int i = 0; i < 32; i++) {
	        if ((a & 1) != 0) {
	            res += 1L << (31 - i);
	        }
	        a >>= 1;
	    }
	    return res;
	}
}