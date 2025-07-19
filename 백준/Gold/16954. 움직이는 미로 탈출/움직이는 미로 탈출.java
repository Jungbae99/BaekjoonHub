import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String st = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = st.charAt(j);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[8][8][9];

        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        queue.add(new int[]{7, 0, 0});
        visited[7][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], t = now[2];

            if (x == 0 && y == 7) return 1;
            if (isWall(x, y, t)) continue; // 벽이 내려와 있으면 죽음

            for (int d = 0; d < 9; d++) {
                int nx = x + dx[d], ny = y + dy[d], nt = Math.min(t + 1, 8);
                if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
                if (isWall(nx, ny, t)) continue;   // 지금 이동하는 칸에 벽이 있으면 안 됨
                if (isWall(nx, ny, nt)) continue; // 벽이 내려와 덮으면 안 됨
                if (visited[nx][ny][nt]) continue;

                visited[nx][ny][nt] = true;
                queue.add(new int[]{nx, ny, nt});
            }
        }
        return 0;
    }

    private static boolean isWall(int x, int y, int t) {
        int nx = x - t;
        return nx >= 0 && arr[nx][y] == '#';
    }
}
