package silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연결요소의개수_11724_dfs {
//연결요소란 이어져있는 그래프를 뜻하는 거네
//즉 덩어리들을 잘 찾아라~
//방문배열을 만들어야 되고(사이클을 돌 수도 있으니깐)
//무향인데, 인접리스트로 만들어봐야겠다.
//그리고 숫자 범위가 너무 커서 dfs는 못쓰고 무조건 bfs 써야겠다.
	//근데 어라 인터넷에 검색해보니까 dfs 쓴 사람이 있네...?
	//그럼 나도 간드아!!
	//그러기 위해서는 static 으로 많이 끌고 올라와야곘다
	static int N, M, ans;
	static List<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수. 1부터 시작하네
		M = sc.nextInt(); // 간선의 개수
		adjList = new ArrayList[N + 1];
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

		ans = 0;
		visited = new boolean[N + 1];
		for (int i=1; i<=N; i++) {
			if (dfs(i)) ans++;
		}
		System.out.println(ans);
	}
	static boolean dfs(int idx) {
		if (visited[idx]) {
			return false;
		}
		visited[idx] = true;
		for (int v:adjList[idx]) {
			if (visited[v]) continue;
			dfs(v);
		}
		return true;
	}
}
