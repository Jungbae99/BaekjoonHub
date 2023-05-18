import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        int d[]=new int[n+1];
        Arrays.fill(d, -1);
        d[0] = 0;
        int arr[]=new int[n+1];

        st= new StringTokenizer(br.readLine());

        for(int i=1;i<arr.length;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                int i1 = d[i - j] + arr[j];
                if(d[i]==-1 || d[i] > i1)
                d[i] = i1;
            }
        }
        System.out.println(d[n]);
    }
}