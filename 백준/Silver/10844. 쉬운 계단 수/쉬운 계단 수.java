import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[][]d = new int[a+1][10];

        for(int i=1; i<=9; i++) d[1][i] = 1;
        for(int i=2; i<=a; i++){
            for(int j=0; j<=9; j++) {
                if (j + 1 <= 9) d[i][j] += d[i - 1][j + 1];
                if (j - 1 >= 0) d[i][j] += d[i - 1][j - 1];
                d[i][j] %= 1000000000;
            }
        }

        long answer= 0;
        for(int i=0; i<=9; i++) answer += d[a][i];
        answer = answer % 1000000000;
        System.out.println(answer);

    }
}