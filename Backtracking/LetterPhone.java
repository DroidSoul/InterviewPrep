public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        if (A.length() == 0) {
            res.add("");
            return res;
        }
        String[] table = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list = letterCombinations(A.substring(1));
        int index = A.charAt(0) - '0';
        for (char c : table[index].toCharArray()) {
            for (String str : list) {
                 StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(str);
                res.add(sb.toString());
            }
        }
        return res;
    }
}