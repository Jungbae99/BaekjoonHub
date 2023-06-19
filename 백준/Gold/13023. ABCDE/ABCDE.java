import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main{

    static List<Integer>[] list;
    static boolean status;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];

        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        status = false;
        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            dfs(i, 1);
            if (status) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    private static void dfs(int index, int depth) {
        if (depth == 5) {
            status = true;
            return;
        }
        check[index] = true;
        for (int next : list[index]) {
            if (!check[next]) {
                dfs(next, depth + 1);
            }
        }
        check[index] = false;
    }
}