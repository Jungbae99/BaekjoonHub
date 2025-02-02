import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int heartX = 0;
    static int heartY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = getArr(br, N);

        int leftHand = 0;
        int rightHand = 0;
        int belly = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == heartX && arr[i][j] && j < heartY) {
                    leftHand++;
                }
                if (i == heartX && arr[i][j] && j > heartY) {
                    rightHand++;
                }
                if (i > heartX && arr[i][j] && j == heartY) {
                    belly++;
                }
                if (i > heartX && arr[i][j] && j < heartY) {
                    leftLeg++;
                }
                if (i > heartX && arr[i][j] && j > heartY) {
                    rightLeg++;
                }
            }
        }
        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftHand + " " + rightHand + " " + belly + " " + leftLeg + " " + rightLeg);

    }

    private static boolean[][] getArr(BufferedReader br, int n) throws IOException {
        boolean flag = false;
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (split[j].equals("*")) {
                    arr[i][j] = true;
                    if (!flag) {
                        flag = true;
                        heartX = i + 1;
                        heartY = j;
                    }
                }
            }
        }
        return arr;
    }
}