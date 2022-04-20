package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7576 {
//익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
//하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향
//대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다
//철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수
	// 최소일수니까 BFS 로 풀면 되겠네
	// static 으로 좌표값을 저장할 클래스만 만들어주자
	static class Tomato {
		int r, c, days;

		Tomato(int r, int c, int days) {
			this.r = r;
			this.c = c;
			this.days = days;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 열
		int N = sc.nextInt(); // 행
		int[][] box = new int[N][M];
		Queue<Tomato> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				// 입력받으면서 모든 익은 토마토를 큐에 넣는다.
				if (box[i][j] == 1) queue.add(new Tomato(i, j, 0));
			}
		} // 입력 끝

		// 4방향 탐색용
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		// 정답 변수
		int ans = 0;
		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();
			ans = Math.max(ans, curr.days);
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				// 범위를 벗어나지 않는지 확인
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				// 토마토가 없거나 이미 익었으면 패스
				if (box[nr][nc] != 0) continue;
				// 안 익은 토마토는 익은걸로 바꿔주고
				box[nr][nc] = 1;
				queue.add(new Tomato(nr, nc, curr.days+1));
			} // 사방탐색
		} // bfs while
		//계산이 다 끝났네
		if (isRipe(box)) System.out.println(ans); 
		//계산 다 했는데도 안익었으면 모두 익지 못하는 상황이라는 것
		else System.out.println(-1);
	}

	// 전체가 익었는지를 확인해야 하니까 isRipe 함수를 만들자
	static boolean isRipe(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
