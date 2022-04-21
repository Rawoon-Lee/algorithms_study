package silver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 좌표압축_18870_scanner {
//들어온 순서대로 저장하는 배열을 만들고
//해시맵 안에 set을 만들어서 값을 넣는다
//출력할 땐 키를 이용해서 set 의 사이즈를 출력한다.
	//1 ≤ N ≤ 1,000,000
	//for문 중복을 돌리면 시간초과는 당연하다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		HashSet<Integer> key = new HashSet<>();
		for (int i=0; i<N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			key.add(num);
		}
		HashMap<Integer, Integer> hmap = new HashMap<>();
		Integer[] sort = key.toArray(new Integer[0]);
		Arrays.sort(sort);
		for (int i=0; i<sort.length; i++) {
			hmap.put(sort[i], i);
		}
		for (int i=0; i<N; i++) {
			int num = hmap.get(arr[i]);
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
	}
}
