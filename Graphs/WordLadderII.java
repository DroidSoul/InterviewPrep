public class Solution {
public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, 
	       ArrayList<String> dict) {
	       ArrayList<ArrayList<String>> res = new ArrayList<>();
	       Set<String> set = new HashSet<>(dict);
	       Map<String, ArrayList<String>> map = new HashMap<>();
	       for (String s : dict) {
	           map.put(s, new ArrayList<String>());
	       }
	       Map<String, Integer> dist = new HashMap<>();
	       bfs(start, end, set, map, dist);
	       if (!dist.containsKey(end)) {
	           return res;
	       }
	       dfs(res, new ArrayList<String>(), end, start, map, dist);
	       return res;
	       
	}
	private void bfs(String start, String end, Set<String> set, 
	                 Map<String, ArrayList<String>> map, 
	                 Map<String, Integer> dist) {
	                     
	       set.add(start);
	       set.add(end);
	       dist.put(start, 0);
	       Queue<String> queue = new LinkedList<>();
	       queue.offer(start);
	       while (!queue.isEmpty()) {
	           String str = queue.poll();
	           List<String> neighbors = new ArrayList<>();
	           for (int i = 0; i < str.length(); i++) {
	               char[] chs = str.toCharArray();
	               for (char c = 'a'; c <= 'z'; c++) {
	                   if (c != chs[i]) {
	                       chs[i] = c;
	                       String next = new String(chs);
	                       if (set.contains(next)) {
	                           neighbors.add(next);
	                       }
	                   }
	               }
	           }
	           for (String neighbor : neighbors) {
	               map.get(neighbor).add(str);
	               if (!dist.containsKey(neighbor)) {
	                   dist.put(neighbor, dist.get(str) + 1);
	                   queue.offer(neighbor);
	               }
	           }
	       }
    }
    
    private void dfs(ArrayList<ArrayList<String>> res, ArrayList<String> path, String word, 
                     String start, Map<String, ArrayList<String>> map, 
                     Map<String, Integer> dist) {
                         
        if (word.equals(start)) {
            path.add(word);
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
            path.remove(path.size() - 1);
            return;
        }
        for (String str : map.get(word)) {
            if (dist.containsKey(str) && dist.get(str) == dist.get(word) - 1) {
                path.add(word);
                dfs(res, path, str, start, map, dist);
                path.remove(path.size() - 1);
            }
        }
    }
    
}