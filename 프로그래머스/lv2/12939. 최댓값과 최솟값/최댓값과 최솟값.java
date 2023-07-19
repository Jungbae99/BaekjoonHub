import java.util.*;


class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");

        String answer = "";
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        arr = Arrays.stream(arr).sorted().toArray();

        answer = arr[0] + " " + arr[arr.length-1];
        
        return answer;
    }
}