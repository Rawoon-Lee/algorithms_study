a, b, c, d, e = map(int, input().split())
A, B, C, D, E = map(int, input().split())
score_a = a * 6 + b * 3 + 2 * c + d + e * 2
score_A = A * 6 + B * 3 + 2 * C + D + E * 2
print(score_a, score_A)