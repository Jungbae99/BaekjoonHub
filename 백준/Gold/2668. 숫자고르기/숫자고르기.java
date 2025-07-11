import java.util.*;

public class Main {

    static int[] num;
    static boolean[] visited;
    static boolean[] finished;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        num = new int[n + 1];
        visited = new boolean[n + 1];
        finished = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) dfs(i);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i : result) {
            System.out.println(i);
        }
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static void dfs(int current) {
        visited[current] = true;
        path.add(current);

        int next = num[current];
        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발생
            int idx = path.indexOf(next);
            for (int i = idx; i < path.size(); i++) {
                result.add(path.get(i));
            }
        }

        finished[current] = true;
        path.remove(path.size() - 1);
    }
}
