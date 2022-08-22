import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] coordinate = new String[N][2];
		for (int i = 0; i < N; i++) {
			coordinate[i] = br.readLine().split(" ");
		}
		Arrays.sort(coordinate, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
					return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
				}
				return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(coordinate[i][0]).append(" ").append(coordinate[i][1]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
