import java.util.*;

class Solution {
    
     static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
       int numberOfArea = 0;
        int maxSizeofOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    maxSizeofOneArea = Math.max(dfs(i, j, picture, visited, picture[i][j]), maxSizeofOneArea);
                    numberOfArea++;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeofOneArea};
    }

    private static int dfs(int nowX, int nowY, int[][] picture, boolean[][] visited, int color) {
        visited[nowX][nowY] = true;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowX, nowY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int qX = poll[0];
            int qY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nX = qX + dx[i];
                int nY = qY + dy[i];

                if (nX < 0 || nX >= picture.length || nY < 0 || nY >= picture[0].length) {
                    continue;
                }

                if (picture[nX][nY] == color && !visited[nX][nY]) {
                    queue.add(new int[]{nX, nY});
                    visited[nX][nY] = true;
                    count++;
                }
            }
        }

        return count;
    }
}