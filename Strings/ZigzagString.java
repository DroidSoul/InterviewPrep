public class Solution {
	public String convert(String a, int b) {
	    if (b == 1 || a.length() <= b) {
	        return a;
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < b; i++) {
	        if (i < a.length()) {
	            for (int j = i; j < a.length(); j += 2 * (b - 1)) {
	                sb.append(a.charAt(j));
	                if (i != 0 && i != b - 1 && j + 2 * (b - 1) - 2 * i < a.length()) {
	                    sb.append(a.charAt(j + 2 * (b - 1) - 2 * i));
	                }
	            }

	        }
	    }
	    return sb.toString();
	    
	}
}