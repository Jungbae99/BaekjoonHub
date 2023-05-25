import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int mod = 1000*1000+1;
        int answer = mod;
        int arr[][] = new int[N+1][3];
        int d[][] = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0; k<3; k++){
            for(int j=0; j<3; j++){
                if(k==j) d[1][j] = arr[1][j];
                else d[1][j] = mod; 
            }

            for(int i=2; i<=N; i++) {
                d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + arr[i][0];
                d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + arr[i][1];
                d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + arr[i][2];
            }
            for(int j=0; j<3; j++){
                if(j != k) answer = Math.min(answer, d[N][j]);
            }
        }
        System.out.println(answer);
    }
}