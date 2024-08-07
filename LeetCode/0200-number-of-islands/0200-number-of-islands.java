  // dfs
  class Solution {
    static boolean[][] visited;
    public int numIslands(char[][] grid) {
        int numsIsland = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') { // 탐색하지 않았고, 땅인경우 탐색시작
                    dfs(grid, i, j);
                    numsIsland++;
                }
            }
        }
        return numsIsland;
    }

    private void dfs(char[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 만약 탐색하려는 구간이 gird를 벗어났거나, 이미 탐색했던 공간이라면 return
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = true;

        dfs(grid, x - 1, y); // 아래로 한칸
        dfs(grid, x, y - 1); // 왼쪽으로 한칸
        dfs(grid, x + 1, y); // 위로 한칸
        dfs(grid, x, y + 1); // 오른쪽으로 한칸

        // 이렇게 다 돌고나면? 하나의 섬이 완성되었음
    }

}
