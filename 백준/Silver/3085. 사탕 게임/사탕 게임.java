import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        char[][] a = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                a[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j+1 < N){
                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
                    int tmp = check(a);
                    if(answer < tmp) answer = tmp;
                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
                }

                if(i+1 < N){
                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    int tmp = check(a);
                    if(answer < tmp) answer = tmp;
                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                }
            }
        }

        System.out.println(answer);
    }

    private static int check(char[][] a) {
        int answer = 1;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j=1; j<n; j++){
                if(a[i][j]==a[i][j-1]) cnt++;
                else cnt = 1;
                if(answer < cnt) answer = cnt;
            }
            cnt = 1;
            for(int j=1; j<n; j++){
                if(a[j][i]==a[j-1][i]) cnt ++;
                else cnt = 1;
                if(answer < cnt) answer = cnt;
            }
        }
        return answer;
    }


}