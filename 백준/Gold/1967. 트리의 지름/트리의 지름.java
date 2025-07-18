import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 12
 * 1 2 3
 * 1 3 2
 * 2 4 5
 * 3 5 11
 * 3 6 9
 * 4 7 1
 * 4 8 7
 * 5 9 15
 * 5 10 4
 * 6 11 6
 * 6 12 10
 */
public class Main {

    static List<List<int[]>> nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 부모
            int c = Integer.parseInt(st.nextToken()); // 자식
            int w = Integer.parseInt(st.nextToken()); // 가중치

            nodes.get(p).add(new int[]{c, w});
            nodes.get(c).add(new int[]{p, w});
        }

        // 먼저 루트에서 가장 먼 노드를 찾는다. 가장 긴 노드라는 뜻이고 그 노드를 기준으로 가장 먼 노드가 지름이 된다.
        dfs(1, 0);

        // max, visited 초기화
        firstMax = 0;
        visited = new boolean[n + 1];

        // 루트에서부터 가장 먼 노드로부터 가장 멀리 떨어진 노드를 다시 탐색한다. 그때의 가중치가 지름이 된다.
        dfs(firstMaxNode, 0);
        System.out.println(firstMax);
    }

    static int firstMax = 0;
    static int firstMaxNode;

    private static void dfs(int now, int weight) {
        visited[now] = true;
        if (weight > firstMax) {
            firstMax = weight;
            firstMaxNode = now;
        }

        for (int[] nowArr : nodes.get(now)) {
            if (!visited[nowArr[0]]) {
                dfs(nowArr[0], weight + nowArr[1]);
            }
        }
    }
}
