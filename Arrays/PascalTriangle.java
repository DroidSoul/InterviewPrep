public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    if (a <= 0) {
	        return res;
	    }
	    for (int i = 0; i < a; i++) {
	        if (i == 0) {
	            ArrayList<Integer> list = new ArrayList<>();
	            list.add(1);
	            res.add(list);
	        }
	        else {
	            ArrayList<Integer> list = res.get(i - 1);
	            ArrayList<Integer> newList = new ArrayList<>();
	            for (int j = 0; j <= i; j++) {
	                if (j == 0 || j == i) {
	                    newList.add(1);
	                }
	                else {
	                    newList.add(list.get(j) + list.get(j - 1));
	                }
	            }
	            res.add(newList);
	        }
	    }
	    return res;
	}
}