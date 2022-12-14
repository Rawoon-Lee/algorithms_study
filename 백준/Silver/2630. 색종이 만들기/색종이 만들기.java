import java.util.Scanner;

public class Main {
//N×N(N=2k, k는 1 이상 7 이하의 자연수)
//아 이거 재귀로는 못푼다... 너무 범위가 크다
	// 근데 왜 알고리즘 분류가 재귀야...?
	// 좋아 일단 재귀로 풀어본다 안되면 뭐...ㅎ 다시하지 모
//입력으로 주어진 종이의 
//한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 
//잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.
	static int N, blue, white;
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		} // 입력완료
		divide(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	// 재귀로 계속 나누는 메소드
	static void divide(int row, int col, int divided) {
		//색이 같다
		if (isSame(row, col, divided)) {
			if (paper[row][col] == 1) 
				blue++;
			else white++;
			return;
		}
		divided /= 2;
		divide(row, col, divided);
		divide(row+divided, col, divided);
		divide(row, col+divided, divided);
		divide(row+divided, col+divided, divided);
	}

	// 색이 다른지 같은 지 확인하는 탐색 메소드
	static boolean isSame(int row, int col, int divided) {
		int color = paper[row][col];
		for (int i = row; i < row + divided; i++) {
			for (int j=col; j<col + divided; j++) {
				if (paper[i][j] != color) return false;
			}
		}
		return true;
	}
}
