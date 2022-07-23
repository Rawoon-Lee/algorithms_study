import sys
input = sys.stdin.readline

N, M = map(int, input().split())
queue, result = [], []
indegree = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

for i in range(1, N+1):
    if indegree[i] == 0:
        queue.append(i)

while queue:
    now = queue.pop(0)
    result.append(now)
    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

for r in result:
    print(r, end=' ')
