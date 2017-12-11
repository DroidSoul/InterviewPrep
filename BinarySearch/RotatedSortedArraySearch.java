public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    if (a == null || a.size() == 0) {
	        return -1;
	    }
	    int left = 0;
	    int right = a.size() - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (a.get(mid) == b) {
	            return mid;
	        }
	        if (a.get(left) <= a.get(mid)) {
	            if (a.get(left) <= b && b < a.get(mid)) {
	                right = mid - 1;
	            }
	            else {
	                left = mid + 1;
	            }
	        }
	        else {
	            if (a.get(mid) < b && b <= a.get(right)) {
	                left = mid + 1;
	            }
	            else {
	                right = mid - 1;
	            }
	        }
	    }
	    return -1;
	    
	}
}