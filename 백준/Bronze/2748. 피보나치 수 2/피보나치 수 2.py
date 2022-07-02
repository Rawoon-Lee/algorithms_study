import sys

input = sys.stdin.readline
n = int(input())

# 빈 수열을 만들어준다
d = [0] * 100

d[1] = 1
d[2] = 1

# 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
for i in range(3, n + 1): # 3번째부터 n번째까지
    d[i] = d[i - 1] + d[i - 2]

print(d[n])