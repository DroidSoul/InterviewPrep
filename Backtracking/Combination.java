public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A < B) {
            return res;
        }
        helper(res, 1, A, B, new ArrayList<Integer>());
        return res;
    }
    
    
    public void helper(ArrayList<ArrayList<Integer>> res, int start, int A, int B, ArrayList<Integer> temp) {
        if (B == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if (start > A) {
            return;
        }
        for (int i = start; i <= A; i++) {
                temp.add(i);
                helper(res, i + 1, A, B - 1, temp);
                temp.remove(temp.size() - 1);
        }
    }
}