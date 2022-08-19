import sys
input = sys.stdin.readline

N = int(input())
members = [input().split() for _ in range(N)]
members.sort(key = lambda x: int(x[0]))

for mem in members:
    print(*mem)