import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static List<int[]> virus = new ArrayList<>();
    static boolean[][] dfsVisited;
    static int maxSafeCount;
    static int wallCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dfsVisited = new boolean[N][M];
        maxSafeCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int element = Integer.parseInt(st.nextToken());
                arr[i][j] = element;
                if (element == 2) virus.add(new int[]{i, j});
                if (element == 1) wallCount++;
            }
        }

        // 1. dfs 를 이용하여 벽 세개를 세운 경우에만 탐색을 진행. 모든 경우를 탐색해도 배열이 3 * 8 이라는 작은 수 이기 때문에 시간제한에 걸리지 않는다고 가정
        dfs(0);

        System.out.println(maxSafeCount);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {
        boolean[][] bfsVisited = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        int virusCount = 0;

        for (int[] ints : virus) {
            bfsVisited[ints[0]][ints[1]] = true; // 방문처리
            queue.add(ints); // 바이러스들 큐에 삽입
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            virusCount++;
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || bfsVisited[nextX][nextY]) continue;
                if (arr[nextX][nextY] != 0) continue; // 벽이 없는 경우에만 바이러스가 이동할 수 있음
                queue.add(new int[]{nextX, nextY});
                bfsVisited[nextX][nextY] = true;
            }
        }

        int safeCount = (N * M) - (wallCount + 3) - virusCount;
        maxSafeCount = Math.max(maxSafeCount, safeCount);
    }
}
