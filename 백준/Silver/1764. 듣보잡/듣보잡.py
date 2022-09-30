import sys
input = sys.stdin.readline

N, M = map(int, input().split())
unHeared = {}
for i in range(N):
    unHeared[input().strip()] = True
ans = []
for i in range(M):
    name = input().strip()
    if name in unHeared:
        ans.append(name)
ans.sort()
print(len(ans))
[print(n) for n in ans]