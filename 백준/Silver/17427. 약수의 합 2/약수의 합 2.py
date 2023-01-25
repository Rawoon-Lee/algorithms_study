import sys
input = sys.stdin.readline

N = int(input().strip())
# answer variable
ans = 0
# except 1 from N nums
for i in range(2, N+1):
    # 배수의 개수
    ans += N // i * i
# 모두 1을 약수로 가지니까 N 더하기
print(ans + N)
