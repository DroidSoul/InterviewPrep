public class Solution {
	public int sqrt(int a) {
	    if (a < 0) {
	        return -1;
	    }
	    if (a == 0) {
	        return 0;
	    }
	    if(a == 1) {
	        return 1;
	    }
	    int left = 1;
	    int right = a / 2;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (mid > a / mid) {
	            right = mid - 1;
	        }
	        else if (mid + 1 <= a / (mid + 1)) {
	            left  = mid + 1;
	        }
	        else {
	            return mid;
	        }
	    }
	    return -1;
	}
}