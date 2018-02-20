// package whatever; // don't place package name!

import java.io.*;

/*
Given two words A and B, find the minimum number of steps required to convert A to B.
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character Delete a character Replace a character
Example : edit distance between "Anshuman" and "Antihuman" is 2.
// anshuman and anthihumn
Operation 1: Replace s with t. Operation 2: Insert i.
B
C
dp[0][0] = 0;
dp[0][1] = 1;
dp[1][0] = 1;
dp[1][1] = 0 + 1 = 1;

*/
// first i character, first j character = > minimum steps, dp[A.length()][B.length()];
//dp[i][j] = char[i - 1] == char[j - 1] ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;


/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

   1
  / \
 2   3
Return 6.

                       1
                      / \
                     5   3
                    / \
                   -1  -2

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
*/

class MyCode {
  public static void main (String[] args) {
    System.out.println("Hello Java");
  }
  


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }

  
  private int maxVal = Integer.MIN_VALUE;
  
  public int maxPathSum(TreeNode root) {
     maxPathSum(root);
    return maxVal;
  }  

  private int maxPathSumHelper(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return node.val;
    }    
    // Get the maxPathSum of subtree rooted at left child
    int leftSubTreeSum = maxPathSumHelper(node.left);
    // Get the maxPathSum of subtree rooted at right child
    int rightSubTreeSum = maxPathSumHelper(node.right);
    // Current Node sum
    int currentNodeSum = node.val;
    if (leftSubTreeSum > 0) {
      currentNodeSum += leftSubTreeSum;
    }
    if (rightSubTreeSum > 0) {
      currentNodeSum += rightSubTreeSum;
    }
    maxVal = currentNodeSum > maxVal : currentNodeSum : maxVal;
    int maxSubTreeSum = leftSubTreeSum > rightSubTreeSum ? leftSubTreeSum : rightSubTreeSum;
    return maxSubTreeSum <= 0 ? 0 : maxSubTreeSum + node.val;  
  }
  
  public int step(String A, String B) {
    if (A.length() == 0) {
      return B.length();
    }
    if (B.length() == 0) {
      return A.length();
    }
    int[][] dp = new int[A.length() + 1][B.length() + 1];
    for (int i = 0; i <= A.length(); i++) {
      for (int j = 0; j <= B.length(); j++) {
        if (i == 0) {
          dp[i][j] = j;
        }
        else if (j == 0) {
          dp[i][j] = i;
        }
        else {
          dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ?
                     dp[i - 1][j - 1] : Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    return dp[A.length()][B.length()];
    
  }
  
}