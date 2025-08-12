import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, weight;

        @Override
        public int compareTo(Node o) {
            return weight - o.weight; // 현재가 앞에 > 오름차순 정렬
        }

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int N, E;
    static int[] dist;
    static List<List<Node>> graph;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int stop1 = Integer.parseInt(st.nextToken());
        int stop2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += dijkstra(1, stop1);
        answer1 += dijkstra(stop1, stop2);
        answer1 += dijkstra(stop2, N);

        int answer2 = 0;
        answer2 += dijkstra(1, stop2);
        answer2 += dijkstra(stop2, stop1);
        answer2 += dijkstra(stop1, N);
   
        if (answer1 >= INF && answer2 >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(answer2, answer1));
        br.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int next = now.end;

            if (!visited[next]) {
                visited[next] = true;
                for (Node node : graph.get(next)) {
                    if (!visited[node.end] && dist[node.end] > node.weight + dist[next]) {
                        dist[node.end] = node.weight + dist[next];
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }

            }
        }
        return dist[end];
    }
}