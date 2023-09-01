import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int num = 0;

        while (sb.length() < t * m) {
            sb.append(calc(num++, n));
        }
        System.out.println(sb.toString());
        while (answer.length() != t) {
            answer.append(sb.charAt(p - 1));
            p += m;
        }

        return answer.toString();
    }

    private static String calc(int num, int n) {
        StringBuilder sb = new StringBuilder();

        while (num >= n) {
            sb.append(isMoreThanTen(num % n));
            num /= n;
        }
        sb.append(isMoreThanTen(num));
        return sb.reverse().toString();
    }

    private static char isMoreThanTen(int num) {
        if (num >= 10) {
            return (char) (num - 10 + 'A');
        }
        return (char)(num + '0');
    }
    
    
}