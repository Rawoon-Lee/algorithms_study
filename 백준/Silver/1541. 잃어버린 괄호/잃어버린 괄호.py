import sys
input = sys.stdin.readline

cal = input().split('-')
ans = 0
for i in range(len(cal)):
    tmp = 0
    for j in cal[i].split('+'):
        tmp += int(j)
    ans = ans + tmp if i == 0 else ans - tmp

print(ans)