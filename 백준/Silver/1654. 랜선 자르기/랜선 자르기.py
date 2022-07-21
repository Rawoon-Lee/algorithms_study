import sys
input = sys.stdin.readline

K, N = map(int, input().split())
stick = []

for _ in range(K):
    stick.append(int(input()))

start = 1
end = max(stick)

while start <= end:
    cnt = 0
    len = (start + end) // 2
    for s in stick:
        cnt += s // len
    if cnt < N:
        end = len -1
    else:
        start = len + 1

print(end)