import java.util.Stack;

class Solution {
    public int[] solution(String s) {
               int count = 0;
        int zeroCount = 0;
        int[] answer = new int[2];

        int sInt = 0;
        String remove = "";
        int removeZeroCount = 0;
        int second = 0;
        Stack<String> stack = new Stack<>();


        while (!s.equals("1")) {
            count ++;
            sInt = s.length();
            remove = s.replaceAll("0", "");
            removeZeroCount = sInt - remove.length();
            String tmp = "";
            second = remove.length();
            while (second != 0) {
                stack.push(String.valueOf(second % 2));
                second = second / 2;
            }
            while (!stack.isEmpty()) {
                tmp += stack.pop();
            }
            s = tmp;
            zeroCount += removeZeroCount;
        }


        answer[0] = count;
        answer[1] = zeroCount;
        
        return answer;
    }
}