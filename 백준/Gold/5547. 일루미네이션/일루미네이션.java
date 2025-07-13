
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int W, H;
    public static int[][] map;
    public static int[][] result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //W : 행, H : 열
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());


        //외벽과 닿는 모든 면을 정육각형으로 둘러주기 위해 +2 를 합니다.
        // 0 (흰색부분) 으로 둘러쌓이게 처리하는 것 입니다.
        map = new int[W + 2][H + 2];
        visited = new boolean[W + 2][H + 2];
        result = new int[W + 2][H + 2];
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= H; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        BFS(0, 0);

        int answer = 0;
        for (int i = 0; i < W + 2; i++) {
            for (int j = 0; j < H + 2; j++) {
                answer += result[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void BFS(int startx, int starty) {

        //좌, 좌상, 우상, 우, 우하, 좌하  ( 시계방향 )
        int[][] OddDir = {{0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}};//홀수 행
        int[][] EvenDir = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};//짝수 행
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startx, starty));
        visited[startx][starty] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;

            for (int dir = 0; dir < 6; dir++) {
                int nx = 0;
                int ny = 0;
                if (x % 2 == 1) {
                    nx = x + OddDir[dir][0];
                    ny = y + OddDir[dir][1];
                } else {
                    nx = x + EvenDir[dir][0];
                    ny = y + EvenDir[dir][1];
                }

                if (nx < 0 || nx >= W + 2 || ny < 0 || ny >= H + 2) continue;
                if (map[nx][ny] == 1) {
                    result[x][y] += 1;
                    continue;
                }
                //이미 간곳은 visited[nx][ny] =true로 수정하여 중복안되게 합니다.
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}