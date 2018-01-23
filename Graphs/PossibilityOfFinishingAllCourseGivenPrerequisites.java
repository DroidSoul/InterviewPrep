public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] table = new int[A];
        for (int num : C) {
            table[num - 1]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A; i++) {
            if (table[i] == 0) {
                queue.offer(i + 1);
            }
        }
        int count = queue.size();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < B.size(); i++) {
                if (num == B.get(i)) {
                    table[C.get(i) - 1]--;
                    if (table[C.get(i) - 1] == 0) {
                        queue.offer(C.get(i));
                        count++;
                    }
                }
            }
        }
        return count == A ? 1 : 0;
    }
}