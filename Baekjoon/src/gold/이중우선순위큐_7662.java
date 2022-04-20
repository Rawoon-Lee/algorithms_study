package gold;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 이중우선순위큐_7662 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 오름차순 정렬
			PriorityQueue<Integer> pqA = new PriorityQueue<>();
			// 내림차순 정렬
			PriorityQueue<Integer> pqD = new PriorityQueue<>(Collections.reverseOrder());
			// 지금까지 받아온 숫자들 저장할 map
			// 중복이 있을 수 있다고 했음
			HashMap<Integer, Integer> map = new HashMap<>();
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				String order = sc.next();
				int num = sc.nextInt();
				if (order.equals("I")) {
					pqA.add(num);
					pqD.add(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					// 최대값 삭제
					if (num == 1) {
						if (map.isEmpty()) continue;
						while(true) {							
							int tmp = pqD.poll();
							if(map.containsKey(tmp)) {							
								int cnt = map.get(tmp);
								if (cnt == 1) {
									map.remove(tmp);
								} else {
									map.put(tmp, cnt-1);
								}
								break;
							}
						}
					} else {
						if (map.isEmpty()) continue;
						while(true) {							
							int tmp = pqA.poll();
							if(map.containsKey(tmp)) {							
								int cnt = map.get(tmp);
								if (cnt == 1) {
									map.remove(tmp);
								} else {
									map.put(tmp, cnt-1);
								}
								break;
							}
						}
					}
				}
			} //모든 연산 처리 완료
			int max = 0;
			int min = 0;
			if (map.isEmpty()) sb.append("EMPTY").append("\n");
			else {
				while(true) {
					int tmp = pqD.poll();
					if (map.containsKey(tmp)) {
						max = tmp;
						break;
					}
				}
				while(true) {
					int tmp = pqA.poll();
					if (map.containsKey(tmp)) {
						min = tmp;
						break;
					}
				}
				sb.append(max).append(" ").append(min).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
