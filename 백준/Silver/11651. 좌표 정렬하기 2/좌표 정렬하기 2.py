import sys
input = sys.stdin.readline

N = int(input())
dots = [list(map(int, input().split())) for _ in range(N)]

dots.sort(key= lambda x: (x[1], x[0]))

for dot in dots:
    print(*dot)