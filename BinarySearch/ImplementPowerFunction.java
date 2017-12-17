public class Solution {
	public int pow(int x, int n, int d) {
	    
	    if (d == 0) {
	        return Integer.MAX_VALUE;
	    }
	    if (x == 0 || n < 0 || d == 1) {
	        return 0;
	    }
	    if (n == 0) {
	        return 1;
	    }
	    if (x < 0) {
	        return n % 2 == 0 ? pow(-x, n, d) : d - pow(-x, n, d);
	    }
	    x %= d;
	    int y = pow((int)(((long)x * x) % d), n / 2, d);
	    if (n % 2 == 0) {
	        return y;
	    }
	    return (int)(((long) y * x) % d);
	}
}