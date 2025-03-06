import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int S = Integer.parseInt(split[0]); // 주어지는 알파벳 길이
        int P = Integer.parseInt(split[1]); // 부분문자열 길이

        String str = br.readLine();

        String[] require = br.readLine().split(" ");
        int[] minCount = new int[4];

        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(require[i]);
        }

        System.out.println(calculate(S, P, str, minCount));
    }

    static int[] curCount = new int[4];

    private static int calculate(int S, int P, String str, int[] minCount) {
        int count = 0;

        for (int i = 0; i < P; i++) {
            char c = str.charAt(i);
            if (c == 'A') curCount[0]++;
            else if (c == 'C') curCount[1]++;
            else if (c == 'G') curCount[2]++;
            else if (c == 'T') curCount[3]++;
        }

        if (isValid(minCount)) {
            count++;
        }

        for (int i = P; i < S; i++) {
            char remove = str.charAt(i - P);
            if (remove == 'A') curCount[0]--;
            else if (remove == 'C') curCount[1]--;
            else if (remove == 'G') curCount[2]--;
            else if (remove == 'T') curCount[3]--;

            char add = str.charAt(i);
            if (add == 'A') curCount[0]++;
            else if (add == 'C') curCount[1]++;
            else if (add == 'G') curCount[2]++;
            else if (add == 'T') curCount[3]++;

            if (isValid(minCount)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isValid(int[] minCount) {
        for (int i = 0; i < 4; i++) {
            if (curCount[i] < minCount[i]) {
                return false;
            }
        }
        return true;
    }
}