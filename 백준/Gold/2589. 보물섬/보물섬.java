import java.util.*;

public class Main {
    static private class Route {
        int r, c, len;

        Route(int r, int c, int len) {
            //Route 라는 클래스를 만들어서
            //r, c, len 을 만든다.
            this.r = r;
            this.c = c;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "r=" + r +
                    ", c=" + c +
                    ", len=" + len +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] map = new char[R][C];
        List<Route> lands = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    lands.add(new Route(i, j, 0));
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int ans = 0;
        for (int i = 0; i < lands.size(); i++) {
            //L을 전부 queue 에 넣고, 배열에도 넣어서
            Queue<Route> queue = new LinkedList<>();
            boolean[][] visited = new boolean[R][C];
            Route start = lands.get(i);
            queue.add(start);
            visited[start.r][start.c] = true;
            int tmpAns = 0;
//                System.out.println("dest : "+ dest);
            while (!queue.isEmpty()) {
                Route curr = queue.poll();
//                    System.out.println(curr);
                tmpAns = Math.max(tmpAns, curr.len);
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] == 'W') continue;
                    visited[nr][nc] = true;
                    queue.add(new Route(nr, nc, curr.len + 1));
                }
            }
//                System.out.println(tmpAns);
            //최종적으로 최대를 찾는다.
            ans = Math.max(ans, tmpAns);
        }
        System.out.println(ans);
    }
}
