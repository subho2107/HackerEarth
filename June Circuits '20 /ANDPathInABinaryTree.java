import java.io.*;
import java.util.*;

public class ANDPathInABinaryTree {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] paths = new int[100001];
        for (int num = 1; num < 100001; num+=2) {
            if (paths[num]!=0)continue;
            int cnt = 1;
            for (int num2 = num; num2 < 100001; num2=num2*2+1) {
//                paths[num2] = (cnt*(cnt+1))/2;
                paths[num2] = cnt-1;
                cnt++;
            }
        }
//        for (int pos = 1; pos < 100001; pos++) {
//            paths[pos] += paths[pos-1];
//        }
        int t = Integer.parseInt(buffer.readLine().replaceAll("\\s", ""));
        while (t-- > 0) {
            int  n = Integer.parseInt(buffer.readLine().replaceAll("\\s", ""));
            if (n%2==0)n--;
            int cnt = 0;
            while (n>= 0 && paths[n]==0)
                n-=2;
            while (n >= 0)
            {
                cnt += paths[n];
                n -= 4;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
