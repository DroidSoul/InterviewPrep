/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode A) {
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(A, res);
        return res[0];
    }
    public int helper(TreeNode A, int[] res) {
        if (A == null ) {
            return 0;
        }
        int left = helper(A.left, res);
        int right = helper(A.right, res);
        int localMax = (left > 0 ? left : 0) + A.val + (right > 0 ? right : 0);
        res[0] = Math.max(res[0], localMax);
        return Math.max(left, right) + A.val;
    }
}