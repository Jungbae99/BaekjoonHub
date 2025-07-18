import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireTime;  // 불의 도착 시간
    static int[][] jihoonTime; // 지훈이의 도착 시간
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> fireQ = new ArrayDeque<>();
    static Queue<int[]> jihoonQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fireTime = new int[R][C];
        jihoonTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;

                if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    jihoonQ.add(new int[]{i, j});
                    jihoonTime[i][j] = 0;
                }
            }
        }

        // 1. 불의 BFS (여러 개에서 동시에 퍼짐)
        while (!fireQ.isEmpty()) {
            int[] now = fireQ.poll();
            int x = now[0], y = now[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;
                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQ.add(new int[]{nx, ny});
            }
        }

        // 2. 지훈이의 BFS
        while (!jihoonQ.isEmpty()) {
            int[] now = jihoonQ.poll();
            int x = now[0], y = now[1];

            // 탈출조건: 가장자리 도착 즉시 종료
            if (x == 0 || y == 0 || x == R-1 || y == C-1) {
                System.out.println(jihoonTime[x][y] + 1); // 1분부터 시작이므로 +1
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || jihoonTime[nx][ny] != -1) continue;
                // 불보다 먼저 도착할 수 있어야 함 (불이 아예 안 오면 fireTime[nx][ny] == -1)
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihoonTime[x][y] + 1) continue;

                jihoonTime[nx][ny] = jihoonTime[x][y] + 1;
                jihoonQ.add(new int[]{nx, ny});
            }
        }
        // 탈출 못하면
        System.out.println("IMPOSSIBLE");
    }
}