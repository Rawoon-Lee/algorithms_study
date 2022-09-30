import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //N×N크기의 행렬
    //종이의 각 칸에는 -1, 0, 1 중 하나가 저장
    //1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    //2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
    //-1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수
    //N(1 ≤ N ≤ 3의 7제곱, N은 3의 K제곱 꼴)

    //재귀를 사용해서 분할정복하는 문제문제네
    static int N;
    static Map<Integer, Integer> ans;
    static int[][] map;

    public static void main(String[] args) {
        //스캐너
        Scanner sc = new Scanner(System.in);
        //입력받기
        N = sc.nextInt();
        //입력형태에 맞는 초기화해주기
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //정답 변수 초기화해주기
        ans = new HashMap<>();
        for (int i=-1; i<2; i++) {
            ans.put(i, 0);
        }
        //재귀함수 돌리기
        recur(0, 0, N);
        //정답 출력
        for (int i=-1; i<2; i++) {
            System.out.println(ans.get(i));
        }
    }
    //재귀 도는 함수
    static void recur(int r, int c, int len) {
        //멈추는 부분
        // 안에 들은 숫자가 모두 같아지면
        if(isSame(r, c, len)) {
            //첫 번째 숫자를 확인하고
            int num = map[r][c];
            //숫자에 따라서 해당하는 변수++ 해주기기
            ans.put(num, ans.get(num)+1);
            return;
        }
        //위에 if 문에 걸리지 않았다는 건 안에 숫자들이 다르다는 거니까
        // len 을 3으로 나눠주기
        len /= 3;
        //for 문 돌면서 9칸으로 나누는거 ㅋㅋㅋㅋ 재귀함수 집어넣기.... 아 귀찮
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                recur(r+len*i, c+len*j, len);
            }
        }
    }
    //같은 값으로 채워져있는지 확인하는 메소드
    static boolean isSame(int r, int c, int len) {
        int tmp = map[r][c];
        for (int i=0; i<len; i++) {
            for (int j = 0; j < len; j++) {
                if (map[r+i][c+j] != tmp) return false;
            }
        }
        return true;
    }
}
