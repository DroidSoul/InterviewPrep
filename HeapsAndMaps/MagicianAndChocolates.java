public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if (B == null || B.size() == 0) {
            return 0;
        }
        int mod = 1000000007;
        int res = 0;
        for (int val : B) {
            pq.offer(val);
        }
        for (int i = 0; i < A; i++) {
            int val = pq.poll();
            pq.offer(val / 2);
            res += val % mod;
            res %= mod;
        }
        return res;
        
    }
}