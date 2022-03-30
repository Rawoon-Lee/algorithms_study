package silver;

import java.util.Scanner;

public class 피보나치함수1003 {
	static int zero ;
	static int one;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			zero = 0;
			one = 0;
			fibo(sc.nextInt());
			System.out.printf("%d %d\n", zero, one);
		}
	}
	static void fibo(int num) {
		if (num == 0) {
			zero++;
			return;
		}
		if (num == 1) {
			one++;
			return;
		}
		fibo(num-1);
		fibo(num-2);
	}
}
