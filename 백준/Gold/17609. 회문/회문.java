import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            System.out.println(isPalindrome(s, 0, s.length() - 1, 0));
        }
    }

    private static int isPalindrome(String s, int start, int end, int result) {

        if (result >= 2) {
            return 2;
        }

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                result++;
                int endToPalindrome = isPalindrome(s, start, end - 1, result);
                int startToPalindrome = isPalindrome(s, start + 1, end, result);
                return Math.min(endToPalindrome, startToPalindrome);
            }
            start++;
            end--;
        }
        return result;
    }
}
