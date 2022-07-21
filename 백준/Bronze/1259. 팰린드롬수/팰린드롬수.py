import sys

input = sys.stdin.readline

while True:
    str = input().strip()
    if str == '0': break
    print('yes' if str == str[::-1] else 'no')