package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 연결요소의개수_11724_bfs {
//연결요소란 이어져있는 그래프를 뜻하는 거네
//즉 덩어리들을 잘 찾아라~
//방문배열을 만들어야 되고(사이클을 돌 수도 있으니깐)
//무향인데, 인접리스트로 만들어봐야겠다.
//그리고 숫자 범위가 너무 커서 dfs는 못쓰고 무조건 bfs 써야겠다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 개수. 1부터 시작하네
		int M = sc.nextInt(); // 간선의 개수
		List<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			// 무향이니까 양방향으로 해준다
			adjList[st].add(ed);
			adjList[ed].add(st);
		} // 입력완료

		int ans = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		// 모든 정점에 대해서 돌아야겠지~
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				queue.add(i);
				visited[i] = true;
				while (!queue.isEmpty()) {
					int node = queue.poll();
					for (int n : adjList[node]) {
						if (visited[n]) continue;
						visited[n] = true;
						queue.add(n);
					}
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}
