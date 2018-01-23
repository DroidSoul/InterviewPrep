public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] primes = new int[3];
        primes[0] = A;
        primes[1] = B;
        primes[2] = C;
        int[] index = new int[3];
        res.add(1);
        for (int i = 1; i < D + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < index.length; j++) {
                min = Math.min(min, res.get(index[j]) * primes[j]);
            }
            res.add(min);
            for (int j = 0 ; j < index.length; j++) {
                if (min == res.get(index[j]) * primes[j]) {
                    index[j]++;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i < D; i++) {
            ans.add(res.get(i + 1));
        }
        return ans;
    }
}