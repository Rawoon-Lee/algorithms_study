package silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소힙1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			int order = sc.nextInt();
			if (order == 0) {
				if (queue.isEmpty()) 
					sb.append(0).append("\n");
				else 
					sb.append(queue.poll()).append("\n");
			}
			else {
				queue.add(order);
			}
		}
		System.out.println(sb.toString());
	}
}
