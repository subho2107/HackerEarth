import math
numA = int(input())
numB = int(input())
if numA == numB:
    print(1)
else:
    msb = int(math.log2(numB))
    shift = msb
    while shift > 0:
        if (numB>>shift)&1 != (numA>>shift)&1:
            break
        shift-= 1
    T = 2**shift#The number which divides the numbers in the range numA to numB
    #such that similar results could be obtained
    '''
    the total possible numbers will be formed from the union of all possible OR of the grouping
    {numA, numA+1, numA+2,......, T-1} and {T, T+1, T+2,...., numB} 
    For first group its found that the numbers lie between numA to T-1 inclusive
    For second group its found that numbers lie between T and the or of all integers in the group
    '''
    k = 0# k is the largest integer such that 2^k + 2^r lies within the second group
    while T+(2**k) < numB:
        k += 1
    k -= 1
