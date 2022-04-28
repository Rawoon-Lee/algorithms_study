import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = sc.next().toCharArray();
        } //입력완료

        sb = new StringBuilder();
        Divide(0, 0, N);
        System.out.println(sb.toString());
    }
    static void Divide(int r, int c, int len) {
        if (isSame(r, c, len)) {
            sb.append(map[r][c]);
            return;
        }
        len /= 2;
        sb.append('(');
        Divide(r, c, len);
        Divide(r, c+len, len);
        Divide(r+len, c, len);
        Divide(r+len, c+len, len);
        sb.append(')');
    }
    static boolean isSame(int r, int c, int len) {
        char tmp = map[r][c];
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (map[r+i][c+j] != tmp) return false;
            }
        }
        return true;
    }
}
