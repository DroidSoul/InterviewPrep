public class Solution {
	public int lengthOfLongestSubstring(String a) {
	    if (a == null || a.length() == 0) {
	        return 0;
	    }
	    int res = 1;
	    int[] table = new int[256];
	    Arrays.fill(table, -1);
	    int left = 0;
	    for (int right = 0; right < a.length(); right++) {
	        if (table[a.charAt(right)] >= left) {
	            res = Math.max(res, right - left);
	            left = table[a.charAt(right)] + 1;
	        }
	        table[a.charAt(right)] = right;
	    }
	    return Math.max(res, a.length() - left);
	}
}