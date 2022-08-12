import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// 한줄이니까 그냥 String br.readline 해서 받아오자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 시간 1초라서 혹시모르니까 sb로
		StringBuilder sb = new StringBuilder();
		List<String> doc = new ArrayList<String>();
		String str;
		while (true) {
			str = br.readLine();
			if (str.equals(".")) break;
			doc.add(str);
		}
//		System.out.println(doc); 입력확인
		// 입력 완료

		// 그리고 stack 으로 해봐야징
		Stack<Character> stack;
		// 괄호가 하나도 없었는지 확인하기 위해서
		int cnt;
		outer: for (int i = 0; i < doc.size(); i++) {
			// 정답용
			String ans = "yes";
			stack = new Stack<>();
			String tmp = doc.get(i);
			cnt = 0;
			for (int j = 0; j < tmp.length(); j++) {
				// 알파벳, 공백은 그냥 무시
				char target = tmp.charAt(j);
				if (Character.isLetter(target) || target == ' ')
					continue;
				// 비어있거나 여는 괄호면 무조건 넣는다
				if (target == '(' || target == '[') {
					stack.add(target);
					cnt++;
				}
				// 닫는 괄호가 나왔고 해당하는 여는 괄호가 있으면 뺀다
				else if ((target == ')' && !stack.isEmpty() && stack.peek() == '(')
						|| (target == ']') && !stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}
				// 닫는 괄호가 나왔는데 비어있거나 여는 괄호가 없으면 바로 break no
				else if ((target == ')' && ((!stack.isEmpty() && stack.peek() != '(') || stack.isEmpty()))
						|| (target == ']' && ((!stack.isEmpty() && stack.peek() != '[') || stack.isEmpty()))) {
					ans = "no";
					sb.append(ans).append("\n");
					continue outer;
				}
			} // 각 문장의 끝
				// 마지막까지 왔는데 괄호가 하나도 없으면그것도 균형잡힌거네 yes
			if (cnt == 0) {
				sb.append(ans).append("\n");
			}
			// 마지막까지 돌아서 비어있으면 yes
			else if (stack.isEmpty()) {
				sb.append(ans).append("\n");
			}
			// 마지막까지 왔는데 남아있으면 no
			else {
				ans = "no";
				sb.append(ans).append("\n");
			}
		} // outer for 문 끝
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
