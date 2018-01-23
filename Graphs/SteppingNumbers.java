public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A; i <= B; i++) {
            if (isValid(i)) {
                res.add(i);
            }
        }
        return res;
    }
    public boolean isValid(int x) {
        if (0 <= x && x <= 10) {
            return true;
        }
        int first = x % 10;
        x /= 10;
        int second = x % 10;
        if (Math.abs(second - first) == 1) {
            while (x > 10) {
                first = second;
                x /= 10;
                second = x % 10;
                if (Math.abs(second - first) != 1) {
                    return false;
                }
            }
            return true;
        }
        else return false;
    }
    
}