import sys
input = sys.stdin.readline

N, K = map(int, input().split())

def factorial(num):
    ans = 1
    for i in range(1, num + 1):
        ans *= i
    return ans

print(1 if N == K else int(factorial(N) / (factorial(K) * factorial(N - K))))
