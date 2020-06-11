def getSum(num, k):
    if num < k:
        return (num*(num+1))//2
    elif num//k == 1:
        return ((num*(num+1))//2) - k + 1
    else:
        noofDivs = num//k
        sumOfAll = (num*(num+1))//2
        divSum = (noofDivs*(2*k + (noofDivs-1)*k))//2
        replacingSum = getSum(num//k, k)
        return sumOfAll-divSum+replacingSum
t = int(input())
for _ in range(t):
    num, k = map(int, input().rstrip().split())
    result = getSum(num, k)
    print(result)
