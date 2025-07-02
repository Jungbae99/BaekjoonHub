
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 총 노드의 개수
        int pairCount = Integer.parseInt(br.readLine()); // 연결선의 개수
        List<List<Integer>> nodes = new ArrayList<>(); // 노드의 연결을 의미

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            nodes.get(i1).add(i2);
            nodes.get(i2).add(i1);
        }

        dfs(nodes);
    }

    private static void dfs(List<List<Integer>> nodes) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[nodes.size() + 1];
        queue.add(1);
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer next : nodes.get(now)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                count++;
            }
        }

        System.out.println(count);
    }
}
