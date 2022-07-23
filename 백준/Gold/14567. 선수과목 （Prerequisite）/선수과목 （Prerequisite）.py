import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
result = [0] * (N + 1)
q = deque()
indegree = [0] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

for i in range(1, N+1):
    if indegree[i] == 0:
        q.append(i)
        result[i] = 1


while q:
    now = q.popleft()
    for i in graph[now]:
        result[i] = result[now] + 1
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)

result.pop(0)
print(*result)
