import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start, target;
    static List<List<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드의 개수
        M = Integer.parseInt(st.nextToken()); // 정점의 개수

        // M개의 간선줄을 받아서 저장함 (BFS 돌리기 용이하게 저장해야겠다)
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            edges.get(i1).add(i2);
            edges.get(i2).add(i1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges.get(i));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 시작
        target = Integer.parseInt(st.nextToken()); // 목표

        int answer = 0;

        // 1. 첫번째 BFS 를 이용해 목표까지 이동하기
        Node node1 = bfs1();
        answer = node1.route.size() - 1;
        Node node2 = bfs2(node1.route);

        answer = answer + node2.route.size();
        System.out.println(answer);
    }

    private static Node bfs2(List<Integer> route) {
        boolean[] visited = new boolean[N + 1];
        int temp = start;
        start = target;
        target = temp;

        for (int i = 0; i < route.size(); i++) {
            visited[route.get(i)] = true;
        }
        visited[start] = false; // 시작점은 새로 방문해야 하니까
        visited[target] = false;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, new ArrayList<>()));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == target) {
                return cur;
            }

            for (Integer next : edges.get(cur.x)) {
                if (visited[next]) continue;

                List<Integer> nextRoute = new ArrayList<>(cur.route);
                nextRoute.add(next);
                queue.add(new Node(next, nextRoute));
                visited[next] = true;
            }
        }
        return null;
    }

    private static Node bfs1() {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> route = new ArrayList<>();
        route.add(start);
        queue.add(new Node(start, route));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == target) {
                return cur;
            }

            for (Integer next : edges.get(cur.x)) {
                if (visited[next]) continue;

                List<Integer> nextRoute = new ArrayList<>(cur.route);
                nextRoute.add(next);
                queue.add(new Node(next, nextRoute));
                visited[next] = true;
            }
        }
        return null;
    }

    static class Node {
        int x;
        List<Integer> route;

        public Node(int x, List<Integer> route) {
            this.x = x;
            this.route = route;
        }
    }
}
