import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // node 의 개수만큼 List를 추가한다.
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n + 1];

        return bfs(graph, visited, n);
    }

    private int bfs(List<ArrayList<Integer>> graph, boolean[] visited, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int depth = poll[1];

            if (maxDepth == depth) answer++;
            else if (maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for (int i = 0; i < graph.get(node).size(); i++) {
                int w = graph.get(node).get(i);
                if (!visited[w]) {
                    queue.add(new int[]{w, depth + 1});
                    visited[w] = true;
                }
            }
        }


        return answer;
    }
}






