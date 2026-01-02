def solution(n):
    if (not n):
        return 0;
    
    answer_check_list = [i+1 for i in range(n)]
    idx = n
    while (idx):
        if (n % idx):
            print(idx)
            answer_check_list[idx - 1] = 0
        idx -= 1

    return sum(answer_check_list)
    