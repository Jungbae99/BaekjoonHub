import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // "0000"
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new int[]{0, 0, 0, 0}); // 마지막이 카운트
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                System.out.println(cur[3] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];
                int broken = cur[2];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M || arr[nX][nY] == 1) continue;
                if (visited[nX][nY][broken]) continue;
                visited[nX][nY][broken] = true;
                queue.add(new int[]{nX, nY, broken, cur[3] + 1});
            }

            // 벽을 안 부쉈다면 부수는 방식으로도 이동할 수 있음
            if (cur[2] == 0) {
                for (int i = 0; i < 4; i++) {
                    int nX = cur[0] + dx[i];
                    int nY = cur[1] + dy[i];

                    if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                    if (visited[nX][nY][1]) continue;
                    visited[nX][nY][1] = true;
                    queue.add(new int[]{nX, nY, 1, cur[3] + 1});
                }
            }
        }

        System.out.println(-1);
    }
}