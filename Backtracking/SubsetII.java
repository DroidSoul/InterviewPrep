public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null) {
            return res;
        }
        Collections.sort(A);
        res.add(new ArrayList<Integer>());
        int start = 0;
        for (int i = 0; i < A.size(); i++) {
            int size = res.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(A.get(i));
                res.add(temp);
            }
            start = i < A.size() - 1 && A.get(i) == A.get(i + 1) ? size : 0;
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
           @Override
           public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
               int aSize = a.size();
               int bSize = b.size();
               for (int i = 0; i < Math.min(aSize, bSize); i++) {
                   int cmp = Integer.compare(a.get(i), b.get(i));
                   if (cmp != 0) {
                       return cmp;
                   }
               }
               return aSize - bSize;
           }
        });
        return res;
    }
}