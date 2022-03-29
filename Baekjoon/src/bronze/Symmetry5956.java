package bronze;

import java.util.Scanner;

public class Symmetry5956 {
	static int cows;
	static int r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		cows = 0;
		r = 1;
		positioning(N, M);
		System.out.println(cows);
	}
	static void positioning(int x, int y) {
		if (x %2 == 0 || y % 2 == 0) return;
		else cows+=r;
		r*=4;
		positioning(x / 2, y / 2);
	}
}
