import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            
            // 전력망 나누기
            int[] cutWire = wires[i];

            // List 안에 ArrayList 를 할당
            List<Integer>[] graph = new List[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // 가장 핵심 -> node 마다 간선의 수를 저장할 수 있다.
            for (int j = 0; j < wires.length; j++) {
                if (j == i) continue; // 현재 끊은 전선은 제외
                int[] wire = wires[j]; // {1, 3}
                graph[wire[0]].add(wire[1]);
                graph[wire[1]].add(wire[0]);
            }

            int[] count = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            // 첫 번째 전력망 탐색
            int count1 = dfs(1, graph, visited, count);

            // 두 번째 전력망 탐색
            visited = new boolean[n + 1];
            int count2 = n - count1;

            // 두 전력망 송전탑 개수 차이 계산
            int diff = Math.abs(count1 - count2);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private static int dfs(int node, List<Integer>[] graph, boolean[] visited, int[] count) {
        visited[node] = true;
        count[node] = 1;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                count[node] += dfs(neighbor, graph, visited, count);
            }
        }

        return count[node];
    }

}


