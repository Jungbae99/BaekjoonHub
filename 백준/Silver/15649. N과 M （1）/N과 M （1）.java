import java.io.*;
import java.util.Scanner;


public class Main {
    static boolean[] visit = new boolean[9];
    static int[] arr = new int[9];
    static StringBuilder sb = new StringBuilder();

    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if(i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[index] = i;
            go(index+1, n, m);
            visit[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        go(0, N, M);
        System.out.println(sb.toString());

    }
}