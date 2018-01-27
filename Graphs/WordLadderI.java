public class Solution {
	public int ladderLength(String start, String end, ArrayList<String> dictV) {
	    if (start.equals(end)) {
	        return 1;
	    }
	    if (dictV == null || dictV.size() == 0) {
	        return 0;
	    }
	    Set<String> set = new HashSet<>(dictV);
	    Queue<String> queue = new LinkedList<>();
	    queue.offer(start);
	    int level = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            String str = queue.poll();
	            for (int j = 0; j < str.length(); j++) {
	                char[] chs = str.toCharArray();
	                for (char c = 'a'; c <= 'z'; c++) {
	                    if (c == chs[j]) {
	                        continue;
	                    }
	                    chs[j] = c;
	                    String newStr = new String(chs);
	                   if (newStr.equals(end)) {
	                       return level + 1;
	                   }
	                   if (set.contains(newStr)) {
	                       queue.offer(newStr);
	                       set.remove(newStr);
	                   }
	                }
	            }
	        }
	        level++;
	    }
	    return 0;
	    }
}