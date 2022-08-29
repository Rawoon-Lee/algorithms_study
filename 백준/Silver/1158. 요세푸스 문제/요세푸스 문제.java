import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			queue.add(i);
		}
		int index = 0;
		int[] ans = new int[N];
		while(!queue.isEmpty()) {
			for (int i=0; i<K; i++) {
				if (i == K-1) {
					ans[index++] = queue.peek();
					queue.remove();
				} else {
					queue.add(queue.remove());					
				}
			}
		}
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				System.out.print(ans[i] + ">");
			} else {
				System.out.print(ans[i] + ", ");
			}
		}
	}
}
