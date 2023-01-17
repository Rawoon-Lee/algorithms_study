import sys
input = sys.stdin.readline

input()
nums = list(map(int, input().strip().split()))
task = int(input().strip())
count = [0] * 201
for n in nums:
    count[n + 100] += 1
print(count[task + 100])