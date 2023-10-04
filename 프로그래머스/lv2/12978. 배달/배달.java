import java.util.*;

class Solution {
       public static int solution(int N, int[][] road, int K) {
        int[] distance = new int[N + 1]; // 노드별 거리를 생성한다.
        Arrays.fill(distance, Integer.MAX_VALUE); // 모두 최댓값으로 초기화
        distance[1] = 0; // 1번 노드는 거리가 0

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // node 를 우선순위 큐에서 꺼낸다.

            if (cur.distance > distance[cur.node]) {
                continue;
            }
            for (int[] r : road) {
                int nextNode, nextDistance;
                if (r[0] == cur.node) {
                    nextNode = r[1];
                    nextDistance = r[2];
                } else if (r[1] == cur.node) {
                    nextNode = r[0];
                    nextDistance = r[2];
                } else {
                    continue;
                }

                if (distance[nextNode] > cur.distance + nextDistance) {
                    distance[nextNode] = cur.distance + nextDistance;
                    pq.offer(new Node(nextNode, distance[nextNode]));
                }
            }
        }

        int answer = 0;

        for (int dist : distance) {
            if (dist <= K) {
                answer++;
            }
        }
        return answer;
    }

    private static class Node implements Comparable<Node> {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}