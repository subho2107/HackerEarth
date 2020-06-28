import java.io.*;
import java.util.*;

public class NumberOfTriangles {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            long n = Integer.parseInt(inp[0]), a = Integer.parseInt(inp[1]), b = Integer.parseInt(inp[2]);
            if (n==5)
                sb.append("1\n");
            else
            {
                long temp = a;
                a = Math.min(a,b);
                b = Math.max(temp, b);
                b = Math.min(b-a, n-b+a)+1;
                a = 1;
                long setOfPoints1 = Math.max(a,b) - 2, setOfPoints2 = n - Math.max(a,b);
                long total = Math.max(0, setOfPoints1-2)+Math.max(0,setOfPoints2-2);
                if (Math.min(setOfPoints1, setOfPoints2)==0)
                {
                    total += (n-5)*(n-6) + 2*(n-5);
                }
                else if (Math.min(setOfPoints1, setOfPoints2)==1)
                {
                    total += (n-6)*(n-6) + 2*(n-5);
                }
                else if (Math.min(setOfPoints1, setOfPoints2)==2)
                {
                    total += (n-6)*(n-7) + 2*(n-5) + (n-4);
                }
                else
                {
                    total += (n-8)*(n-6) + 4*(n-5);
                }
                sb.append(total+"\n");

            }
        }
        System.out.println(sb);
    }
}
