import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    // 그래프의 인접 리스트를 저장하기 위한 ArrayList
    static ArrayList<Integer>[] nodeList;

    // BFS에서 사용될 노드 클래스
    static class node {
        int node;      // 현재 노드
        int cnt;       // 이 노드에 도달하기 위해 걸린 단계 수
        String allNode; // 이 노드에 도달하기 위해 거친 경로

        // 노드 생성자
        public node(int node, int cnt, String allNode) {
            this.node = node;
            this.cnt = cnt;
            this.allNode = allNode;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드의 수
        int N = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[N + 1]; // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) nodeList[i] = new ArrayList<>();

        // 포인트를 x좌표 기준으로 관리하기 위한 우선순위 큐
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.x - o2.x; // 포인트를 x좌표 기준으로 비교
        });

        // 극단적인 포인트 추가
        pq.add(new Point(-10000000, 0));
        pq.add(new Point(10000000, 0));

        // 각 노드의 속성을 읽고 포인트를 우선순위 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 노드 ID
            int x = Integer.parseInt(st.nextToken()); // X좌표
            int r = Integer.parseInt(st.nextToken()); // 반경

            // 각 노드의 범위를 나타내는 포인트 추가
            pq.add(new Point(x - r, k)); // 범위의 왼쪽 끝
            pq.add(new Point(x + r, k)); // 범위의 오른쪽 끝
        }

        // 포인트의 관계에 따라 트리(그래프)를 구축
        makeTree(pq, -1);

        // 경로 검색을 위한 시작 노드와 종료 노드 읽기
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        // BFS 초기화
        boolean[] visit = new boolean[N + 1]; // 방문한 노드를 추적하기 위한 배열
        Queue<node> que = new LinkedList<>();
        visit[from] = true; // 시작 노드를 방문한 것으로 표시
        que.add(new node(from, 1, "" + from)); // BFS를 시작하는 노드 추가

        // BFS 루프
        while (!que.isEmpty()) {
            node now = que.poll(); // 현재 노드 가져오기

            // 목적지에 도달했는지 확인
            if (now.node == to) {
                System.out.println(now.cnt); // 단계 수 출력
                System.out.println(now.allNode); // 경로 출력
                return; // 프로그램 종료
            }

            // 이웃 노드 탐색
            for (int next : nodeList[now.node]) {
                if (visit[next]) // 이미 방문한 노드는 건너뜀
                    continue;
                visit[next] = true; // 노드를 방문한 것으로 표시
                // 다음 노드를 큐에 추가
                que.add(new node(next, now.cnt + 1, now.allNode + " " + next));
            }
        }
    }

    // 우선순위 큐로부터 트리 구조를 구축하는 재귀 메서드
    static void makeTree(PriorityQueue<Point> pq, int parents) {
        Point now = pq.poll(); // 현재 포인트 가져오기

        // 부모가 있을 경우 현재 포인트와 부모 간의 연결 생성
        if (parents != -1) {
            nodeList[parents].add(now.y);
            nodeList[now.y].add(parents);
        }

        // 다음 포인트가 같은 y값을 가질 때까지 트리 구축 계속
        while (now.y != pq.peek().y) {
            makeTree(pq, now.y);
        }
        pq.poll(); // 현재 처리된 포인트 제거
    }
}
