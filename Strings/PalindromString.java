public class Solution {
	public int isPalindrome(String a) {
	    if (a == null || a.length() <= 1) {
	        return 1;
	    }
	    int i = 0;
	    int j = a.length() - 1;
	    while (i < j) {
	        if (!isChar(a.charAt(i))) {
	            i++;
	            continue;
	        }
	        if (!isChar(a.charAt(j))) {
	            j--;
	            continue;
	        }
	        if (!isSame(a.charAt(i), a.charAt(j))) {
	            return 0;
	        }
	        i++;
	        j--;
	    }
	    return 1;
	}
	public boolean isChar(char c) {
	    if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
	        return true;
	    }
	    return false;
	}
	public boolean isSame(char c1, char c2) {
	   if('A' <= c1 && c1 <= 'Z') {
            c1 = (char)(c1 + 'a' - 'A');
        }
        if('A' <= c2 && c2 <= 'Z') {
            c2 = (char)(c2 + 'a' - 'A');
        }
        return c1 == c2;
	}
}