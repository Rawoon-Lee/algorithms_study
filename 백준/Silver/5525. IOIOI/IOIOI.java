import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String str = sc.next();
        int[] memo = new int[M];
        int ans = 0;
        for (int i=1; i<M-1; i++) {
            if (str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                memo[i+1] += memo[i-1] + 1;
            }
        }
        for (int i=0; i<M; i++) {
            if (memo[i] >= N) {
                if (i - 2 * N < 0) continue;
                if (str.charAt(i - 2 * N) == 'I') ans++;
            }
        }
//        System.out.println(Arrays.toString(memo));
        System.out.println(ans);
    }
}
