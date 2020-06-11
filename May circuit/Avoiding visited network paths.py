mod = (10**9)+7
def getPower(num):
    powA = 0
    powB = 0
    powC = 0
    while not num%107:
        num //= 107
        powA+=1
    while not num%1361:
        num //= 1361
        powB+=1
    while not num%10000019:
        num //= 10000019
        powC+=1
    return (powA, powB, powC)

row, col = map(int , input().rstrip().split())
matrix = []
for _ in range(row):
    matrix.append(list(map(int, input().rstrip().split())))
dp = [[[[[0 for i in range(2)] for j in range(3)] for k in range(3)] for l in range(col)] for m in range(row)]
presPow107, presPow1361, presPow10e7 = getPower(matrix[0][0])
if presPow107>2:
    presPow107 = 2
if presPow1361 > 2:
    presPow1361 = 2
if presPow10e7 > 1:
    presPow10e7 = 1
if not (presPow107 == 2 and presPow1361 == 2 and presPow10e7 == 1):
    dp[0][0][presPow107][presPow1361][presPow10e7] = 1
for rowPos in range(row):
    for colPos in range(col):
        if rowPos == colPos == 0:
            continue
        presPow107, presPow1361, presPow10e7 = getPower(matrix[rowPos][colPos])
        for pow107 in range(3):
            for pow1361 in range(3):
                for pow10e7 in range(2):
                    if rowPos-1>=0:
                        dp[rowPos][colPos][min(2,presPow107+pow107)][min(2,presPow1361+pow1361)][min(1,presPow10e7+pow10e7)]+=dp[rowPos-1][colPos][pow107][pow1361][pow10e7]
                        dp[rowPos][colPos][min(2,presPow107+pow107)][min(2,presPow1361+pow1361)][min(1,presPow10e7+pow10e7)]%=mod
                    if colPos-1>=0:
                        dp[rowPos][colPos][min(2,presPow107+pow107)][min(2,presPow1361+pow1361)][min(1,presPow10e7+pow10e7)]+=dp[rowPos][colPos-1][pow107][pow1361][pow10e7]
                        dp[rowPos][colPos][min(2,presPow107+pow107)][min(2,presPow1361+pow1361)][min(1,presPow10e7+pow10e7)]%=mod

ans = 0
for pow107 in range(3):
    for pow1361 in range(3):
        for pow10e7 in range(2):
            if not(pow107==2 and pow1361==2 and pow10e7==1):
                ans = (ans+dp[-1][-1][pow107][pow1361][pow10e7])%mod
print(ans)
