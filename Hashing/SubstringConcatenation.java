	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    ArrayList<Integer> res = new ArrayList<>();
	    int len = b.get(0).length();
	    if (a == null || a.length() == 0 || a.length() < b.size() * len) {
	        return res;
	    }
	    Map<String, Integer> map = new HashMap<>();
	    for (String str : b) {
	        map.put(str, map.getOrDefault(str, 0) + 1);
	    }
	    for (int i = 0; i < len; i++) {
	        Map<String, Integer> curMap = new HashMap<>();
	        int count = 0;
	        int left = i;
	        for (int j = i; j <= a.length() - len; j += len) {
	            String str = a.substring(j, j + len);
	            if (map.containsKey(str)) {
	                curMap.put(str, curMap.getOrDefault(str, 0) + 1);
	                if (curMap.get(str) <= map.get(str)) {
	                    count++;
	                }
	                else {
	                    while (curMap.get(str) > map.get(str)) {
	                        String tmp = a.substring(left, left + len);
	                        curMap.put(tmp, curMap.get(tmp) - 1);
	                        if (curMap.get(tmp) < map.get(tmp)) {
	                            count--;
	                        }
	                        left += len;
	                    }
	                }
	                if (count == b.size()) {
	                    res.add(left);
	                    String tmp = a.substring(left, left + len);
	                    curMap.put(tmp, curMap.get(tmp) - 1);
	                    left += len;
	                    count--;
	                }
	            }
	            else {
	                curMap.clear();
	                count = 0;
	                left = j + len;
	            }
	        }
	    }
	    return res;
	}
}