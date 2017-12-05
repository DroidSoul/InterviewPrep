public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    Map<String, ArrayList<Integer>> map = new HashMap<>();
	    for (int i = 0; i < a.size(); i++) {
	        String newStr = sortString(a.get(i));
	        if (!map.containsKey(newStr)) {
	            map.put(newStr, new ArrayList<Integer>());
	        }
	        map.get(newStr).add(i + 1);
	    }
	    return new ArrayList<>(map.values());
	    
	}
	
	public String sortString(String str) {
	    char[] chars = str.toCharArray();
	    Arrays.sort(chars);
	    return new String(chars);
	}
}