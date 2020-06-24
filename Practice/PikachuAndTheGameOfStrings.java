import java.io.*;
import java.util.*;

public class PikachuAndTheGameOfStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(buffer.readLine()), noOfDays = 0;
        String source = buffer.readLine();
        String destination = buffer.readLine();
        for (int pos = 0; pos < len; pos++) {
            char srcCh = source.charAt(pos), dstCh = destination.charAt(pos);
            int diff = 0;
            if (srcCh==dstCh)continue;
            else if (srcCh < dstCh)
                diff = dstCh - srcCh;
            else
                diff = ('Z' - srcCh) + (dstCh-'A'+1);
            noOfDays += diff%13 + (diff/13);
        }
        sb.append(noOfDays+"\n");
        System.out.println(sb);
    }
}
