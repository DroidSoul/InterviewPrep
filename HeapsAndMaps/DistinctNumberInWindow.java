public class Solution {
    public int[] dNums(int[] A, int B) {
        if (B <= 0 || A == null || A.length == 0 || B > A.length) {
            return new int[0];
        }
        int[] res = new int[A.length - B + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < A.length - B + 1; i++) {
            if (i > 0) {
                map.put(A[i + B - 1], map.getOrDefault(A[i + B - 1], 0) + 1);
                if (map.get(A[i - 1]) == 1) {
                    map.remove(A[i - 1]);
                }
                else {
                    map.put(A[i - 1], map.get(A[i - 1]) - 1);
                }
            }
            res[i] = map.size();
        }
        return res;
    }
}