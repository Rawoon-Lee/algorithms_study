package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스타트와링크14889 {
	static int N, R, ans;
	static int[][] status;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		status = new int[N][N];
		for (int i=0; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				status[i][j] = Integer.parseInt(tmp[j]);
			}
		} //입력 끝
		// 각 팀의 능력치 차이의 최솟값
		ans = Integer.MAX_VALUE;
		R = N / 2;
		// 하나의 팀에 속하는 인원
		result = new int[R];
		nCr(0, 0);
		System.out.println(ans);
	}
	static void nCr(int idx, int sidx) {
		//원하는 갯수만큼 골랐으면 끝!
		if (sidx == R) {
			int teamA = 0;
			int teamB = 0;
			boolean[] other = new boolean[N];
			for (int i=0; i<R; i++) {
				other[result[i]] = true;
			}
			int[] rival = new int[R];
			int index = 0;
			for (int i=0; i<N; i++) {
				if (!other[i]) rival[index++] = i;
			}
			for (int i=0; i<R; i++) {
				for (int j=0; j<R; j++) {
					teamA += status[result[i]][result[j]];
					teamB += status[rival[i]][rival[j]];
				}
			}
			ans = Math.min(ans, Math.abs(teamA-teamB));
			return;
		}
		for (int i=idx; i<=N-R+sidx; i++) {
			result[sidx] = i;
			nCr(i+1, sidx+1);
		}
	}
}
