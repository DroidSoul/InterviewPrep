public class Solution {
	public int numSetBits(long a) {
	    int res = 0;
	    while (a > 0) {
	        res += a & 1;
	        a >>= 1;
	    }
	    return res;
	}
}