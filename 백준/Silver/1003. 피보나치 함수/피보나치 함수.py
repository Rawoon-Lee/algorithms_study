import sys
input = sys.stdin.readline

n = int(input())
# dp 테이블
dp = [[0 for _ in range(2)] for _ in range(41)]
dp[0][0] = 1
dp[1][1] = 1
for f in range(2, 41):
  dp[f][0] = dp[f-1][0] + dp[f-2][0]
  dp[f][1] = dp[f-1][1] + dp[f-2][1]

for _ in range(n):
  q = int(input())
  print(dp[q][0], dp[q][1])