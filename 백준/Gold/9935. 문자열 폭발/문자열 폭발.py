import sys
input = sys.stdin.readline

quest = input().strip()
bomb = input().strip()
length = len(bomb)

stack = []
for letter in quest:
  stack.append(letter)
  if letter == bomb[-1] and len(stack) >= length:
    if ''.join(stack[-length:]) == bomb:
      for i in range(length):
        stack.pop()


print('FRULA 'if not stack else ''.join(stack))