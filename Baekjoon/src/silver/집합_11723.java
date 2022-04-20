package silver;

import java.util.HashMap;
import java.util.Scanner;

public class 집합_11723 {
	//해시 맵 쓰면 완전 쉽게 될듯
	//switch 로 써야겠다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;
		for (int i=0; i<N; i++) {
			String order = sc.next();
			switch (order) {
			case "add":
				num = sc.nextInt();
				if (!map.containsKey(num)) map.put(num, 0);
				break;
			case "remove":
				num = sc.nextInt();
				if (map.containsKey(num)) map.remove(num);
				break;
			case "check":
				num = sc.nextInt();
				if (map.containsKey(num)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				num = sc.nextInt();
				if (map.containsKey(num)) map.remove(num);
				else map.put(num, 0);
				break;
			case "all":
				for (int n=1; n<=20; n++) {
					if (!map.containsKey(n)) map.put(n, 0);
				}
				break;
			case "empty":
				map.clear();
				break;

			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
