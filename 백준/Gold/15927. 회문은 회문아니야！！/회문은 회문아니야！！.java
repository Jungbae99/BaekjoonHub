import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        if (isOneCharLetter(s)) {
            System.out.println(-1);
        } else {
            if (isPalindrome(s)) {
                // 팰린드롬이라면 문자열길이 -1
                System.out.println(s.length() - 1);
            } else {
                // 팰린드롬이 아니라면 그냥 문자열 길이
                System.out.println(s.length());
            }
        }
    }

    private static boolean isOneCharLetter(String s) {
        if (s.length() == 1) {
            return true;
        }
        
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[0] != charArray[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}