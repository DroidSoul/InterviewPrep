public class Solution {
	public String addBinary(String a, String b) {
	    String revA = new StringBuilder(a).reverse().toString();
	    String revB = new StringBuilder(b).reverse().toString();
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    int j = 0;
	    int add = 0;
	    while (i < revA.length() || j < revB.length()) {
	        int sum = add + (i == revA.length() ? 0 : (int)(revA.charAt(i++) - '0')) + (j == revB.length() ? 0 : (int)(revB.charAt(j++) - '0'));
	        if (sum == 0) {
	            sb.append(0);
	            add = 0;
	        }
	        else if (sum == 1) {
	            sb.append(1);
	            add = 0;
	        }
	        else if (sum == 2) {
	            sb.append(0);
	            add = 1;
	        }
	        else {
	            sb.append(1);
	            add = 1;
	        }
	    }
	    if (add == 1) {
	        sb.append(1);
	    }
	    return sb.reverse().toString();
	}
}