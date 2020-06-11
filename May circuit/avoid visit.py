from collections import defaultdict
def uniquePaths(r, c, dp, hash):
    if r > n-1 or c > m-1:
        return 0
    hash[matrix[r][c]] += 1
    if hash == hashX:
        return
    if dp[r][c] != 0:
        return dp[r][c]
    if r == n-1 and c == m-1:
        return 1
    down = uniquePaths(r + 1, c, dp, hash) % 1000000007
    right = uniquePaths(r, c + 1, dp, hash) % 1000000007
    dp[r][c] = down+right
    return dp[r][c]

X = 212072634227239451
hashX = {107:2, 1361:2, 10000019:1}
h
n, m = map(int , input().rstrip().split())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, input().rstrip().split())))
dp = [[0]*m for _ in range(n)]
dp[n-1][m-1] = 1
cnt = uniquePaths(0, 0, dp, defaultdict(int))
print(cnt)