import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][]d = new long[n+1][2];
        d[1][0] = 0;
        d[1][1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<=1; j++) {
                if (j == 0) d[i][j] += d[i - 1][0] + d[i-1][1];
                if (j == 1) d[i][j] += d[i - 1][0];
            }
        }

        long answer= 0;
        answer += d[n][0] + d[n][1];
        System.out.println(answer);

    }
}