import math
x, n = map(int, input().rstrip().split())
ans = 1
if n < 5:
    factorial = math.factorial(n)
    power = factorial%10
    ans = pow(x,power)%10
print(ans)
