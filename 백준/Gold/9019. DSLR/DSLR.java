import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Exp {
        int num;
        String exp;
        Exp(int num, String exp) {
            this.num = num;
            this.exp = exp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int tc=0; tc<T; tc++) {
            int start = sc.nextInt();
            int target = sc.nextInt();

            boolean[] visited = new boolean[10000];
            int len = Integer.MAX_VALUE;
            String ans = "";
            //bfs로 완전탐색을 해야 될거 같다.
            Queue<Exp> queue = new LinkedList<>();
            queue.add(new Exp(start, ""));
            visited[start] = true;
            while (!queue.isEmpty()) {
                Exp num = queue.poll();
                //멈추는 조건이 있어야 while 문을 나갈텐데 -> 일단 아쉽지만 ans 보다 큰 값이 나오면 멈추는 걸로 하자
                if (num.exp.length() >= len) continue;
                //답이 나오면앞에서 계산한 ans 와 비교해서 최소값을 구하는 걸루
                if (num.num == target) {
                    len = num.exp.length();
                    ans = num.exp;
                    continue;
                }
                int d = D(num.num);
                if (!visited[d]) {
                    queue.add(new Exp(d, num.exp.concat("D")));
                    visited[d] = true;
                }
                int s = S(num.num);
                if (!visited[s]) {
                    queue.add(new Exp(s, num.exp.concat("S")));
                    visited[s] = true;
                }
                int l = L(num.num);
                if (!visited[l]) {
                    queue.add(new Exp(l, num.exp.concat("L")));
                    visited[l] = true;
                }
                int r = R(num.num);
                if (!visited[r]) {
                    queue.add(new Exp(r, num.exp.concat("R")));
                    visited[r] = true;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
    //그리고 4자리숫자가 아닌 숫자를 어떻게 4자리로 바꿀 것인지
    //각각의 명령에에 대한 처리는 함수로 처리하자
    static private int D(int n) {
        n *= 2;
        if (n > 9999) return n % 10000;
        return n;
    }
    static private int S(int n) {
        if (n == 0) return 9999;
        return n-1;
    }
    //L: 숫자에 곱하기 10을 하고 만약 9999보다 크면 10000으로 나눈 몫을 더해준다.
    static private int L(int n) {
        n *= 10;
        if (n > 9999) {
            n = n - (n / 10000) * 10000 + (n / 10000);
            return n;
        }
        return n;
    }
    //R: 10으로 나누고 만약 나머지가 0이 아니라면 나머지 * 1000을 해서 더해준다.
    static private int R(int n) {
        if (n % 10 != 0) {
            n = (n / 10) + (n % 10) * 1000;
            return  n;
        }
        return n / 10;
    }
}
