public class Solution {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    if (a < 1) {
	        return res;
	    }
	    if (a == 1) {
	        ArrayList<Integer> list = new ArrayList<>();
	        list.add(1);
	        res.add(list);
	        return res;
	    }
	    ArrayList<ArrayList<Integer>> lists = prettyPrint(a - 1);
	    for (int i = 0 ; i < a * 2 - 1; i++) {
	        ArrayList<Integer> list = new ArrayList<>();
	        if (i == 0 || i == 2 * a - 2) {
	            for (int j = 0; j < 2 * a - 1; j++) {
	                list.add(a);
	            }
	        }
	        else {
	            list.add(a);
	            list.addAll(lists.get(i - 1));
	            list.add(a);
	        }
	        res.add(list);
	    }
	    return res;
	}
}