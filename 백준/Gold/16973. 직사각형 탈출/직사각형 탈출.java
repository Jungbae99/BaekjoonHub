
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, W;
    static int[][] arr;
    static int startX, startY, targetX, targetY;

    static int[][] prefixSum; // 누적합을 구하기 위함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildPrefixSum();

        // 마지막 줄 2 2(직사각형 크기) 1 1(출발지) 1 4(도착지) -> 최좌상단
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        targetX = Integer.parseInt(st.nextToken()) - 1;
        targetY = Integer.parseInt(st.nextToken()) - 1;

        bfs();
    }

    static void buildPrefixSum() {
        prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = arr[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }
    }

    static boolean[][] visited;

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited = new boolean[N][M];
        dist = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            if (x == targetX && y == targetY) {
                System.out.println(dist[x][y]);
                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (!canMove(nx, ny)) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        System.out.println(-1);
    }

    static int[][] dist;

    static boolean canMove(int x, int y) {
        if (x < 0 || y < 0 || x + H - 1 >= N || y + W - 1 >= M) return false;
        if (visited[x][y]) return false;
        if (!getPrefixSum(x, y)) return false;

        visited[x][y] = true;
        return true;
    }

    // x, y는 시작점을 의미
    // x1, y1, x2, y2 를 이용해 누적합을 구할건데, 각 숫자에 모두 +1을 해서 1base 인덱스로 맞춤
    private static boolean getPrefixSum(int x, int y) {
        int x1 = x + 1;
        int y1 = y + 1;
        int x2 = x + H;
        int y2 = y + W;

        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1] <= 0;
    }
}
