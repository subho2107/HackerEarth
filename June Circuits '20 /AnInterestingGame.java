import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AnInterestingGame {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            int num = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] freq = new int[101];
            for (String n :
                    inp) {
                int temp = Integer.parseInt(n);
                freq[temp]++;
            }
            ArrayList<Integer> freqList = new ArrayList<>();
            for (int frequency :
                    freq) {
                if (frequency == 0) continue;
                freqList.add(frequency);
            }
            int maxNum = Collections.max(freqList);
            int noOfCols = (1<<(int)((Math.log(maxNum)/Math.log(2)+1)))-1, MOD = 1000000007;
            long [][] dp = new long[freqList.size()+1][noOfCols+1];
            dp[0][0] = 1;
            for (int rowPos = 1; rowPos <= freqList.size(); rowPos++) {
                for (int colPos = 0; colPos <= noOfCols; colPos++) {
                    dp[rowPos][colPos] = (dp[rowPos-1][colPos] + dp[rowPos-1][colPos^freqList.get(rowPos-1)])%MOD;
                }
            }
            sb.append(dp[freqList.size()][0]);
        }
        System.out.println(sb);
    }
}
