import sys
input = sys.stdin.readline

N = int(input())
cnt = 0
for i in range(1, N + 1):
    num = i
    while num % 5 == 0:
        cnt += 1
        num /= 5
print(cnt)
