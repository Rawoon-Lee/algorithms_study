package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class 듣보잡1764 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int M = Integer.parseInt(nums[1]);
		HashSet<String> anonymous = new HashSet<String>();		
		for (int i=0; i<N; i++) {
			anonymous.add(br.readLine());
		}
		List<String> result = new ArrayList<String>();
		for (int i=0; i<M; i++) {
			String tmp = br.readLine();
			if (anonymous.contains(tmp))
				result.add(tmp);		
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
