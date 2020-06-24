import java.io.*;
import java.util.*;

public class MotuPatlu {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int [n];
            long [] motu = new long[n];
            long [] patlu = new long[n];
            long temp = 0;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                motu[pos] = temp;
                temp += arr[pos];
            }
            temp = 0;
            for (int pos = n-1; pos >= 0; pos--) {
                patlu[pos] = temp;
                temp += 2*arr[pos];
            }
            int motuIceCream  = 0;

            for (int pos = 0; pos < n; pos++) {
                if (motu[pos]<=patlu[pos])
                    motuIceCream++;
            }

            sb.append(motuIceCream+" "+(n-motuIceCream)+"\n");
            if (motuIceCream < (n-motuIceCream))sb.append("Patlu\n");
            else if(motuIceCream > (n-motuIceCream))sb.append("Motu\n");
            else sb.append("Tie\n");
        }
        System.out.println(sb);
    }
}
