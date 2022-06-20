N = int(input())
nums = []
for _ in range(N):
    tmp = list(map(int, input().split()))
    nums.append(tmp)

if N == 1:
    print(nums[0][0])
    exit()
dp = [[nums[0][0]], [nums[0][0] + nums[1][0], nums[0][0] + nums[1][1]]]
for i in range(2, N):
    tmp = []
    length = len(nums[i])
    for j in range(length):
        if j == 0:
            tmp.append(nums[i][j] + dp[i-1][j])
        elif j == length - 1:
            tmp.append(nums[i][j] + dp[i-1][j-1])
        else:
            tmp.append(nums[i][j] + max(dp[i-1][j-1], dp[i-1][j]))
    dp.append(tmp)

print(max(dp[N-1]))