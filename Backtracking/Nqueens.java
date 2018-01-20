public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    if (a <= 0) {
	        return res;
	    }
	    helper(res, 0, new int[a], a);
	    return res;
	}
	private void helper(ArrayList<ArrayList<String>> res, int row, int[] colForRow, int a) {
	    if (row == a) {
	        ArrayList<String> temp = new ArrayList<>();
	        for (int i = 0; i < a; i++) {
	            StringBuilder sb = new StringBuilder();
	            for (int j = 0; j < a; j++) {
	                if (colForRow[i] == j) {
	                    sb.append('Q');
	                }
	                else {
	                    sb.append('.');
	                }
	            }
	            temp.add(sb.toString());
	        }
	        res.add(temp);
	        return;
	    }
	    for (int i = 0; i < a; i++) {
	        colForRow[row] = i;
	        if (isValid(row, colForRow)) {
	            helper(res, row + 1, colForRow, a);
	        }
	    }
	}
	
	private boolean isValid(int row, int[] colForRow) {
	    for (int i = 0; i < row; i++) {
	        if (colForRow[i] == colForRow[row] || Math.abs(colForRow[i] - colForRow[row]) == row - i) {
	            return false;
	        }
	    }
	    return true;
	}
}