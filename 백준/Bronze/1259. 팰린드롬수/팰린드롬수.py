import sys

input = sys.stdin.readline

ans = []
while True:
    str = input().strip()
    if str == '0': break
    isSame = True
    for i in range(len(str) // 2):
        if str[i] != str[-(i+1)]:
            ans.append('no')
            isSame = False
            break
    if isSame:
        ans.append('yes')

for a in ans:
    print(a)
