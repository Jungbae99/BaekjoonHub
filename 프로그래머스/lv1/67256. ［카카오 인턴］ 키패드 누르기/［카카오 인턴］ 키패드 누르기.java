import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String result = "";
        

        int ltmp = 10;
        int rtmp = 12;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numbers[i] = 11;
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                result += "L";
                ltmp = numbers[i];
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                result += "R";
                rtmp = numbers[i];
            }
            if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 11) {
                int leftabs = Math.abs(numbers[i] - ltmp) / 3 + Math.abs(numbers[i] - ltmp) % 3;
                int rightabs = Math.abs(numbers[i] - rtmp) / 3 + Math.abs(numbers[i] - rtmp) % 3;
                if (leftabs < rightabs) {
                    result += "L";
                    ltmp = numbers[i];

                } else if (leftabs > rightabs) {
                    result += "R";
                    rtmp = numbers[i];

                } else if (leftabs == rightabs) {
                    if(hand.equals("left")){
                        result += "L";
                        ltmp = numbers[i];
                    }else{
                        result += "R";
                        rtmp = numbers[i];
                    }

                }
            }
        }

        
        
        return result;
    }
}