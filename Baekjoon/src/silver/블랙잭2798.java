package silver;

import java.util.Scanner;

public class 블랙잭2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = 0;
		// 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
		// 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
		// 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (M == sum) {
						ans = sum;
						break;
					}
					// 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
					if (sum < M) {
						ans = Math.max(ans, sum);
					}
				}
			}
		}

		// 모든 순회를 마치면 result 리턴
		System.out.println(ans);
	}
}
