public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < A.size(); i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> list = new ArrayList<>(res.get(j));
                list.add(A.get(i));
                res.add(list);
            }
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