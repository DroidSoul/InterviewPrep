public class Solution {
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    helper(a, res, new ArrayList<String>());
	    return res;
	    
	}
	private void helper(String s, ArrayList<ArrayList<String>> res, ArrayList<String> temp) {
	    if (s.length() == 0) {
	        res.add(new ArrayList<String>(temp));
	        return;
	    }
	    for (int i = 1; i <= s.length(); i++) {
	        if (isPal(s.substring(0, i))) {
	            temp.add(s.substring(0, i));
	            helper(s.substring(i), res, temp);
	            temp.remove(temp.size() - 1);
	        }
	    }
	}
	private boolean isPal(String s) {
	    if (s.length() == 0) {
	        return true;
	    }
	    int i = 0;
	    int j = s.length() - 1;
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
}