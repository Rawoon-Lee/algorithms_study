import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 배열 대신에 queue 넣기
			List<int[]> queue = new ArrayList<int[]>();
			for (int j=0; j<N; j++) {
				 queue.add(new int[] {j, sc.nextInt()});
			}
			//입력 끝
			//맨 앞에 숫자를 기준으로 뒤에 애들에 대해서 max인지 확인
			int ans = 0;
			while(!queue.isEmpty()) {
				int[] num = queue.get(0);
				queue.remove(0);
				boolean isMax = true;
				for (int j=0; j<queue.size(); j++) {
					if(num[1] < queue.get(j)[1]) {
						isMax = false;
						break;
					}
				}
				if (!isMax) {
					queue.add(num);
				} else {
					ans++;
					if (num[0] == M) {
						break;
					}
				}
			}
			System.out.println(ans);
		} //테케 for문
	}
}
