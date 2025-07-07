import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        int targetX = 0, targetY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        int[][] answer = getShortestDistanceArr(arr, targetX, targetY);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (arr[i][j] == 2) {
                    System.out.print(0 + " ");
                } else if (arr[i][j] == 0) {
                    System.out.print(0 + " ");
                } else if (answer[i][j] == 0) {
                    // 갈 수 있는데 도달 못한 곳
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] getShortestDistanceArr(int[][] arr, int targetX, int targetY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{targetX, targetY});
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dist = new int[arr.length][arr[0].length];
        dist[targetX][targetY] = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i], nextY = now[1] + dy[i];
                if (nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr[0].length || visited[nextX][nextY] || arr[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
                dist[nextX][nextY] = dist[now[0]][now[1]] + 1;
            }

        }
        return dist;
    }
}

