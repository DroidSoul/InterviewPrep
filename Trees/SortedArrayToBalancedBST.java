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
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    
	    return helper(a, 0, a.size() - 1);
	    
	}
	public TreeNode helper(List<Integer> list, int left, int right) {
	    if (left > right) {
	        return null;
	    }
	    int mid = left + (right - left) / 2;
	    TreeNode head = new TreeNode(list.get(mid));
	    head.left = helper(list, left, mid - 1);
	    head.right = helper(list, mid + 1, right);
	    return head;
	}
}