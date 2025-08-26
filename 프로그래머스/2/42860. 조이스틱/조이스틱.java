import java.util.*;

class Solution {
    public int solution(String name) {
        int vertical = 0;
        int horizontal = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int i1 = c - 'A';
            int i2 = 'Z' - c + 1;
            vertical += Math.min(i1, i2);
        }

        int n = name.length();
        
        horizontal = n - 1;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && name.charAt(j) == 'A') j++;

            horizontal = Math.min(horizontal, i * 2 + (n - j));
            horizontal = Math.min(horizontal, i + (n - j) * 2);
        }

        return horizontal + vertical;
    }
}