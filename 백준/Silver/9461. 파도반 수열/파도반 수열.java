import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        long[] dp = new long[101]; //N이 최대 100까지이니까
        dp[1] = 1;
        dp[2] = 1;
        for (int i=3; i<=100; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }
        for (int tc=0; tc<T; tc++) {
            sb.append(dp[sc.nextInt()]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
