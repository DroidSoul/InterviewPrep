public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        if (a == null || a.size() < 4) {
            return new ArrayList<Integer>();
        }
        ArrayList<Quadruple> res = new ArrayList<Quadruple>();
        Map<Integer, Tuple> map = new HashMap<>();
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                if (map.containsKey(sum)) {
                    Tuple t = map.get(sum);
                    if (t.x < i && t.y != i && t.y != j) {
                        res.add(new Quadruple(t.x, t.y, i, j));
                    }
                }
                else {
                    map.put(sum, new Tuple(i, j));
                }
            }
        }
        if (res.size() == 0) {
            return new ArrayList<Integer>();
        }
        Collections.sort(res, new Comparator<Quadruple>() {
            public int compare(Quadruple q1, Quadruple q2) {
                if (q1.x < q2.x || q1.x == q2.x && q1.y < q2.y || q1.x == q2.x && q1.y == q2.y && q1.a < q2.a || q1.x == q2.x && q1.y == q2.y && q1.a == q2.a && q1.b < q2.b) {
                    return -1;
                }
                return 1;
            }
        });
        Quadruple q = res.get(0);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(q.x);
        result.add(q.y);
        result.add(q.a);
        result.add(q.b);
        return result;
    }
    class Tuple {
        int x;
        int y;
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class Quadruple {
        int x;
        int y;
        int a;
        int b;
        public Quadruple (int x, int y, int a, int b) {
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
        }
    }
    
}