package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS1260 {
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int v = sc.nextInt();
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			graph[st][ed] = 1;
			graph[ed][st] = 1;
		} // 입력완료
		visited = new boolean[N + 1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(v);
		System.out.println(sb.toString());
	} // main

	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		for (int j = 1; j <=N ; j++) {
			//간선이 존재하고 아직 방문한 적이 없다
			if (graph[start][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);
		for (int i = 0; i < M; i++) {
			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				sb.append(tmp).append(" ");
				for (int j=1; j<=N; j++) {
					if (graph[tmp][j] == 1 && !visited[j]) {
						visited[j] = true;
						queue.add(j);
					}
				}
			}
		}
	}
}
