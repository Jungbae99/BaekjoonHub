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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트케이스 개수
        int T = Integer.parseInt(st.nextToken());
        int[][] arr;
        boolean[][] visited;
        int count;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Node> queue;

        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 가로길이
            int M = Integer.parseInt(st.nextToken()); // 세로길이
            int C = Integer.parseInt(st.nextToken()); // 배추개수

            arr = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            queue = new LinkedList<>();

            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로길이
                int y = Integer.parseInt(st.nextToken()); // 세로길이
                arr[y][x] = 1;
            }
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1) {
                        if (visited[j][k]) {
                            continue;
                        }
                        queue.add(new Node(j, k));
                        visited[j][k] = true;
                        count++;

                        while (!queue.isEmpty()) {
                            Node node = queue.poll();
                            for (int o = 0; o < 4; o++) {
                                int nextX = node.x + dx[o];
                                int nextY = node.y + dy[o];

                                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                                    continue;
                                }
                                if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                                    queue.add(new Node(nextX, nextY));
                                    visited[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}