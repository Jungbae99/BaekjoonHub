import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 샘터 개수
        K = Integer.parseInt(st.nextToken()); // 집 개수

        st = new StringTokenizer(br.readLine());

        Set<Integer> visited = new HashSet<>();
        Queue<long[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int site = Integer.parseInt(st.nextToken());
            visited.add(site);
            queue.add(new long[]{(long) site, 0});
        }

        long count = 0;

        // bfs
        while (!queue.isEmpty()) {
            int[] dx = {-1, 1};
            long[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int next = (int) now[0] + dx[i];

                if (!visited.contains(next)) {
                    long distance = now[1] + 1;
                    queue.add(new long[]{next, distance});
                    visited.add(next);
                    count += distance;
                    K--;
                    if (K == 0) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
    }

}