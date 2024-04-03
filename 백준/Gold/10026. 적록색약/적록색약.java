import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static boolean visited[][];
    static int count;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][N];
        visited = new boolean[N][N];
        count = 0;
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int firstResult = bfs(arr);// 적록색약 아닌애
        visited = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }

            }
        }
        int secondResult = bfs(arr);// 적록색약인 애

        System.out.print(firstResult + " " + secondResult);

    }

    private static int bfs(char[][] arr) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                queue.add(new Node(i, j));
                count++;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextX = node.x + dx[k];
                        int nextY = node.y + dy[k];

                        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                            continue;
                        }

                        if (arr[nextX][nextY] != arr[node.x][node.y] || visited[nextX][nextY]) {
                            continue;
                        }

                        queue.add(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return count;
    }
}