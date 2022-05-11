import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static private class RGB {
        int r, c;
        char rgb;
        RGB(int r, int c, char rgb) {
            this.r = r;
            this.c = c;
            this.rgb = rgb;
        }
    }
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = sc.next().toCharArray();
        }

        // bfs 사용해서 계산하자
        // 적록색약 없을 때
        visited = new boolean[N][N];
        int R = BFS('R');
        int G = BFS('G');
        int B= BFS('B');
        visited = new boolean[N][N];
        int RG = BFS_reverse('B');
        System.out.println((R+G+B)+" "+(RG+B));
    }
    static int BFS(char C) {
        int ans = 0;
        Queue<RGB> queue = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] == C) {
                    queue.add(new RGB(i, j, C));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        RGB curr = queue.poll();
                        visited[curr.r][curr.c] = true;
                        for (int d=0; d<4; d++) {
                            int nr = curr.r + dr[d];
                            int nc = curr.c + dc[d];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                            if (visited[nr][nc]) continue;
                            if (map[nr][nc] == curr.rgb) {
                                queue.add(new RGB(nr, nc, map[nr][nc]));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
}
    static int BFS_reverse(char C) {
        int ans = 0;
        Queue<RGB> queue = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] != C) {
                    queue.add(new RGB(i, j, map[i][j]));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        RGB curr = queue.poll();
                        visited[curr.r][curr.c] = true;
                        for (int d=0; d<4; d++) {
                            int nr = curr.r + dr[d];
                            int nc = curr.c + dc[d];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                            if (visited[nr][nc]) continue;
                            if (map[nr][nc] != C) {
                                queue.add(new RGB(nr, nc, map[nr][nc]));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
