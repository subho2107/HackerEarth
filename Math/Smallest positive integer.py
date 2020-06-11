import os
import sys
from io import BytesIO, IOBase
import math


def inputIntArray():
    return list(map(int, input().rstrip().split()))


def inputArray():
    return input().rstrip().split()


def inputVars():
    return map(int, input().rstrip().split())


def inputNum():
    return int(input())



def getFactors(num):
    primeFactors = [2, 3, 5, 7]
    powerCnt = []
    pos = 0
    dup = num
    while num > 1 and pos < 4:
        power = 0
        while num % primeFactors[pos] == 0:
            num //= primeFactors[pos]
            power += 1
        pos += 1
        powerCnt.append(power)
    if num != 1:
        return getFactors(dup+1000000007)
    return (powerCnt, num)
def main():
    for _ in range(1):
        num = inputNum()
        if num == 0:
            print(10)
            break
        primeFactors = [2, 3, 5, 7]
        powerCnt, num = getFactors(num)
        arrDigs = []
        for pos in range(len(powerCnt)):
            power = powerCnt[pos]
            if power != 0:
                if pos <= 1:
                    if power == 1:
                        arrDigs.append(primeFactors[pos])
                    else:
                        if pos == 0:
                            temp = power // 3
                            for dig in range(temp):
                                arrDigs.append(primeFactors[pos] ** 3)
                            power = power%3
                        temp = power//2
                        for dig in range(temp):
                            arrDigs.append(primeFactors[pos]**2)
                        temp = power % 2
                        for dig in range(temp):
                            arrDigs.append(primeFactors[pos])
                else:
                    for dig in range(power):
                        arrDigs.append(primeFactors[pos])
        arrDigs.sort()
        res = ''
        for dig in arrDigs:
            res += str(dig)
        print(res)





#.........................................FAST INPUT OUTPUT.......................................
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

#....................................END OF FAST I/O............................................

if __name__ == "__main__":
    main()
