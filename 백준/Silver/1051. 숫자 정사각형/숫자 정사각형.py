import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().strip()) for _ in range(N)]

# 최대 길이
width = min(N, M)
ans = 1
for w in range(width):
  for i in range(N):
    for j in range(M):
      # 범위 벗어나면 끝
      if i + w >= N or j + w >= M:
        continue
      start = board[i][j]
      # 모두 값이 같다면 계산
      if board[i+w][j] == start and board[i][j+w] == start and board[i+w][j+w] == start:
        ans = max(ans, (w+1)**2)

print(ans)
