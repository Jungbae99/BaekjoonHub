import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, L, R, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 차이가 (R-L) 이내에 있어야함, 0도 가능함
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        diff = R - L;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean flag = canMovement();
        while (flag) {
            flag = canMovement();
            answer++;
        }

        System.out.println(answer);
    }


    /**
     * BFS로 탐색하면서 국경이 열린 집합들끼리 묶음
     */
    private static boolean canMovement() {
        boolean canMovement = false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> tmpQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 각각의 섹션별로 평균값 업데이트 해야하니까 큐가 비더라도(국경선을 모두 열 수 없더라도) 배열 전부를 탐색해야 함
                if (visited[i][j]) continue;

                queue.add(new int[]{i, j});
                tmpQueue.add(new int[]{i, j});
                visited[i][j] = true;
                int countryCount = 1;
                int countryValue = arr[i][j];

                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    int nowX = now[0];
                    int nowY = now[1];

                    for (int k = 0; k < 4; k++) {
                        int nextX = nowX + dx[k];
                        int nextY = nowY + dy[k];

                        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextX][nextY]) continue;
                        // 두 국가의 인구수 차이가 L,R 차이보다 작거나 같아야 국경선을 열 수 있음
                        int abs = Math.abs(arr[nextX][nextY] - arr[nowX][nowY]);
                        if (abs > R || abs < L) continue;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        tmpQueue.add(new int[]{nextX, nextY});
                        countryCount++;
                        countryValue += arr[nextX][nextY];
                        canMovement = true; // 국경이 열릴 수 있는 조건이 있다면 true
                    }
                }

                // 하나의 섹션을 전부 탐색했으므로 기억해놨던 인덱스를 이용해 평균값으로 업데이트
                while (!tmpQueue.isEmpty()) {
                    int[] tmpNow = tmpQueue.poll();
                    arr[tmpNow[0]][tmpNow[1]] = countryValue / countryCount;
                }

            }
        }

        return canMovement;
    }
}