import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			int N = sc.nextInt();
			int[][] dp = new int[41][2];
			dp[0][0] = 1; 
			dp[1][1] = 1;
			int n = N;
			for (int f=2; f<=n; f++) {
				dp[f][0] = dp[f-1][0] + dp[f-2][0];
				dp[f][1] = dp[f-1][1] + dp[f-2][1];
			}
			System.out.printf("%d %d\n", dp[n][0], dp[n][1]);
		}
	}
}
