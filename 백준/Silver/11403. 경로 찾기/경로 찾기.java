import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[][] adjArr = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                adjArr[i][j] = sc.nextInt();
            }
        }

        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (adjArr[i][k] == 1 && adjArr[k][j] == 1) adjArr[i][j] = 1;
                }
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(adjArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
