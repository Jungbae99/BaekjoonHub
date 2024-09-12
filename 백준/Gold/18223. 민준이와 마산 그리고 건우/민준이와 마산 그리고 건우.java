import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 핵심 아이디어 :
// 1. 시작 ~ 건우의 최솟값을 구한다
// 2. 건우 ~ 끝까지의 최솟값을 구한다
// 3. 시작 ~ 끝까지 최솟값을 1+2 와 비교한다
public class Main {
    static class Node {
        int a, b;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static List<List<Node>> graph;
    static int V, E, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 노드의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        P = Integer.parseInt(st.nextToken()); // 건우 위치
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 양방향이니까
        }

        int startToP = dijkstra(1, P);
        int pToEnd = dijkstra(P, V);
        int startToEnd = dijkstra(1, V);

        if (startToP + pToEnd <= startToEnd) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end) {
        int[] distanceArr = new int[V + 1]; // 특정 노드까지의 거리를 저장함

        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[start] = 0; // 시작노드는 거리가 0

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.b));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int here = current.a;
            int distance = current.b;

            if (here == end) return distance;  // 목적지에 도달하면 즉시 반환
            if (distance > distanceArr[here]) continue;

            for (Node neighbor : graph.get(here)) {
                int newHere = neighbor.a;
                int newDistance = distance + neighbor.b;
                if (newDistance < distanceArr[newHere]) {
                    distanceArr[newHere] = newDistance;
                    pq.offer(new Node(newHere, newDistance));
                }
            }
        }
        return -1;
    }
}
