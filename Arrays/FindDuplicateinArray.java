public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int n = a.size();
	    int slow = n;
	    int fast = n;
	    do {
	        slow = a.get(slow - 1);
	        fast = a.get(a.get(fast - 1) - 1);
	    } while (slow != fast);
	    slow = n;
	    while (slow != fast) {
	        slow = a.get(slow - 1);
	        fast = a.get(fast - 1);
	    }
	    return slow;
	}
}