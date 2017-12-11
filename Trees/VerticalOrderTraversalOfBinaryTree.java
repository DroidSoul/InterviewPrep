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
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> colNodes = new LinkedList<>();
        Queue<Integer> colNumber = new LinkedList<>();
        int min = 0;
        int max = 0;
        colNodes.add(A);
        colNumber.add(0);
        while (!colNodes.isEmpty()) {
            TreeNode node = colNodes.poll();
            int col = colNumber.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                colNodes.add(node.left);
                colNumber.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                colNodes.add(node.right);
                colNumber.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}