import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 째줄의 n을 입력받고
		int N = Integer.parseInt(br.readLine());
		// 배열의 크기를 정한 다음에 이 안에 입력값을 집어넣는다.
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 입력끝
		// stack 생성
		Stack<Integer> stack = new Stack<>();
		// 배열속의 숫자를 가르킬 인덱스 변수가 하나 있어야 될것으로 보인다.
		int index = 0;
		// 1부터 N까지 올라갈 숫자
		int num = 1;
		// 정답 변수
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		// 1부터 n까지 숫자를 다루므로 for문으로 하는게 더 효과적일것으로 보인다.
		// 가 아니네 계산횟수가 몇 번이나 될지 모르니까 while 써야하네
		// num 값이 N과 같아지면 안에 남은거 모두를 pop시킨다.
		// 그로다가 arr과 틀린게 하나라도 나오면 탈출하고 NO를 출력한다.
		// 다 출력하면 자동 종료되도록 코드를 짠다.
		for (int i = 1; i <= N; i++) {
			// 무조건 일단 push를 한다.
			stack.push(i);
			sb.append("+\n");
			// 젤 위에 숫자가 인덱스로 특정한 숫자랑 같은면 pop을 한다.
			// 그런데 몇개나 같은 숫자가 나올지 모르니 while 로 돌린다.
			// 아 stack.peek() == arr[index]했더니 nullpointerexception나오네
			while (!stack.isEmpty()) {
				if (stack.peek() == arr[index]) {
					stack.pop();
					sb.append("-\n");
					index++;
				} else {
					break;
				}
			}
		}
		//다 비워냈으면 다 같았다는 거겠지 모
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb.toString());
		}
	}
}
