import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Run {
		int p, time;

		Run(int p, int time) {
			this.p = p;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = Integer.MAX_VALUE;

		Queue<Run> queue = new LinkedList<Run>();
		boolean[] visited = new boolean[100001];
		queue.add(new Run(N, 0));
		while (!queue.isEmpty()) {
			Run place = queue.poll();
			visited[place.p] = true;
			// 돌고 있는 중에 만약 이미 가지고 있는 시간보다 크다면 더 볼필요 없다
			if (place.time > ans)
				continue;
			// 찾았다!
			if (place.p == K) {
				ans = Math.min(ans, place.time);
				break;
			}
			// 범위확인
			if (place.p + 1 < 100001 && !visited[place.p + 1])
				queue.add(new Run(place.p + 1, place.time + 1));
			if (place.p - 1 >= 0 && !visited[place.p - 1])
				queue.add(new Run(place.p - 1, place.time + 1));
			if (place.p * 2 < 100001 && !visited[place.p * 2])
				queue.add(new Run(place.p * 2, place.time + 1));
		}
		System.out.println(ans);
	}
}
