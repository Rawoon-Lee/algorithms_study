package silver;

import java.util.Scanner;

public class 차이를최대로10819 {
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static int N, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		result = new int[N];
		visited = new boolean[N];
		ans = 0;
		perm(0);
		System.out.println(ans);
	}
	static void perm(int idx) {
		if (idx == N) {
			int sum = 0;
			for(int i=1; i<N; i++) {
				sum+= Math.abs(result[i]-result[i-1]);
			}
			ans = Math.max(sum, ans);
			return;
		}
		for (int i=0; i<N; i++) {
			if (visited[i]) continue;
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}
