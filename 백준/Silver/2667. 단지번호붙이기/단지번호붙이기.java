import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = line.charAt(j - 1) - '0';
            }
        }

        numberingComplexes(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(totalComplexes).append('\n');

        complexes
                .stream().sorted(Comparator.comparingInt(o -> o))
                .forEach(it -> sb.append(it).append('\n'));

        System.out.println(sb);
    }

    static List<Integer> complexes = new ArrayList<>();
    static int totalComplexes = 0;
    static int tempComplexes = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void numberingComplexes(int[][] arr) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr.length];

        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 1; j <= arr.length - 1; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    tempComplexes = 1;
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Node now = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = now.x + dx[k];
                            int nextY = now.y + dy[k];

                            if (nextY < 0 || nextX < 0 || nextX >= arr.length || nextY >= arr.length || visited[nextX][nextY] || arr[nextX][nextY] == 0)
                                continue;
                            visited[nextX][nextY] = true;
                            queue.add(new Node(nextX, nextY));
                            tempComplexes++;
                        }
                    }
                    totalComplexes++;
                    complexes.add(tempComplexes);
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
