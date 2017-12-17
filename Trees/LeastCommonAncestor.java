/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int lca(TreeNode a, int val1, int val2) {
	    if (a == null || !find(a, val1) || !find(a, val2)) {
	        return -1;
	    }
	    return helper(a, val1, val2);
	}
	public int helper(TreeNode a, int val1, int val2) {
	    if (a == null) {
	        return -1;
	    }
	    if (a.val == val1 || a.val == val2) {
	        return a.val;
	    }
	    int left = helper(a.left, val1, val2);
	    int right = helper(a.right, val1, val2);
	    if (left == -1) {
	        return right;
	    }
	    if (right == -1) {
	        return left;
	    }
	    return a.val;
	}
	public boolean find(TreeNode a, int value) {
	    if (a == null) {
	        return false;
	    }
	    if (a.val == value) {
	        return true;
	    }
	    return find(a.left, value) || find(a.right, value);
	}
}