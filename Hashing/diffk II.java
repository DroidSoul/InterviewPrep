public class Solution {
	public int diffPossible(final List<Integer> a, int b) {
	    if (a == null || a.size() == 0) {
	        return 0;
	    }
	    Set<Integer> set = new HashSet<>();
	    for (int val : a) {
	        if (set.contains(val)) {
	            return 1;
	        }
	        set.add(val - b);
	        set.add(val + b);
	    }
	    return 0;
	}
}