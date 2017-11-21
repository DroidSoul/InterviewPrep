public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            if (maxHeap.size() < B) {
                maxHeap.offer(A[i]);
            }
            else if (A[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(A[i]);
            }
        }
        return maxHeap.peek();
    }
}