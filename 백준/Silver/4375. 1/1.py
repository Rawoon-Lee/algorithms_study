import sys
input = sys.stdin.readlines()

quest = []
for i in input:
    quest.append(int(i.strip()))

for q in quest:
    num = '1'
    while True:
        if int(num) % q == 0:
            print(len(num))
            break
        num += '1' 