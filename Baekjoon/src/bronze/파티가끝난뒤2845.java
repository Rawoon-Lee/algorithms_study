package bronze;
import java.util.Scanner;

public class 파티가끝난뒤2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt() * sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<5; i++) {
			sb.append(sc.nextInt()-people).append(" ");
		}
		System.out.println(sb.toString());
	}
}
