package silver;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대힙_11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		for (int i=0; i<N; i++) {
			int order = sc.nextInt();
			if (order == 0) {
				if (pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.add(order);
			}
		}
		System.out.println(sb.toString());
	}
}
