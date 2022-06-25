import sys

input = sys.stdin.readline
N = int(input())
members = []
for _ in range(N):
    age, name = map(str, input().split())
    members.append(((int(age)), name))
ans = sorted(members, key=lambda mem: mem[0])
for i in range(N):
    print(ans[i][0], ans[i][1])