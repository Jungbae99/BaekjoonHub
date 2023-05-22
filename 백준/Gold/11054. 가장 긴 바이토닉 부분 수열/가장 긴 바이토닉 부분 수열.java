import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int d[] = new int[N+1];
        int d2[] = new int[N+1];
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
        }


        for(int i=1; i<=N; i++) {
            d[i] = 1;
            for(int j=1; j<=i; j++) {
                if(arr[j] < arr[i] && d[j]+1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        for(int i=N; i>=1; i--){
            d2[i] = 1;
            for(int j=i+1; j<=N; j++){
                if(arr[i] > arr[j] && d2[j]+1 > d2[i]){
                    d2[i] = d2[j]+1;
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(answer < d[i] + d2[i] - 1){
                answer  = d[i] + d2[i] - 1;
            }
        }
        System.out.println(answer);

    }
}