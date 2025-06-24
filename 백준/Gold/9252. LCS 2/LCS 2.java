import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] lcsArr = makeLcsArr(s1, s2);

        String lcs = getLcs(lcsArr);
        int length = lcs.length();

        if (length == 0) {
            System.out.println(0);
        } else {
            System.out.println(length);
            System.out.println(lcs);
        }
    }

    static String[] s1Arr;
    static String[] s2Arr;

    private static int[][] makeLcsArr(String s1, String s2) {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        s1Arr = s1.split("");
        s2Arr = s2.split("");

        arr[0][0] = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1Arr[i - 1].equals(s2Arr[j - 1])) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr;
    }

    private static String getLcs(int[][] lcsArr) {
        StringBuilder sb = new StringBuilder();

        int i = lcsArr.length - 1;
        int j = lcsArr[0].length - 1;

        while (i != 0 && j != 0) {
            int cur = lcsArr[i][j];
            if (lcsArr[i - 1][j] < cur && lcsArr[i][j - 1] < cur) {
                sb.append(s1Arr[i - 1]);
                i = i - 1;
                j = j - 1;
            } else {
                // 만약 대각선 방향으로 값이 증가하지 않았다면 LCS 배열에 넣지 않음
                // 탐색을 위해서 더 큰 방향으로 이동하며 탐색
                if (lcsArr[i - 1][j] >= lcsArr[i][j - 1]) {
                    i -= 1;
                } else {
                    j -= 1;
                }
            }
        }

        return sb.reverse().toString();
    }
}
