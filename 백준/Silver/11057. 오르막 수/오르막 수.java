import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long d[][] = new long[N+1][10];
        int mod = 10007;
        for (int i = 0; i < 10; i++) {
            d[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += (d[i-1][j-k]);
                    d[i][j] %= mod;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += d[N][i];
        }
        System.out.println(answer % mod);
    }
}