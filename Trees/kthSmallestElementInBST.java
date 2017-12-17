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
    public int kthsmallest(TreeNode root, int k) {
        int[] res = new int[1];
        helper(root, new int[1], res, k);
        return res[0];
    }
    
    public void helper(TreeNode root, int[] count, int[] res, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, count, res, k);
        count[0]++;
        if (count[0] == k) {
            res[0] = root.val;
        }
        helper(root.right, count, res, k);
        
    }
}