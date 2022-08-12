import sys
input = sys.stdin.readline

while True:
    num = list(map(int, input().split()))
    all = sum(num)
    if not all:
        break
    biggest = max(num)
    num.remove(biggest)
    if biggest ** 2 == num[0] ** 2 + num[1] ** 2:
        print('right')
    else:
        print('wrong')