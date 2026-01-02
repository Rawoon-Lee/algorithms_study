def solution(s):
    try:
        return int(s)
    except:
        sign = s[0]
        s = s[1:]
        num = int(s)
        if (sign == '+'):
            return num;
        return -num