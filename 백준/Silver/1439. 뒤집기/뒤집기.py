import sys
input = sys.stdin.readline

# 한수 풀이
str = input().strip()
zero = len([s for s in str.split('1') if s])
one = len([s for s in str.split('0') if s])
print(min(zero, one))