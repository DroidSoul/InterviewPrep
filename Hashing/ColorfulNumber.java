public class Solution {
	public int colorful(int a) {
	    String str = String.valueOf(a);
	    Set<Integer> set = new HashSet<>();
	    for (int i = 0; i < str.length(); i++) {
	        int sum = 1;
	        for (int j = i; j < str.length(); j++) {
	            sum *= (int)(str.charAt(j) - '0');
	            if (set.contains(sum)) {
	                return 0;
	            }
	            set.add(sum);
	        }
	    }
	    return 1;
	        
	}
}