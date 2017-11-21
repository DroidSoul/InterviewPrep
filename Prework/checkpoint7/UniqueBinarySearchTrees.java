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
	public ArrayList<TreeNode> generateTrees(int a) {
	    return helper(1, a);
	}
	
	public ArrayList<TreeNode> helper(int left, int right) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right) {
            res.add(null);
            return res;
        }
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for(int j = 0; j < leftList.size(); j++) {
                for(int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}