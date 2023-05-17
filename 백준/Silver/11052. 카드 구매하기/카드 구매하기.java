import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        int d[]=new int[n+1];

        int arr[]=new int[n+1];

        st= new StringTokenizer(br.readLine());

        for(int i=1;i<arr.length;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                d[i] = Math.max(d[i], d[i-j]+arr[j]);
            }
        }
        System.out.println(d[n]);

    }
}