import java.util.*;

class Solution {
       static class Node implements Comparable<Node> {
        int end, weight;

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }


    static List<List<Node>> graph;
    static int[] dist;
    static int N;

    public int solution(int N, int[][] road, int K) {
        dist = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] arr : road) {
            int s = arr[0];
            int e = arr[1];
            int w = arr[2];
            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }

        dijkstra(N);
        int answer = 0;
        for (int j : dist) {
            if (j <= K) {
                answer++;
            }
        }
        return answer;
    }

    private static void dijkstra(int N) {
        Arrays.fill(dist, 100000000);
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int end = cur.end;

            if (!visited[end]) {
                visited[end] = true;
                for (Node next : graph.get(end)) {
                    if (!visited[next.end] && dist[next.end] > dist[end] + next.weight) {
                        pq.add(new Node(next.end, dist[end] + next.weight));
                        dist[next.end] = dist[end] + next.weight;
                    }
                }
            }
        }
    }

}