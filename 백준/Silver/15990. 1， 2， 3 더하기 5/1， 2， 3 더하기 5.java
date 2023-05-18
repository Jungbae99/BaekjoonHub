import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long d[][] = new long[100001][4];

        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        int mod = 1000000009;

        for (int i = 4; i <= 100000; i++) {
            d[i][1] = (d[i-1][2]%mod + d[i-1][3]%mod)%mod;
            d[i][2] = (d[i-2][1]%mod + d[i-2][3]%mod)%mod;
            d[i][3] = (d[i-3][1]%mod + d[i-3][2]%mod)%mod;
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long answer = (d[n][1] + d[n][2] + d[n][3])%mod;
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}