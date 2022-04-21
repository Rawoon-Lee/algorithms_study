package gold;

import java.util.Scanner;

public class 다각형의면적_2166 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] field = new long[N+1][2];
		for (int i=0; i<N; i++) {
			field[i][0] = sc.nextInt();
			field[i][1] = sc.nextInt();
		}
		field[N] = field[0];
		double sumA = 0;
		double sumB = 0;
		for (int i=0; i<N; i++) {
			sumA += field[i][0] * field[i+1][1];
			sumB += field[i][1] * field[i+1][0];
//			System.out.println(ans);
		}
		System.out.printf("%.1f",Math.abs(sumA - sumB) / 2);
	}
}
