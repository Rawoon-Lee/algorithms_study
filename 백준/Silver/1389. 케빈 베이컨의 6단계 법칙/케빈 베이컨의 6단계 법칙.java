import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        List<Integer>[] adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i< V; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            adjList[st].add(ed);
            adjList[ed].add(st);
        }
        //방문처리를 할 불리언 배열
        int distance = Integer.MAX_VALUE;
        int ans = 0;
        for (int n=1; n<=N; n++) {
            int tmp = 0;
            boolean[] visited = new boolean[N+1];
            int[] dist = new int[N+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            visited[n] = true;
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for (int i:adjList[node]) {
                    if (visited[i]) continue;
                    if (dist[i] != 0) continue;
                    visited[i] = true;
                    dist[i] = dist[node] + 1;
                    queue.add(i);
                }
            }
//            System.out.println(Arrays.toString(dist));
            for (int i=0; i<=N; i++) {
                tmp+=dist[i];
            }
            if (tmp < distance) {
                distance = tmp;
                ans = n;
            }
        }
        System.out.println(ans);
    }
}
