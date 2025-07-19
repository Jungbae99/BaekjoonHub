import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3 3
// 0 1 1
// 0 0 1
// 0 1 0
public class Main {
    static int N, M;
    static int[][] arr;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> zeroQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int element = Integer.parseInt(st.nextToken());
                arr[i][j] = element;
                if (element == 0) {
                    zeroQueue.add(new int[]{i, j});
                }
            }
        }

        boundaryBfs();
        getMaxAnswer();
        System.out.println(max);
    }

    static int boundarySeq;

    private static void boundaryBfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        boundarySeq = 0;
        int boundarySize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1부터 덩어리마다 하나씩 키워갈거임
                if (arr[i][j] == 1 && !visited[i][j]) {
                    boundarySeq++;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        boundarySize++;
                        arr[cur[0]][cur[1]] = boundarySeq;
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                            if (arr[nx][ny] != 1) continue;

                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    map.put(boundarySeq, boundarySize);
                    boundarySize = 0;
                }
            }
        }
    }

    static int max = 1;
    static Set<Integer> visited;

    private static void getMaxAnswer() {
        while (!zeroQueue.isEmpty()) {
            visited = new HashSet<>();
            int[] cur = zeroQueue.poll();
            int temp = 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == 0) continue;
                int index = arr[nx][ny];
                if (visited.contains(index)) continue;
                visited.add(index);
                temp += map.get(index);
            }
            max = Math.max(temp, max);
        }
    }

}
