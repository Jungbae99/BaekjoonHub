import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited, finished;
    static int teamCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            teamCount = 0;

            for (int i = 1; i <= n; i++)
                arr[i] = sc.nextInt();

            for (int i = 1; i <= n; i++)
                if (!visited[i])
                    dfs(i);

            sb.append(n - teamCount).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int temp = next;
            teamCount++;
            while (temp != cur) {
                teamCount++;
                temp = arr[temp];
            }
        }
        finished[cur] = true;
    }
}
