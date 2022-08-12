import sys
input = sys.stdin.readline

num = int(input())
people = []
for i in range(num):
    weight, height = map(int, input().split())
    people.append([weight, height, i])

people.sort(key=lambda x: (x[0], x[1]), reverse=True)
answer = [1 for i in range(num)]
for i in range(num):
    w1, h1, idx1 = people[i]
    for j in range(num):
        w2, h2, idx2 = people[j]
        # 덩치가 더 큰 사람이 존재할 경우 랭크 늘리기
        if w2 < w1 and h2 < h1:
            answer[idx2] +=1
print(*answer)