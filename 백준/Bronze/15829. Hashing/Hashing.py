n = int(input())
s = input()
r, m = 31, 1234567891

hash = 0
for i, x in enumerate(s):
    hash += (ord(x) - ord('a') + 1) * r ** i
print(hash % m)