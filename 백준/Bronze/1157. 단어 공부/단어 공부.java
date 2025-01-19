import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int[] count = new int[26]; // 알파벳 개수

        for (char c : arr) {
            if (c <= 90) {
                // 대문자인 경우
                count[c - 65]++;
            } else {
                count[c - 97]++;
            }
        }

        int max = -1;
        char answer = '?';

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 65);
            } else if (count[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }


}
