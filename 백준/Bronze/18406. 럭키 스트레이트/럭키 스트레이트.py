import sys
input = sys.stdin.readline

num = input().strip()
length = len(num) // 2
left = list(num[0:length])
right = list(num[length:])

if sum(list(map(int, left))) == sum(list(map(int, right))):
    print('LUCKY')
else:
    print('READY')