import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[][] a = new int[N][M];

        for (int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                a[i][j] = in.nextInt();
            }
        }
        int tmp = 0;
        int answer = 0;
        for(int i=0; i<N; i++){
            for (int j = 0; j < M; j++) {
                // 밑으로 두개는 일직선 도형
                if(j+3<M) {
                    tmp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i][j+3];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 3 < N) {
                    tmp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+3][j];
                    if(answer < tmp) answer = tmp;
                }
                // 밑으로 하나 정사각형 도형
                if (i + 1 < N && j + 1 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
                    if(answer < tmp) answer = tmp;
                }
                // 밑으로 8개 "ㄱ"모양

                if (i + 2 < N && j - 1 >= 0) {
                    tmp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j-1];
                    if(answer < tmp) answer = tmp;
                }
                if(i+2 < N && j+1 < M){
                    tmp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j+1];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 2 < N && j - 1 >= 0) {
                    tmp = a[i][j-1] + a[i][j] + a[i+1][j] + a[i+2][j];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 2 < N && j + 1 < M) {
                    tmp = a[i][j+1] + a[i][j] + a[i+1][j] + a[i+2][j];
                    if(answer < tmp) answer = tmp;
                }
                if (i - 1 >= 0 && j + 2 < M) {
                    tmp = a[i-1][j] + a[i][j] + a[i][j+1] + a[i][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 1 < N && j + 2 < M) {
                    tmp = a[i][j] + a[i+1][j] + a[i][j+1] + a[i][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i - 1 >= 0 && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i-1][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 1 < N && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+2];
                    if(answer < tmp) answer = tmp;
                }

                // Z 모양 4개
                if (i + 1 < N && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+1][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i - 1 >= 0 && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i-1][j+1] + a[i-1][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i - 2 >= 0 && j + 1 < M) {
                    tmp = a[i][j] + a[i-1][j] + a[i-1][j+1] + a[i-2][j+1];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 2 < N && j + 1 < M) {
                    tmp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j+1];
                    if(answer < tmp) answer = tmp;
                }

                // 凸 모양 4개
                if (i + 1 < N && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i - 1 >= 0 && j + 2 < M) {
                    tmp = a[i][j] + a[i][j+1] + a[i-1][j+1] + a[i][j+2];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 2 < N && j - 1 >= 0  ) {
                    tmp = a[i][j] + a[i+1][j] + a[i+1][j-1] + a[i+2][j];
                    if(answer < tmp) answer = tmp;
                }
                if (i + 2 < N && j + 1 < M) {
                    tmp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j];
                    if(answer < tmp) answer = tmp;
                }
            }
        }
        System.out.println(answer);
    }
}