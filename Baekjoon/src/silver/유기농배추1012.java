package silver;

import java.util.Arrays;
import java.util.Scanner;

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
			// 밭은 감싸는 부분으 만들어주기 위해서 2를 각각 더한 사이즈로 만든다.
			field = new int[N ][M ];
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				field[r][c] = 1;
			} // 입력완료
			int cnt = 0;
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M ; j++) {
					// 배추가 발견됐다!!
					if (field[i][j] == 1) {
						cnt++;
						field[i][j] = -1;
						// 이제 상하좌우로 다 살펴서 배추있는 쪽으로 계속 전진하고,
						// 기존에 있던 배추는 셌다는 의미를 주기 위해서 -1로 바꾸자
						search(i, j);
						System.out.println("cnt: "+cnt);
						for (int q=0; q<N; q++) {
							System.out.println(Arrays.toString(field[q]));
						}
					}
				}
			}
			System.out.println(cnt);
		} // 테케
	}
	//0을 만날때까지 계속 같은 방향으로 이동하는 함수를 만들자
	static void search(int r, int c) {
		int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for (int[] d: delta) {			
			int i = r; 
			int j = c;
			while (true) {
				// 벽 쪽에 붙거나 0을 만나면 break;
				if (i+d[0] > 0 && i+d[0] < N && j+d[1] > 0 && j+d[1] < M && field[i+d[0]][j+d[1]] == 1) {
					//카운트한 배추는 의미를 명확히 하기 위해 값을 바꿈
					field[i+d[0]][j+d[1]] = -1;
					i+=d[0];
					j+=d[1];
				} else {
					break;
				}
			}
		}
	}
}
