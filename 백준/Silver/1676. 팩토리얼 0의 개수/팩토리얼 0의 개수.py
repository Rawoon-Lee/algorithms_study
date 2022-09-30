import sys
input = sys.stdin.readline

N = int(input())
fact, cnt = 1, 0
for i in range(1, N + 1):
    fact *= i
    temp = list(str(fact))
    for s in range(len(temp) -1, -1, -1):
        if temp[s] == '0':
            cnt += 1
            temp.pop()
        else:
            fact = int(''.join(temp))
            break
fact_str = list(str(fact))
for s in range(len(fact_str) -1, -1, -1):
    if fact_str[s] == '0':
        cnt += 1
    else: break
print(cnt)
