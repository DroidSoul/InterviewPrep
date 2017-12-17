public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    if (a == null || a.size() == 0) {
	        return 0;
	    }
	    int m = a.size();
	    int n = a.get(0).size();
	    if (b < a.get(0).get(0) || b > a.get(m - 1).get(n - 1)) {
	        return 0;
	    }
	    int top = 0;
	    int bottom = m - 1;
	    while (top <= bottom) {
	        int mid = top + (bottom - top) / 2;
	        if (a.get(mid).get(0) == b) {
	            return 1;
	        }
	        if (a.get(mid).get(0) < b) {
	            top = mid + 1;
	        }
	        else {
	            bottom = mid - 1;
	        }
	    }
	    int left = 1;
	    int right = n - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (a.get(bottom).get(mid) == b) {
	            return 1;
	        }
	        if (a.get(bottom).get(mid) < b) {
	            left = mid + 1;
	        }
	        else {
	            right = mid - 1;
	        }
	    }
	    return 0;
	    
	}
}