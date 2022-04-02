package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z1074 {
	static int N;
	static int cnt, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = (int) Math.pow(2, Integer.parseInt(str[0]));
		r = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
		cnt = 0;
		dfs(N, 0, 0);
		System.out.println(cnt);
	}

	static void dfs(int num, int start, int end) {
		if (start == r && end == c) {
			return;
		}
		//1사분면
		if (r < start + num / 2 && c < end + num / 2) {
			dfs(num / 2, start, end);			
		} 
		//2사분면
		else if(r < start+num/2 && c >= end + num/2) {
			cnt+=(int) Math.pow(num / 2, 2) * 1;
			dfs(num / 2, start, end + num / 2);			
		}
		//3사분면
		else if(r >= start+num/2 && c < end+num/2) {
			cnt+=(int) Math.pow(num / 2, 2) * 2;
			dfs(num / 2, start + num / 2, end);			
		} else {
			cnt+=(int) Math.pow(num / 2, 2) * 3;
			dfs(num / 2, start + num / 2, end + num / 2);			
		}
	}
}
