import sys
input = sys.stdin.readline

# 처음 주어지는 배열에 대해서 sort 를 먼저 한 다음에 
# 이진탐색으로 진행해보자
# 근데 찾을 대상은 중복되는 숫자가 없나...? 중복되는 숫자가 있으면 set 해주는게 더 
# 빠를거 같긴한데, 일단 해보고 나중에 set 까지 해서 다시 돌려보자

N = int(input())
num = [int(i) for i in input().split()]
num.sort()
M = int(input())
quest = [int(i) for i in input().split()]
answer = []
for q in quest:
    start = 0
    end = N -1
    is_exist = False
    while start <= end:
        mid = (start + end) // 2
        if num[mid] == q:
            answer.append(1)
            is_exist = True
            break
        elif q < num[mid]:
            end = mid - 1 
        else: 
            start = mid + 1
    if not is_exist:
        answer.append(0)


for a in answer:
    print(a)