import java.util.*;

class Solution {

    private static int N;
    private static int[][] map;
    private static boolean[][][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int sum = Integer.MAX_VALUE;

    public long solution(int[][] board) {
        N = board.length;

        map = board;

        visit = new boolean[N][N][4];

        // x, y, dir(방향), cost(비용)
        bfs(0, 0, -1, 0);

        return sum;
    }

    private void bfs(int x, int y, int dir, int cost) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, cost, dir));
        visit[x][y][0] = visit[x][y][1] = visit[x][y][2] = visit[x][y][3] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int nowX = node.x;
            int nowY = node.y;
            int nowDir = node.dir;
            int nowCost = node.cost;

            if (nowX == N - 1 && nowY == N - 1) {
                sum = Math.min(sum, nowCost);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextDir = i;
                int nextCost = nowCost;

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || map[nextX][nextY] == 1) {
                    continue;
                }

                if (nowDir == -1) {
                    nextCost += 100;
                } else if (nowDir == nextDir) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if (!visit[nextX][nextY][i] || map[nextX][nextY] >= nextCost) {
                    visit[nextX][nextY][i] = true;
                    map[nextX][nextY] = nextCost;
                    q.add(new Node(nextX, nextY, nextCost, nextDir));

                }
            }
        }
    }
}

class Node {
    int x, y, cost, dir;

    public Node(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}