import sys
input = sys.stdin.readline

N = int(input())
str = list(input())
nums = [ord(x) - 96 for x in str]

ans = 0
pow = 1
for i in range(N):
    tmp = nums[i] * pow % 1234567891
    ans += tmp
    pow = pow * 31 % 1234567891

print(int(ans % 1234567891))