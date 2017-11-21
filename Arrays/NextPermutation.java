public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    if (a == null || a.size() <= 1) {
	        return;
	    }
	    int i = a.size() - 1;
	    while (i >= 1 && a.get(i) <= a.get(i - 1)) {
	        i--;
	    }
	    if (i == 0) {
	        Collections.sort(a);
	        return;
	    }
	    int j = a.size() - 1;
	    while (j >= i && a.get(j) <= a.get(i - 1)) {
	        j--;
	    }
	    int temp = a.get(j);
	    a.set(j, a.get(i - 1));
	    a.set(i - 1, temp);
	    Collections.sort(a.subList(i, a.size()));
	}
}