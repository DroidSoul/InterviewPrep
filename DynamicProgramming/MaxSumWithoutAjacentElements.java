public class Solution {
    public int adjacent(int[][] grid) {
        
    int[] local = new int[grid[0].length];
    int[] global = new int[grid[0].length];
      //for ith row (you have to pick one from it), then (i-2) row max > 0 ? 
 //     lcoal[i] = lcoal[i - 1] > 0 ? lcoal[i - 1] + Math.max(grid[0][i], grid[1][i]);
    local[0] = Math.max(grid[0][0], grid[1][0]);
    global[0] = local[0];
    if (grid[0].length == 1) {
      return local[0];
    }
    local[1] = Math.max(grid[0][1], grid[1][1]);
    global[1] = Math.max(local[0], local[1]);
    for (int i = 2; i < grid[0].length; i++) {
//      local[i] = Math.max(grid[0][i], grid[1][i]) + Math.max(0, local[i - 2]);
      local[i] = Math.max(grid[0][i], grid[1][i]) + global[i - 2];
      global[i] = Math.max(local[i], global[i - 1]);
    }
    return global[grid[0].length - 1];
    }
}