def solution(clothes):
    answer = 1
    types = {}
    for cloth in clothes:
        if not cloth[1] in types:
            types[cloth[1]] = 1
        else:
            types[cloth[1]] += 1
    for type in types:
        answer *= types[type] + 1
    return answer - 1