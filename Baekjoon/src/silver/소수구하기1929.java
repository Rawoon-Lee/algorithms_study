package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수구하기1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		StringBuilder sb = new StringBuilder();
		boolean[] prime = new boolean[N+1];
		prime[0] = true;
		prime[1] = true;
		for (int i=2; i<=Math.sqrt(N); i++) {
			if (prime[i]) continue;
			for (int j= i*i; j<=N; j+=i) {
				prime[j] = true;
			}
		}
		for (int i = M; i <= N; i++) {
			if (!prime[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
