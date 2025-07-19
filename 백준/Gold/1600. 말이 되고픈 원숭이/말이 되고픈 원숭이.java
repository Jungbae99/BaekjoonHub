import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                int element = Integer.parseInt(st.nextToken());
                arr[i][j] = element;
            }
        }

        bfs();
        br.close();
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        // 상하좌우, 나이트의 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] horseX = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] horseY = {-1, 1, -1, 1, -2, -2, 2, 2};

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W || arr[nextX][nextY] == 1) continue;
                if (visited[nextX][nextY][now.horse]) continue;
                visited[nextX][nextY][now.horse] = true;
                queue.add(new Node(nextX, nextY, now.count + 1, now.horse));
            }

            if (now.horse < K) {
                for (int i = 0; i < 8; i++) {
                    int nextX = now.x + horseX[i];
                    int nextY = now.y + horseY[i];
                    int nextHorse = now.horse + 1;

                    if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W || arr[nextX][nextY] == 1) continue;
                    if (visited[nextX][nextY][nextHorse]) continue;
                    visited[nextX][nextY][nextHorse] = true;
                    queue.add(new Node(nextX, nextY, now.count + 1, nextHorse));
                }
            }
        }

        System.out.println(-1);
    }

    static class Node {
        int x, y, count, horse;

        Node(int x, int y, int count, int horse) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horse = horse;
        }
    }
}
