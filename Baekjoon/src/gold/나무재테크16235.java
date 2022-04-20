package gold;

import java.util.Arrays;
import java.util.Scanner;

public class 나무재테크16235 {
//리스트보다는 배열이 더 메모리 효율적이고
//arraylist 는 검색이 빠르고 추가가 느리자만
//linkedlist 는 검색이 느리다
//그리고 정렬하지 않아도 풀수 있다 아마도
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//나무를 심을 땅의 크기
		int N = sc.nextInt();
		//나무의 갯수
		int M = sc.nextInt();
		//다시 확인할 시점
		int K = sc.nextInt();
		//겨울마다 칸 별로 추가하는 양분의 양
		int[][] fertilizer = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				fertilizer[i][j] = sc.nextInt();
			}
		}
		//나무의 위치와 나이
		int[][] trees = new int[M][3];
		for (int i=0; i<M; i++) {
			trees[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		int[][] field = new int[N][N];
		for (int i=0; i<N; i++) {
			Arrays.fill(field[i], 5);
			System.out.println(Arrays.toString(field[i]));			
		}
	}
}
