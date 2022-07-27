import sys
input = sys.stdin.readline

T = int(input())
ans = []
for _ in range(T):
    N, target = map(int, input().split())
    q = []
    doc = list(map(int, input().split()))
    for i in range(N):
        if i==target:
            q.append((doc[i], True))
        else:
            q.append((doc[i], False))
    # 큐가 빌 때까지 돌린다 즉 직접 시뮬레이션을 돌려본다.
    cnt = 0
    while q:
        maxNum = max(q, key = lambda x:x[0])
        now = q.pop(0)
        if now[0] < maxNum[0]:
            q.append(now)
        else:
            cnt += 1
            if now[1]:
                print(cnt)
                break
