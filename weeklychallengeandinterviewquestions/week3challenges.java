import java.io.*;

class MyCode {
  public static void main (String[] args) {
    System.out.println("Hello Java");
  }
  
  
  boolean isBST(TreeNode root) {
    // node.val < node.right.val(every node of right subtree) && node.val > node.left.val (every node of left subtree)
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    
    
  }
  
  boolean helper(TreeNode node, int low, int high) {
    if (node == null) {
      return true;
    }
    return node.val < high && node.val > left && helper(node.left, low, node.val) && helper(node.right, node.val, high);
    
  }
  
  private int countLeafeNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    
    if (root.left == null && root.right == null) {
      return 1; 
    }
    
    return countLeafeNodes(root.left) + countLeafeNodes(root.right);
  }
  
  private boolean pathSum(TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == target) {
      return true;
    }
    return pathSum(root.left, target - root.val) || pathSum(root.right, target - root.val);
  }
  
  
     5
 4       6 
2  1   7   8

       
    private boolean pathSum(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qSum = new LinkedList<>();
        queue.offer(root);
        qSum.offer(0);
      
        while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          int sum = qSum.poll();
          if (node.left  == null && node.right == null && node.val + sum == target) {
            return true;
          }
          if (node.left != null) {
            queue.offer(node.left);
            qSum.offer(node.left.val + sum);
          }
          if (node.right != null) {
            queue.offer(node.right);
            qSum.offer(node.right.val + sum);
          }
          
        }
       return false;
    }
  
  
  private List<List<Integer>> findPathsDFS(TreeNode<Integer> root, int sum) {
    List<List<Integer>> result = new ArrayList<ArrayList<>>();
    if (root == null) {
      return  result;
    }
    
    findPaths(root, new ArrayList<Integer>(), result, int sum);
    
    return result;
  }
  
  
  private void findPaths(TreeNode node, List<Integer> path, List<List<Integer>> result, int sum){
    if (node == null) {
      return;
    }
    
    sum -= node.val;
    path.add(node.val);
    if (node.left == null && node.right == null && sum == 0) {
//      path.add(node.val);
      result.add(new ArrayList<Integer>(path));
      return;
 //     return true;
    }
    findPaths(node.left, path, result, sum);
    findPaths(node.right, path, result, sum);
    path.remove(path.size() - 1);
    
    
//    if (findPaths(node.left, path, result, sum) || findPaths(node.right, path, result, sum)){
//      path.add(node.val);
//      return true;
    } 
    
//    return false;
    
  }
  
   
}
  5
4   7
    
    5
    (4, 0) || (5, 0);
(null, -4) || (null, -4) || (null, -5) || (null, -5);

BFS
/*
Write a program that takes as its input an instance of TreeNode representing the root
of a tree and returns a int value representing the number of nodes in the tree with no children.
*/

/*
Write a program that takes as its input two instances of TreeNode and returns a boolean
value which is true if both trees have an identical structure with the same node values.
*/


/* 
Your last C# code is saved below:
using System;

public class Test
{
  public static void Main()
  {
    Console.WriteLine("Hello");
  }
}

 */
Write a program that takes as its input an instance of TreeNode<Integer> representing the root of a BST and a target int value and returns a boolean value which is true if the tree contains a path between the root and any leaf such that the sum of all the values of the nodes on the path equal the target value.

Hint: Use a breadth-first search

Example: Given a target value of 22 and a BST with the following structure:

BST:
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
The path 5?4?11?2 sums to 22, so the output in this case would be true.