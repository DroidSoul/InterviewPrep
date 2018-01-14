public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(res, new boolean[A.size()], new ArrayList<Integer>(), A);
        return res;
        
    }
    
    public void helper(ArrayList<ArrayList<Integer>> lists, boolean[] used, ArrayList<Integer> temp, ArrayList<Integer> A) {
        if (temp.size() == A.size()) {
            lists.add(new ArrayList<Integer>(temp));
        }
        for (int i = 0; i < A.size(); i++) {
            if (!used[i]) {
                temp.add(A.get(i));
                used[i] = true;
                helper(lists, used, temp, A);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}