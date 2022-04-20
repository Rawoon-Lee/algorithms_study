package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스2606 {
//뭐야 쉽네
//인접리스트 만들고
//1과 연결된 네트워크 타고타고 가면서 더하기 하면 되겠네...?
//어라 음 타고 가는건...queue 로... 하면 되겠지....?
//bfs 간다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //정점의 개수
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		int E = sc.nextInt(); //간선의 개수
		for (int i=0; i<E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adjList[start].add(end);
			adjList[end].add(start);
		} //입력완료
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		int ans = 0;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int e:adjList[tmp]) {
				if (visited[e]) continue;
				ans++;
				visited[e] = true;
				queue.add(e);
			}
		}
		System.out.println(ans);
	}
}
