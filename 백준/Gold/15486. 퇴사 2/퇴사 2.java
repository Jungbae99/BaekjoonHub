
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][2];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        System.out.println(getMaxProfit(N, arr));
    }

    private static int getMaxProfit(int n, int[][] arr) {
        int[] dp = new int[n + 2];

        int max = -1;
        for (int i = 1; i <= n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int nextIndex = arr[i][0] + i;
            int nextVal = arr[i][1];

            if (nextIndex < n + 2) {
                dp[nextIndex] = Math.max(dp[nextIndex], nextVal + max);
            }
        }

        return dp[n + 1];
    }
}