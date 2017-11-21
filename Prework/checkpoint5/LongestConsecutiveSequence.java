public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        if(A == null || A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : A) {
            set.add(num);
        }
        int max = 0;
        for(int num : A) {
            if(set.contains(num)) {
                set.remove(num);
                int localMax = 1;
                int temp = num;
                while(set.contains(temp - 1)) {
                    set.remove(temp - 1);
                    temp--;
                    localMax++;
                }
                temp = num;
                while(set.contains(temp + 1)) {
                    set.remove(temp + 1);
                    temp++;
                    localMax++;
                }
                max = Math.max(max, localMax);
            }
        }
        return max;
    }
}