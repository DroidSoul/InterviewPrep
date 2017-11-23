public class Solution {
	public int lengthOfLastWord(final String a) {
	    if (a == null || a.length() == 0) {
	        return 0;
	    }
	    int i = a.length() - 1;
	    while (i >= 0 && a.charAt(i) == ' ') {
	        i--;
	    }
	    if (i < 0) {
	        return 0;
	    }
	    int j = i;
	    while (j >= 0 && a.charAt(j) != ' ') {
	        j--;
	    }
	    return i - j;
	}
}