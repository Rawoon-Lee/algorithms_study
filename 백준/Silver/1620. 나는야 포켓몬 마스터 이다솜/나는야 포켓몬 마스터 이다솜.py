import sys
input = sys.stdin.readline

N, M = map(int, input().split())
pokedex = {}
for i in range(N):
    value = input().strip()
    pokedex[i+1] = value
    pokedex[value] = i + 1
for j in range(M):
    q = input().strip()
    if q.isdigit():
        print(pokedex.get(int(q)))
    else:
        print(pokedex.get(q))
