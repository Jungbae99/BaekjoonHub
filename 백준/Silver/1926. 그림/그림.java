import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};


        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                count++;
                queue.add(new Node(i, j));
                area = 0;
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    area++;

                    for (int k = 0; k < 4; k++) {
                        int nowX = node.x + dx[k];
                        int nowY = node.y + dy[k];

                        if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= m) {
                            continue;
                        }
                        if (arr[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                            queue.add(new Node(nowX, nowY));
                            visited[nowX][nowY] = true;
                        }
                    }
                }
                if (area > max) {
                    max = area;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}