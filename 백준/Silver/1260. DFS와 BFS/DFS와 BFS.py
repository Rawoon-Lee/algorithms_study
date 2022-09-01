import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for i in range(M):
    st, ed = map(int, input().split())
    graph[st].append(ed)
    graph[ed].append(st)
for i in range(1, N + 1):
    graph[i].sort()

visited = [False for _ in range(N + 1)]


def dfs(V):
    visited[V] = True
    print(V, end=' ')
    for node in graph[V]:
        if not visited[node]:
            dfs(node)


def bfs(V):
    queue = []
    queue.append(V)
    visited[V] = True
    while queue:
        tmp = queue.pop(0)
        print(tmp, end=' ')
        visited[tmp] = True
        for node in graph[tmp]:
            if not visited[node]:
                queue.append(node)
                visited[node] = True


dfs(V)
print()
visited = [False for _ in range(N + 1)]
bfs(V)