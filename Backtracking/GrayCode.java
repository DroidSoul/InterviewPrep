public class Solution {
	public ArrayList<Integer> grayCode(int a) {
	    ArrayList<Integer> res = new ArrayList<>();
	    if (a <= 0) {
	        return res;
	    }
	    res.add(0);
	    res.add(1);
	    for (int i = 2; i <= a; i++) {
	        int size = res.size();
	        for (int j = size - 1; j >= 0; j--) {
	            res.add(res.get(j) + (1 << (i - 1)));
	        }
	    }
	    return res;
	}
}