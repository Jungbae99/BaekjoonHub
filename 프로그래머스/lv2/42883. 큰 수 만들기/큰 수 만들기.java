import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k; // 10 - 4 = 6 (목표치)
        int start = 0; // 시작값을 계속 갱신
        
        while(start < number.length() && answer.length() != len){
            int endNum = k + answer.length() + 1;
            int max = 0;
            for(int i = start ; i< endNum ; i ++){
                if(max < number.charAt(i) - '0'){
                    max = number.charAt(i) - '0';
                    start = i + 1;
                } 
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }
}