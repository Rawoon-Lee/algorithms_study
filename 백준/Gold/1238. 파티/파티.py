import sys
import collections
import heapq
input = sys.stdin.readline

# 입력받기
N, M, X = map(int, input().split())
roads = collections.defaultdict(list)
for _ in range(M):
    s, e, d = map(int, input().split())
    roads[s].append((e, d))


# 음수 간선이 없고 두 정점간의 최소비용만 구하면 되니까.. 다익스트라
# N -> X | X -> N 으로 양 방향을 봐야되니까 다익스트라 2번 돌리기
def dijkstra(start, dist):
    Q = [(0, start)]
    while Q:
        time, node = heapq.heappop(Q)
        if node not in dist:
            dist[node] = time
            for e, d in roads[node]:
                alt = time + d
                heapq.heappush(Q, (alt, e))


ans = 0
back = collections.defaultdict(int)
dijkstra(X, back)
for i in range(1, N+1):
    go = collections.defaultdict(int)
    dijkstra(i, go)
    ans = max(ans, go[X]+back[i])
print(ans)