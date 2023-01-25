N = int(input())

ans = sum([N // i * i for i in range(1, N + 1)])
print(ans)
