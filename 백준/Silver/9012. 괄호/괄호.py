import sys
input = sys.stdin.readline

def stackLoop(text):
    stack = []
    for char in text:
        if char == '(' or char == '[':
            stack.append(char)
        elif char == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                return False
    if not stack:
        return True
    else:
        return False

num = int(input())
for i in range(num):
    # 입력을 받고
    text = input()
    if stackLoop(list(text)):
        print('YES')
    else:
        print('NO')