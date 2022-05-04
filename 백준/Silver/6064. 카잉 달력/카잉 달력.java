import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            boolean flag = false;
            for (int x=0; x<=M; x++) {
                int year = x*N + X;
                int y = year % M;
                if (y == 0) y = M;
                if (y == Y) {
                    sb.append(year).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
