import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i = 0; i < citations.length; i++) {
            int hIndex = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, hIndex);
        }
        return answer;
    }
}