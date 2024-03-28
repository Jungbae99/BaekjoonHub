import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


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
        int arr[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
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
                area = 0;
                queue.add(new Node(i, j));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    area++;
                    Node node = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int newX = dx[k] + node.x;
                        int newY = dy[k] + node.y;
                        if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                            continue;
                        }

                        if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                            queue.add(new Node(newX, newY));
                            visited[newX][newY] = true;
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