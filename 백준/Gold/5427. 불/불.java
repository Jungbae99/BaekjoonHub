import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            queue = new LinkedList<>();
            result = 0;

            int x = 0, y = 0;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '*') {
                        queue.add(new int[]{i, j});
                    } else if (arr[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            queue.add(new int[]{x, y});
            sb.append(simulation() ? result : "IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean simulation() {
        while (!queue.isEmpty()) {
            result++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        if (arr[now[0]][now[1]] == '@') {
                            return true;
                        }
                        continue;
                    }
                    if (arr[nx][ny] != '.') {
                        continue;
                    }
                    arr[nx][ny] = arr[now[0]][now[1]];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}