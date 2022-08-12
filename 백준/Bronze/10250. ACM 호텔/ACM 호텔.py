import sys
input = sys.stdin.readline

num = int(input())
for i in range(num):
    H, W, N = map(int, input().split())
    floor = N % H
    num = N // H + 1
    if floor == 0: 
        floor = H
        num = N // H
    ans = f'{floor}{num:0>2}'
    print(ans)