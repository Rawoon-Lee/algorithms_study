import sys
input = sys.stdin.readline

N = int(input().strip())
divisor = list(map(int, input().strip().split()))
divisor = sorted(divisor)
print(divisor[0] * divisor[N-1])
