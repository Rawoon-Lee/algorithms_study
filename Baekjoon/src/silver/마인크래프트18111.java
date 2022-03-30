package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 마인크래프트18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int B = Integer.parseInt(str[2]);
		int[][] house = new int[N][M];
		// 전체 필드에서 최대값과 최솟값을 찾는다.
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				house[i][j] = Integer.parseInt(tmp[j]);
				max = Math.max(max, house[i][j]);
				min = Math.min(min, house[i][j]);
			}
		} // 입력끝

		// 주의
		// 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.

		// 만들고 싶은 높이
		int time = Integer.MAX_VALUE;
		int height = 0;
		outer: for (int h = max; h >= min; h--) {
			// 내가 만들고 싶은 높이를 위해 들은 시간
			int sum = 0;
			// 내가 인벤토리에 가지고 있는 블럭의 수
			int block = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. :2초
					if (house[i][j] > h) {
						sum += 2 * (house[i][j] - h);
						block += house[i][j] - h;
					}
					// 내가 만들고 싶은 층보다 더 작을 때
					// 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. :1초
					else if (house[i][j] < h) {
						sum += h - house[i][j];
						block -= h - house[i][j];
					}
				}
			} // 전체 필드를 다 돌음
			// block 이 0보다 작다면 무사히 평탄화를 성공할 만큼 충분한 블럭이 었었다는것
			if (block < 0)
				continue outer;
			if (sum <= time) {
				if (sum == time) {
					height = Math.max(height, h);
				} else {
					time = sum;
					height = h;
				}
			}
		} // 답구하기 끝
		System.out.printf("%d %d", time, height);
	}
}
