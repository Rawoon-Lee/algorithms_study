import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너를 통해서 문자열을 통째로 받는다.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // 전체 문자열을 -을 기준으로 나눈다음
        String[] groups = str.split("-");
        int ans = 0;
        for (int s=0; s<groups.length; s++) {
            //그리고 각각의 문자열을 다시 +를 기준으로 나눠서 계산한다.
            String[] nums = groups[s].split("[+]");
            int tmp = 0;
            for (int n=0; n< nums.length; n++) {
                tmp += Integer.parseInt(nums[n]);
            }
            //가장 처음과 마지막은 무조건 숫자이기 때문에 
            // 0번째 배열은 정답 값에 더하고 나머지 배열의 값은 모두 뺀다
            if (s != 0) ans-=tmp;
            else ans += tmp;
        }
        System.out.println(ans);
    }
}
