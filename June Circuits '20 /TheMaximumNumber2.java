import java.io.*;
import java.util.*;

public class TheMaximumNumber2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        int [] power2 = new int[31];
        power2[0] = 1;
        for (int pos = 1; pos < 31; pos++) {
            power2[pos] = 2*power2[pos-1];
        }
        while (t-- > 0) {
            long setBitCnt[][] = new long[31][2];
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int[] bitCount = new int[31];
            inp = buffer.readLine().strip().split(" ");
            long temp = 0;
            for (int pos = 0; pos < n; pos++) {
                temp = Long.parseLong(inp[pos]);
                for (int power = 0; power < 31; power++) {
                    if ((temp&(1<<power)) != 0) {
                        bitCount[power]++;
                    }
                }
            }
            Set<Long>values = new HashSet<>();
            HashMap<Long, Integer>freq = new HashMap<>();
            int noOfNonZeroVals = 0;
            for (int power = 0; power < 31; power++) {
                if (bitCount[power]!=0) {
                    noOfNonZeroVals++;
                    long tempVal = (long) bitCount[power] * power2[power];
                    freq.put(tempVal, freq.getOrDefault(tempVal, 0) + 1);
                    values.add(tempVal);
                }
            }
            if (noOfNonZeroVals<k)
            {
                sb.append("-1\n");
            }
            else
            {
                ArrayList<Long>freqList = new ArrayList<>(values);
                Collections.sort(freqList, Collections.reverseOrder());
                int pos;
                for (pos = 0; pos < freqList.size(); pos++) {
                    if (k<=0)break;
                    else k -= freq.get(freqList.get(pos));
                }
                k += freq.get(freqList.get(pos-1));
                sb.append(ncr(freq.get(freqList.get(pos-1)), k)+"\n");

            }
        }
        System.out.println(sb);
    }

    static long ncr(int n, int r) {
        long ans = 1;
        if (r>n-r)
            r = n-r;
        for (int ri = 0; ri < r; ri++) {
            ans *= n-ri;
            ans /= ri+1;
        }
        return ans;

    }
}
