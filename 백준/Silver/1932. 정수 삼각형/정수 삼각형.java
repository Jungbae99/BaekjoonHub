import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][]arr = new int[N+1][N+1];
        int [][]d = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d[1][1] = arr[1][1];


        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    d[i][j] = d[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    d[i][j] = d[i - 1][j - 1] + arr[i][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + arr[i][j];
                }
            }
        }

        int maxSum = 0;
        for (int i = 1; i <= N; i++) {
            maxSum = Math.max(maxSum, d[N][i]);
        }

        System.out.println(maxSum);
    }
}