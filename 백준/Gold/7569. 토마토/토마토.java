import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Tomato {
		int r, c, h, days;

		Tomato(int r, int c, int h, int days) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.days = days;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 열
		int N = sc.nextInt(); // 행
		int H = sc.nextInt(); // 높이
		int[][][] box = new int[H][N][M];
		Queue<Tomato> queue = new LinkedList<>();
		for (int h=0; h<H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[h][i][j] = sc.nextInt();
					// 입력받으면서 모든 익은 토마토를 큐에 넣는다.
					if (box[h][i][j] == 1) queue.add(new Tomato(i, j, h, 0));
				}
			} // 입력 끝
		}

		// 6방향 탐색용
		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };
		int[] dh = {0, 0, 0, 0, -1, 1};
		// 정답 변수
		int ans = 0;
		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();
			ans = Math.max(ans, curr.days);
			for (int d = 0; d < 6; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				int nh = curr.h + dh[d];
				// 범위를 벗어나지 않는지 확인
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || nh < 0 || nh >= H) continue;
				// 토마토가 없거나 이미 익었으면 패스
				if (box[nh][nr][nc] != 0) continue;
				// 안 익은 토마토는 익은걸로 바꿔주고
				box[nh][nr][nc] = 1;
				queue.add(new Tomato(nr, nc, nh, curr.days+1));
			} // 사방탐색
		} // bfs while
		//계산이 다 끝났네
		if (isRipe(box)) System.out.println(ans);
			//계산 다 했는데도 안익었으면 모두 익지 못하는 상황이라는 것
		else System.out.println(-1);
	}

	// 전체가 익었는지를 확인해야 하니까 isRipe 함수를 만들자
	static boolean isRipe(int[][][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k<arr[0][0].length; k++) {
					if (arr[i][j][k] == 0)
						return false;
				}
			}
		}
		return true;
	}
}
