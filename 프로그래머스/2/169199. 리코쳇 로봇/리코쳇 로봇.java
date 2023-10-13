import java.util.*;

class Pos{
    int x, y;
    int level;

    public Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    
    
    public int solution(String[] board) {
        int answer = 0;
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};
        Pos start = null;
        Pos goal = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new Pos(i, j, 0);
                }
                if (map[i][j] == 'G') {
                    goal = new Pos(i, j, 0);
                }
            }
        }
        answer = bfs(start, goal);
        return answer;
    }
    private static int bfs(Pos start, Pos goal) {
        Queue<Pos> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;

            if (x == goal.x && y == goal.y) {
                return level;
            }

            for (int i = 0; i < 4; i++) {
                Pos next = getPos(i, now);
                if (!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private static Pos getPos(int i, Pos now) {
        int x = now.x, y = now.y;
        int ix = dx[i];
        int iy = dy[i];
        while (x + ix >= 0 && x + ix < map.length && y + iy >= 0 && y + iy < map[0].length && map[x + ix][y + iy] != 'D') {
            x += ix;
            y += iy;
        }
        return new Pos(x, y, now.level + 1);
    }
    
}