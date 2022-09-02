import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static String[][] names;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		String[] pokemon = new String[N];
		names = new String[N][2];
		for (int i = 0; i < N; i++) {
			pokemon[i] = br.readLine();
			names[i] = new String[] { Integer.toString(i + 1), pokemon[i] };
		}
		Arrays.sort(names, new Comparator<String[]>() {
			@Override
			public int compare(String[] a, String[] b) {
				return a[1].compareTo(b[1]);
			}
		});
		for (int i = 0; i < Q; i++) {
			String target = br.readLine();
			try {
				int num = Integer.parseInt(target);
				sb.append(pokemon[num - 1]).append("\n");
			} catch (Exception e) {
				sb.append(binarySearchString(target)).append("\n");
			}
		} // 질문
		System.out.println(sb.toString());
	}

	static String binarySearchString(String target) {
		int start = 0;
		int end = names.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (names[mid][1].equals(target))
				return names[mid][0];
			else {
				// 검색대상이 사전순으로 뒤에 있으면
				if (names[mid][1].compareTo(target) < 0) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return "-1";
	}
}
