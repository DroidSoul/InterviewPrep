/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode a) {
	    if (a == null) {
	        return null;
	    }
	    ListNode head = a;
	    int count = 0;
	    while (head != null) {
	        head = head.next;
	        count++;
	    }
	    ListNode[] res = new ListNode[1];
	    res[0] = a;
	    return helper(res, 0, count - 1);
	}
	
	public TreeNode helper(ListNode[] res, int l, int r) {
	    if (l > r) {
	        return null;
	    }
	    int m = l + (r - l) / 2;
	    TreeNode left = helper(res, l, m - 1);
	    TreeNode root = new TreeNode(res[0].val);
	    root.left = left;
	    res[0] = res[0].next;
	    root.right = helper(res, m + 1, r);
	    return root;
	}
}