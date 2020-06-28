import java.io.*;
import java.util.*;

public class TheMaximumNumber {
    public static long getNext(long number)
    {
        long a , b, c, ans = 0;
        if (number>0)
        {
            a = -number & number;
            b = a + number;
            c = (b ^ number)/a;
            c >>=2;
            ans = b | c;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            float start = System.currentTimeMillis();
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), setBits = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split( " ");
            Integer [] arr = new Integer[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            int maxArr = Collections.max(Arrays.asList(arr));
            long temp = arr[0];
            for (int pos = 1; pos < n; pos++) {
                temp |= arr[pos];
            }
//            if ((int)(Math.log(maxArr)/Math.log(2))+1< setBits) {
//                sb.append("-1\n");
//                continue;
//            }
            if (Long.bitCount(temp)< setBits) {
                sb.append("-1\n");
                continue;
            }
            long minVal = 0;
            for (int pos = 0; pos < setBits; pos++) {
                minVal += 1<<pos;
            }
            long maxVal = 0, maxSum = 0;
            long maxNum = (long) ((1<<(int)(Math.log(Collections.max(Arrays.asList(arr)))/Math.log(2) + 1))-1);
            HashMap<Long, Long> maxSumCnt = new HashMap<Long, Long>();
            boolean check = true;
            for (long x = minVal; x <= maxNum; x=getNext(x)) {
                System.out.println((System.currentTimeMillis()-start)/1000F);
                if ((System.currentTimeMillis()-start)/1000F > 1.5)
                {
                    check= false;
                    break;
                }
                long sum = 0;
                for (int pos = 0; pos < n; pos++) {
                    sum += arr[pos]&x;
                }
                if (sum > maxSum)
                {
                    maxSum = sum;
                    maxVal = x;
                }
                if(maxSumCnt.containsKey(sum)) {
                    if (maxSumCnt.get(sum)>1e10)
                    {
                        check = false;
                        break;
                    }
                    maxSumCnt.put(sum, maxSumCnt.get(sum) + 1);
                }
                else
                    maxSumCnt.put(sum, 1L);
            }
            if (check)
                sb.append((maxSumCnt.get(maxSum))+"\n");
            else
                sb.append("1\n");
        }
        System.out.println(sb);
//        System.out.println(System.currentTimeMillis()/1000F);
    }
}
