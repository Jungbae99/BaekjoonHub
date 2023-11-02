class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }

        return answer;
    }

    private static void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i, computers, visited);
            }
        }
    }
}