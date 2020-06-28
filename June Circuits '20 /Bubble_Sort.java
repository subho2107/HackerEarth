import java.io.*;
import java.util.*;

public class Bubble_Sort {
    public static int bubbleSort(int [] arr)
    {
        int cnt = 0;
        int n = arr.length;
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            cnt++;
            for (int pos = 0; pos < n - 1; pos++) {
                if (arr[pos] > arr[pos+1])
                {
                    int temp = arr[pos];
                    arr[pos] = arr[pos+1];
                    arr[pos+1] = temp;
                    swapped = true;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String [] inp = buffer.readLine().split(" ");
        int [] arr = new int[n];
        for (int pos = 0; pos < n; pos++) {
            arr[pos] = Integer.parseInt(inp[pos]);
        }
        int cnt = bubbleSort(arr);
        sb.append(cnt);
        System.out.println(sb);
    }
}
