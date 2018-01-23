public class Solution {
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if (a == null || a.size() <= 2 || a.get(0).size() <= 2) {
	        return;
	    }
	    int m = a.size();
	    int n = a.get(0).size();
	    for (int i = 0; i < m; i++) {
	        helper(a, i, 0);
	        helper(a, i, n - 1);
	    }
	    for (int i = 0; i < n; i++) {
	        helper(a, 0, i);
	        helper(a, m - 1, i);
	    }
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (a.get(i).get(j) == 'O') {
	                a.get(i).set(j, 'X');
	            }
	            if (a.get(i).get(j) == '#') {
	                a.get(i).set(j, 'O');
	            }
	        }
	    }
	}
	
	public void helper(ArrayList<ArrayList<Character>> a, int i , int j) {
	    if (a.get(i).get(j) != 'O') {
	        return;
	    }
	    a.get(i).set(j, '#');
	    int m = a.size();
	    int n = a.get(0).size();
	    int code = i * n + j;
	    Queue<Integer> queue = new LinkedList<>();
	    queue.offer(code);
	    while (!queue.isEmpty()) {
	        code = queue.poll();
	        int row = code / n;
	        int col = code % n;
	        if (row > 0 && a.get(row - 1).get(col) == 'O') {
	            queue.offer((row - 1) * n + col);
	            a.get(row - 1).set(col, '#');
	        }
	        if (row < m - 1 && a.get(row + 1).get(col) == 'O') {
	            queue.offer((row + 1) * n + col);
	            a.get(row + 1).set(col, '#');
	        }
	        if (col > 0 && a.get(row).get(col - 1) == 'O') {
	            queue.offer(row * n + col - 1);
	            a.get(row).set(col - 1, '#');
	        }
	        if (col < n - 1 && a.get(row).get(col + 1) == 'O') {
	            queue.offer(row * n + col + 1);
	            a.get(row).set(col + 1, '#');
	        }
	    }
	}
}