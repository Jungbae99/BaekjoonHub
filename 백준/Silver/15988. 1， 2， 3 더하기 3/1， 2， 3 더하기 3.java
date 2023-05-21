import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int mod = 1000000009;
        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(d[n]));
            bw.newLine();
        }

        bw.flush();
    }
}