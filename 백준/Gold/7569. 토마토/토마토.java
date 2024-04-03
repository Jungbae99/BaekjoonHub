import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int N;
    static int M;
    static int H;

    static boolean visited[][][];
    static int[] dx;
    static int[] dy;
    static int[] dz;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        dx = new int[]{-1, 0, 1, 0, 0, 0};
        dy = new int[]{0, -1, 0, 1, 0, 0};
        dz = new int[]{0, 0, 0, 0, -1, 1};
        queue = new LinkedList<>();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1) {
                        queue.add(new Node(i, j, k)); // 수정된 부분: 초기 익은 토마토의 위치를 올바르게 계산합니다.
                        visited[k][i][j] = true;
                    }
                }
            }
        }

        int days = bfs(arr);
        if (checkAllTomatoes(arr))
            System.out.println(days);
        else
            System.out.println(-1);
    }

    private static int bfs(int[][][] arr) {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                for (int j = 0; j < 6; j++) {
                    int newX = node.x + dx[j];
                    int newY = node.y + dy[j];
                    int newZ = node.z + dz[j];

                    if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < N && newY < M && newZ < H) {
                        if (!visited[newZ][newX][newY] && arr[newZ][newX][newY] == 0) {
                            visited[newZ][newX][newY] = true;
                            arr[newZ][newX][newY] = 1;
                            queue.add(new Node(newX, newY, newZ));
                        }
                    }
                }
            }
            days++;
        }

        return days - 1;
    }

    private static boolean checkAllTomatoes(int[][][] arr) {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[k][i][j] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}