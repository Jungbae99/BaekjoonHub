import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] arr = new long[n+1][2];

            st = new StringTokenizer(br.readLine() , " ");
            for (int i=1; i<=n; i++) {
                arr[i][0] = Long.valueOf(st.nextToken());
            }

            st = new StringTokenizer(br.readLine() , " ");
            for (int i=1; i<=n; i++) {
                arr[i][1] = Long.valueOf(st.nextToken());
            }

            long[][] d = new long[n+1][3];
            for (int i=1; i<=n; i++) {
                d[i][0] = Math.max(d[i-1][0],Math.max(d[i-1][1],d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0],d[i-1][2])+arr[i][0];
                d[i][2] = Math.max(d[i-1][0],d[i-1][1])+arr[i][1];
            }
            long answer = 0;
            answer = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            bw.write(String.valueOf(answer));
            bw.newLine();
        }


        bw.flush();

    }
}