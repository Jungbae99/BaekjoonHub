import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = binary(n);
        int index = 1;
        while (true) {
            int number = n + index;
            if (count == binary(number)) {
                answer = number;
                break;
            }
            index++;
        }
        return answer;
    }

    public int binary(int x) {
        String str = Integer.toBinaryString(x);
        int count = 0;
        char[] strArr = str.toCharArray();
        for (char val : strArr) {
            if (val == '1') count++;
        }
        return count;
    }
}
