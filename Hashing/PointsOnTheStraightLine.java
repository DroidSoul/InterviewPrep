public class Solution {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int res = 0;
	    for (int i = 0; i < a.size(); i++) {
	        Map<Double, Integer> map = new HashMap<>();
	        int cur = 1;
	        for (int j = 0; j < a.size(); j++) {
	            if (i == j) {
	                continue;
	            }
	            if (a.get(i) == a.get(j) && b.get(i) == b.get(j)) {
	                cur++;
	            }
	            else {
	                if (a.get(i) == a.get(j)) {
	                    map.put(Double.MAX_VALUE, map.getOrDefault(Double.MAX_VALUE, 0) + 1);
	                }
	                else {
	                    double k = (double)(b.get(j) - b.get(i)) / (a.get(j) - a.get(i));
	                    map.put(k, map.getOrDefault(k, 0) + 1);
	                }
	            }
	        }
	        res = Math.max(res, cur + helper(map));
	    }
	    return res;
	}
	public int helper(Map<Double, Integer> map) {
	    int res = 0;
	    for (int val : map.values()) {
	        if (val > res) {
	            res = val;
	        }
	    }
	    return res;
	}
}