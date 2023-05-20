import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);

        long d[][] = new long[k+1][n+1];
        int mod = 1000000000;

        for (int i = 0; i <= n; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= mod;
                }
            }
        }
        System.out.println(d[k][n]);

    }
}