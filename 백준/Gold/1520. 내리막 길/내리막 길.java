import java.util.*;
import java.io.*;

public class Main {

    static int[][]dp, arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0; // 먼저 0으로 세팅
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
            if (arr[x][y] > arr[nextX][nextY]) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }

        return dp[x][y];
    }
}
