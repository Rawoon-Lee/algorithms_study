import sys
input = sys.stdin.readline

a, b, v = map(int, input().split())
target = v - a
ans = 0
if target % (a - b):
    ans = target // (a - b) + 2
else:
    ans = target // (a - b) + 1
print(ans)
