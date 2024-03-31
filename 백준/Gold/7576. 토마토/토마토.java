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

        int arr[][] = new int[m][n];
        int max = Integer.MIN_VALUE;
        boolean visited[][] = new boolean[m][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                arr[i][j] = tomato;
                if (tomato == 1) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + node.x;
                int nextY = dy[i] + node.y;

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (arr[nextX][nextY] == -1 || visited[nextX][nextY]) {
                    continue;
                }

                arr[nextX][nextY] = arr[node.x][node.y] + 1;
                queue.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;

            }
        }

        if (checkTomato(arr)) {
            // 안 익은 토마토가 있다면?
            System.out.println(-1);
        } else {
            // 안 익은 토마토가 없다면?
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    if (anInt > max) {
                        max = anInt;
                    }
                }
            }
            System.out.println(max - 1);
        }

    }

    private static boolean checkTomato(int[][] arr) {

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}