import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                int val = line.charAt(j - 1) - '0';
                arr[i][j] = val;
            }
        }

        System.out.println(bfs(arr));
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int bfs(int[][] arr) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        queue.add(new Node(1, 1, 1));
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == arr.length - 1 && now.y == arr[0].length - 1) {
                return now.val;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length || visited[nextX][nextY]) continue;
                if (arr[nextX][nextY] == 0) continue;
                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY, now.val + 1));
            }
        }

        return -1;
    }



    static class Node {
        int x, y, val;

        private Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}