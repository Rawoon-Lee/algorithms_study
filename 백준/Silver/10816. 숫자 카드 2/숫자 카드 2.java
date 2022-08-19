import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<Integer>();
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(str[i]));
		}
		Collections.sort(nums);
		int M = Integer.parseInt(br.readLine());
		String[] quest = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(quest[i]);
			sb.append(upperBound(nums, tmp) - lowerBound(nums, tmp)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int lowerBound(List<Integer> list, int i) {
		int start = 0;
		int end = list.size()-1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (i <= list.get(middle)) {
				end = middle-1;
			} else if(i > list.get(middle)) {
				start = middle+1;				
			}
		}
		return start;
	}
	public static int upperBound(List<Integer> list, int i) {
		int start = 0;
		int end = list.size()-1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (i < list.get(middle)) {
				end = middle-1;
			} else if(i >= list.get(middle)) {
				start = middle+1;				
			}
		}
		return start;
	}
}