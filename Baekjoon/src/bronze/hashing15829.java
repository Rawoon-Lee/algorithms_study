package bronze;

import java.util.Scanner;

public class hashing15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		long hash = 0;
		String str = sc.next();
		long pow = (long) Math.pow(31, 0);
		for (int i = 0; i < len; i++) {
			hash += pow * (str.charAt(i) - '`');
			pow = pow*31%1234567891;
		}
		hash %= 1234567891;
		System.out.println(hash);
	}
}
