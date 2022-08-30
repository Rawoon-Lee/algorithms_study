N, R, C = map(int, input().split())

cnt = 0
while N != 0:
    N -= 1
    size = 2 ** N

    # 1사분면
    if R < size and C < size:
        cnt += 0
    elif R < size and C >= size:
        cnt += size ** 2
        C -= size
    elif R >= size and C < size:
        cnt += size ** 2 * 2
        R -= size
    else:
        cnt += size ** 2 * 3
        R -= size
        C -= size
print(cnt)
