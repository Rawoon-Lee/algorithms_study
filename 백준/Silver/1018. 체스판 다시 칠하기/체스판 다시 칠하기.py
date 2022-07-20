import sys

input = sys.stdin.readline
N, M = map(int, input().split())

board = []
for i in range(N):
    board.append(input())

count = []
for a in range(N-7):
    for b in range(M-7):
        Black = 0
        White = 0
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i + j) % 2 == 0:
                    if board[i][j] != 'B':
                        Black += 1
                    if board[i][j] != 'W':
                        White += 1
                else:
                    if board[i][j] != 'W':
                        Black += 1
                    if board[i][j] != 'B':
                        White += 1
        count.append(min(Black, White))
print(min(count))