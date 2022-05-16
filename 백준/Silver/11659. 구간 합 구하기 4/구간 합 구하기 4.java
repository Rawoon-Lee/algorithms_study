import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N+1];
        int prev = 0;
        for (int i=1; i<=N; i++) {
            prev += sc.nextInt();
            nums[i] = prev;
        }
        for (int i=0; i<M; i++) {
            int sum = 0;
            int st = sc.nextInt();
            int ed = sc.nextInt();
            sum = nums[ed]-nums[st-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
