import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int N = sc.nextInt();
		int K = sc.nextInt();
		int index = 0;
		int ans = 0;
		int cnt = 0;
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		while(true) {
			if (arr[index % N] != -1) {
				if(ans == K-1) {
					sb.append(arr[index % N]);
					arr[index % N] = -1;
					ans = 0;
					cnt++;
					if (cnt==N) {
						sb.append(">");
						break;
					} else {
						sb.append(", ");
					}
				} else {
					index++;
					ans++;					
				}
			} else {
				index++;
			}
		}
		System.out.println(sb.toString());
	}
}
