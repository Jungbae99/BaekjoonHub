import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N, M;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();
        for (int cur = end; cur != 0; cur = parent[cur]) {
            path.add(cur);
            if (cur == start) break;
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : path) sb.append(integer).append(" ");
        System.out.println(path.size());
        System.out.println(sb);
    }

    static int[] dist;
    static int[] parent;

    private static void dijkstra(int start, int end) {
        dist = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(dist, 100000000);
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));

        dist[start] = 0;
        parent[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : graph.get(cur)) {
                    if (!visited[next.end] && dist[next.end] > next.weight + dist[cur]) {
                        dist[next.end] = next.weight + dist[cur];
                        parent[next.end] = cur;
                        pq.offer(new Node(next.end, dist[next.end]));
                    }
                }
            }
        }
    }
}
