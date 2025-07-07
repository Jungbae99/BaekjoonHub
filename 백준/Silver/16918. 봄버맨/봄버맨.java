import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int R, C, N;
    static char[][] initial, after1Explosion;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        initial = new char[R][C];
        for (int i = 0; i < R; i++) {
            initial[i] = sc.next().toCharArray();
        }
        // 한 번 폭발한 상태 미리 계산
        after1Explosion = getExplodedMap(initial);

        if (N == 1) {
            printMap(initial);
        } else if (N % 2 == 0) {
            // 모든 칸이 'O'
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) System.out.print('O');
                System.out.println();
            }
        } else if (N % 4 == 3) {
            printMap(after1Explosion);
        } else {
            // 두 번 폭발한 상태는 after1Explosion에서 한 번 더 폭발시킨 것
            char[][] after2Explosion = getExplodedMap(after1Explosion);
            printMap(after2Explosion);
        }
    }

    static char[][] getExplodedMap(char[][] map) {
        char[][] next = new char[R][C];
        // 일단 다 폭탄으로 채움
        for (int i = 0; i < R; i++)
            Arrays.fill(next[i], 'O');
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    next[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d], nj = j + dc[d];
                        if (0 <= ni && ni < R && 0 <= nj && nj < C)
                            next[ni][nj] = '.';
                    }
                }
            }
        }
        return next;
    }

    static void printMap(char[][] map) {
        for (int i = 0; i < R; i++) {
            System.out.println(new String(map[i]));
        }
    }
}
