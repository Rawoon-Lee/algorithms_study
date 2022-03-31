package silver;

import java.util.Arrays;
import java.util.Scanner;

//25%에서 실패
public class 유기농배추1012 {
	static int[][] field;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			// 밭은 감싸는 부분을 만들어주기 위해서 2를 각각 더한 사이즈로 만든다.
			field = new int[N + 2][M + 2];
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt() + 1;
				int r = sc.nextInt() + 1;
				field[r][c] = 1;
			} // 입력완료
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					// 배추가 발견됐다!!
					if (field[i][j] == 1) {
						cnt++;
						field[i][j] = 0;
						// 이제 상하좌우로 다 살펴서 배추있는 쪽으로 계속 전진하고,
						// 기존에 있던 배추는 셌다는 의미를 주기 위해서 -1로 바꾸자
						search(i, j);
						System.out.println("cnt: " + cnt);
						for (int q = 0; q < N+2; q++) {
							System.out.println(Arrays.toString(field[q]));
						}
					}
				}
			}
			System.out.println(cnt);
		} // 테케
	}

	// 오아래왼위로 이동하면서 1이 있으면 이동하고 0으로 바꾼다
	// 주변에 다 0만 4개 있으면 break;
	static void search(int r, int c) {
		int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int i = r;
		int j = c;
		int zero = 0;
		while (true) {
			zero = 0;
			for (int[] d : delta) {
				// 벽 쪽에 붙거나 0을 만나면 break;
				if (field[i + d[0]][j + d[1]] == 1) {
					// 카운트한 배추는 의미를 명확히 하기 위해 값을 바꿈
					field[i + d[0]][j + d[1]] = 0;
					search(i+d[0], j+d[1]);
					//그리고 해당자리로 이동
//					i += d[0];
//					j += d[1];
				} else {
					zero++;
				}
			}
			if (zero == 4) break;
		} //while 문
	}
}
