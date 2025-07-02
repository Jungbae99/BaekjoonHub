
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            graph.get(i1).add(i2);
            graph.get(i2).add(i1);
        }

        bfsAndMakeArr(graph);
    }

    private static void bfsAndMakeArr(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] arr = new int[graph.size()];
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;
            visited[now] = true;

            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    queue.add(next);
                    arr[next] = now;
                }
            }
        }

        StringBuffer br = new StringBuffer();
        
        for (int i = 2; i < arr.length; i++) {
            br.append(arr[i]).append("\n");
        }

        System.out.println(br);
    }
}
