import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N+1];
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
        }
        int answer = 1;
        for (int i = N; i >= 1; i--) {
            d[i] = 1;
            for (int j = i; j <= N; j++) {
                if(arr[i] > arr[j] && d[i] < d[j] +1 ){
                    d[i] = d[j] +1;
                    answer = Math.max(answer, d[i]);
                }
            }
        }
        System.out.println(answer);


    }
}