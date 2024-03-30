import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        Node start = new Node(0, 0);
        queue.add(start);
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < 4; k++) {

                int newX = dx[k] + node.x;
                int newY = dy[k] + node.y;


                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                if (visited[newX][newY] || arr[newX][newY] == 0) {
                    continue;
                }

                queue.add(new Node(newX, newY));
                arr[newX][newY] = arr[node.x][node.y] + 1;
                visited[newX][newY] = true;
            }
        }
        System.out.println(arr[n - 1][m - 1]);

    }
}