import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int index, arriveTime, time;

        public Node(int index, int arriveTime, int time) {
            this.index = index;
            this.arriveTime = arriveTime;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time != o.time) return this.time - o.time;
            if (this.arriveTime != o.arriveTime) return this.arriveTime - o.arriveTime;
            return this.index - o.index;
        };
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Arrays.sort(jobs, (int[] o1, int[] o2) -> {
                return o1[0] - o2[0];
        });

        int idx = 0;        // 아직 큐에 넣지 않은 작업의 인덱스
        int time = 0;       // 현재 시간(완료 시각 진행)
        int done = 0;       // 완료한 작업 수
        int totalTurn = 0;  // 반환 시간 합
        int n = jobs.length;

        while (done < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                // 대기 작업이 없으면 시간을 다음 도착 시각으로 점프
                time = jobs[idx][0];
                continue;
            }

            // 가장 짧은 작업 수행
            Node cur = pq.poll();
            time += cur.time;                         // 이 작업의 완료 시각
            totalTurn += (time - cur.arriveTime);     // 반환 시간 = 완료 - 도착
            done++;
        }

        return totalTurn / n; // 정수부분
    }
}
