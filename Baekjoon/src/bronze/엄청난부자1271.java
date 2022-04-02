package bronze;

import java.util.Scanner;
//범위때문에 할 수가 없다...
//결국 파이썬으로 풀었음
public class 엄청난부자1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String total = sc.next();
		String people = sc.next();
		long money = 0;
		long extra = 0;
		int decimal = 1;
		for (int i=0; i<total.length()-1; i++) {
			int num = (total.charAt(i)-'0') * decimal;
			
			decimal = 10;
		}
	}
}
