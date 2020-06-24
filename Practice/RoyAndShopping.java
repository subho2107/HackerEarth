import java.io.*;
import java.util.*;

public class RoyAndShopping {
    final private static int MAX = 1000000;
    private static int [] lowestPrimeFact = new int[MAX+1];
    static void sieve()
    {
        for (int pos = 0; pos <= MAX; pos++) {
            lowestPrimeFact[pos] = pos;
        }
        for (int pos = 4; pos <= MAX; pos+=2) {
            lowestPrimeFact[pos] = 2;
        }
        for (int pos = 3; pos*pos <= MAX; pos++) {
            if (lowestPrimeFact[pos] == pos)
            {
//                System.out.println(pos);
                for (int i = (pos*pos); i <= MAX; i+=pos) {
                    if (lowestPrimeFact[i]==i)
                        lowestPrimeFact[i] = pos;
                }
            }
        }
//        System.out.println(lowestPrimeFact[979]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        sieve();
        while (n-- > 0) {
            int price = Integer.parseInt(buffer.readLine());
            sb.append((price-lowestPrimeFact[price])+"\n");
        }

        System.out.println(sb);
    }
}
