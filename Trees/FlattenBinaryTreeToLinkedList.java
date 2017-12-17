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
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    if (a == null) {
	        return res;
	    }
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(a);
	    boolean leftToRight = true;
	    while (!q.isEmpty()) {
	        int size = q.size();
	        ArrayList<Integer> list = new ArrayList<>();
	        for (int i = 0; i < size; i++) {
	            TreeNode node = q.poll();
	            list.add(node.val);
	            if (node.left != null) {
	                q.offer(node.left);
	            }
	            if (node.right != null) {
	                q.offer(node.right);
	            }
	        }
	        if (!leftToRight) {
	            Collections.reverse(list);
	        }
	        leftToRight = !leftToRight;
	        res.add(list);
	    }
	    return res;
	}
}