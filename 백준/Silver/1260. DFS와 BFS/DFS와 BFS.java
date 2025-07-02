import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 (1~1000)
        int M = Integer.parseInt(st.nextToken()); // 간선 (1~10000)
        int V = Integer.parseInt(st.nextToken()); // 시작점

        List<List<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        dfsVisitedArr = new boolean[nodes.size() + 1];
        sysOutDfs(nodes, V);
        System.out.println(dfsStrBuffer);
        sysOutBfs(nodes, V);
    }

    static boolean[] dfsVisitedArr;
    static StringBuffer dfsStrBuffer = new StringBuffer();

    /**
     * Depth first search -> 깊이우선 탐색은 재귀함수를 이용했다.
     */
    private static void sysOutDfs(List<List<Integer>> nodes, int startPoint) {
        dfsVisitedArr[startPoint] = true;
        dfsStrBuffer.append(startPoint).append(" ");
        if (nodes.get(startPoint).isEmpty()) return;

        // 다음 노드의 깊이 탐색시 순차적으로 탐색하도록 함
        nodes.get(startPoint).sort((o1, o2) -> o1 - o2);
        for (int next : nodes.get(startPoint)) {
            if (dfsVisitedArr[next]) continue;
            sysOutDfs(nodes, next);
        }
    }

    /**
     * Breadth first search -> 넓이우선 탐색은 큐를 이용했다.
     */
    private static void sysOutBfs(List<List<Integer>> nodes, int startPoint) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[nodes.size() + 1];

        queue.add(startPoint);
        visited[startPoint] = true;
        sb.append(startPoint).append(" ");

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 다음 노드의 넓이 탐색시 순차적으로 탐색하도록 함
            nodes.get(now).sort((o1, o2) -> o1 - o2);

            for (Integer next : nodes.get(now)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                sb.append(next).append(" ");
            }
        }

        System.out.println(sb);
    }
}
