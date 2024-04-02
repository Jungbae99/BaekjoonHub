import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(N);
            arr[N] = 1;

            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                for (int i = 0; i < 3; i++) {
                    int next = 0;
                    if (i == 0) {
                        next = node - 1;
                    } else if (i == 1) {
                        next = node + 1;
                    } else if (i == 2) {
                        next = node * 2;
                    }

                    if (next == K) {
                        System.out.println(arr[node]);
                        return;
                    }

                    if (next > 100000 || next < 0 || arr[next] > 0) {
                        continue;
                    }

                    queue.add(next);
                    arr[next] = arr[node] + 1;
                }
            }
        } 

        
    }
}