package silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] meeting = new int[num][2];
		for (int i=0; i<num; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		} //입력완료
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}
			}
		});

		int cnt = 0;
		int start = 0;
		int end = 0;
		//배열을 차례대로 돌면서
		for (int i=0; i<num; i++) {
			//시작시간이 이전 종료시간보다 같거나 느릴 때 계속 진행
			if (meeting[i][0] >= end) {
				start = meeting[i][0];
				end = meeting[i][1];
				cnt++;
			}
			//종료시간이 기존 종료시간보다 빠르면 이전거 버리고 계속 넣는다.
			else if (meeting[i][1] < end) {
				start = meeting[i][0];
				end = meeting[i][1];
			}
		}
		System.out.println(cnt);
	}
}
