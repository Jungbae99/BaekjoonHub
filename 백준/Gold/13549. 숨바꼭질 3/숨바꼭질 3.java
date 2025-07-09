import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(hideAndSeek(N, K));
    }

    private static int hideAndSeek(int n, int k) {
        boolean[] visited = new boolean[1000001];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.now == k) {
                return now.count;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = now.now * 2;
                    if (next < 0 || next > 100000 || visited[next]) continue;
                    visited[next] = true;
                    queue.add(new Node(next, now.count));
                } else {
                    if (i == 1) next = now.now - 1;
                    else next = now.now +1;
                    if (next < 0 || next > 100000 || visited[next]) continue;
                    visited[next] = true;
                    queue.add(new Node(next, now.count + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int now, count;

        public Node(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }
}
