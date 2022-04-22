package gold;

import java.util.Arrays;
import java.util.Scanner;

public class 리모컨_1107 {
//리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. 
//+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, 
//-를 누르면 -1된 채널로 이동한다. 
//채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
//수빈이가 지금 이동하려고 하는 채널은 N
//지금 보고 있는 채널은 100
//어떤 버튼이 고장났는지 주어졌을 때(하나도 고장나지 않을수도 있으며 이경우엔 3번째 줄 없음), 
//채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지
//5457로 가기위해서 5455로 4변 누르고 플러스 ++누르니까 6번 누른 것이다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next(); //가야되는 채널
		int B = sc.nextInt(); //고장된 버튼의 수
		boolean[] nums = new boolean[10];
		//false 인 버트만 사용가능하다.
		if (B != 0) {
			for (int i=0; i<B; i++) {
				nums[sc.nextInt()] = true;
			}
		} //입력완료

		int max = -1;
		int min = 11;
		for (int i=0; i<10; i++) {
			if (!nums[i]) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
		}
		int idx = 0;
		String tmp  = "";
		int ans = 0;
		//첫째 자리에서부터 가장 가까운 숫자를 찾는다.
		while (true) {
			if (N.equals("100")) break;
			if ( B == 0) {
				ans = N.length();
				break;
			}
			if ( B == 10) {
				ans = (int) Math.abs(Integer.parseInt(N)-100);
				break;
			}
			//범위를 넘어서면 break
			if (idx == N.length()) break;
			int num = N.charAt(idx)-'0';
			int[] button = closest(num, nums);
			//숫자가 다르다면 가장 가까운 수를 찾고
			if (button[1] != 1) {
				//가장 가까운 숫자가 원래 숫자보다 작다면 나머지는 max 로 채운뒤에 N-새로만든 숫자
				if (button[1] == 0) {
					tmp = tmp.concat(Integer.toString(button[0]));
					ans++;
					for (int i=tmp.length()+1; i<=N.length(); i++) {
						tmp = tmp.concat(Integer.toString(max));
						ans++;
					}
					try {
						ans += Integer.parseInt(N) - Integer.parseInt(tmp);
					} catch (Exception e) {
						for (int i=0; i<tmp.length(); i++) {
							if (tmp.charAt(i) != '0') tmp = tmp.substring(i);
						}
						ans += Integer.parseInt(N) - Integer.parseInt(tmp);						
					}
					break;
				}
				//가장 가까운 숫자가 원래 숫자보다 크다면 나머지는 min 로 채운뒤에 새로만든 숫자-N을 한다.
				else {
					tmp = tmp.concat(Integer.toString(button[0]));
					ans++;
					for (int i=tmp.length()+1; i<=N.length(); i++) {
						tmp = tmp.concat(Integer.toString(min));
						ans++;
					}
					try {
						ans += Integer.parseInt(tmp) - Integer.parseInt(N);
					} catch (Exception e) {
						for (int i=0; i<tmp.length(); i++) {
							if (tmp.charAt(i) != '0') tmp = tmp.substring(i);
						}
						ans += Integer.parseInt(tmp) - Integer.parseInt(N);						
					}
					break;
				}
			}
			//만약 정확히 숫자가 일치하는 버튼이 사용가능하면 다음 숫자로 넘어가고
			tmp = tmp.concat(Integer.toString(num));
			idx++;
			ans++;
		}
		System.out.println(ans);
	}
	static int[] closest(int num, boolean[] nums) {		
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;
		int[] result = new int[2];
		for (int i=num; i>=0; i--) {
			if (!nums[i]) {
				if (i == num) {
					result[0] = i;
					result[1] = 1;
					return result;
				}
				small = i;
				break;
			}
		}
		for (int i=num; i<10; i++) {
			if (!nums[i]) {
				if (i == num) {
					result[0] = i;
					result[1] = 1;
					return result;
				}
				big = i;
				break;
			}
		}
		result[0] = (int) Math.abs(small-num) <= (int) Math.abs(big-num) ? small : big;
		result[1] = (int) Math.abs(small-num) <= (int) Math.abs(big-num) ? 0 : 2;
		
		return result;
	}
}
