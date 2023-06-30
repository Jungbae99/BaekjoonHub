import java.util.*;


class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean arr[] = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = true;
        }

        arr[0] = arr[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]==false) continue;
            for (int j = i * i; j <= n; j+=i) {
                arr[j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==true) answer ++;
        }
        return answer;
    }
}