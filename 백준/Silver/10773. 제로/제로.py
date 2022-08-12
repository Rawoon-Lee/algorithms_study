import sys
input = sys.stdin.readline

K = int(input())
stack = []
for i in range(K):
    num = int(input())
    if num:
        stack.append(num)
    elif stack:
        stack.pop()
print(sum(stack))