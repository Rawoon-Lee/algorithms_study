import java.util.*;

public class Main {
    static class Abs {
        int num;
        int abs;
        Abs(int num, int abs) {
            this.num = num;
            this.abs = abs;
        }

        @Override
        public String toString() {
            return "Abs{" +
                    "num=" + num +
                    ", abs=" + abs +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            int num = sc.nextInt();
            int abs = 0;
            if (num < 0) {
                abs = -1 * num;
                map.put(abs, map.getOrDefault(abs, 0)+1);
            } else if (num > 0) {
                abs = num;
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                int idx = pq.poll();
                if (!map.containsKey(idx) || map.get(idx) == 0) sb.append(idx).append("\n");
                else {
                    sb.append(-1*idx).append("\n");
                    map.put(idx, map.get(idx)-1);
                }
                continue;
            }
            Abs tmp = new Abs(num, abs);
            pq.add(abs);

        }
        System.out.println(sb.toString());
//        for (int i=0; i<list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
