import java.util.*;

class Solution {
    public  static String[] solution(String[] files) {
        String[] result = files.clone();

        // tim sort 는 안정정렬
        Arrays.sort(result, (s1, s2) -> {
            String first = extractHead(s1).toLowerCase();
            String second = extractHead(s2).toLowerCase();

            // 숫자앞 문자 다르면
            if (!first.equals(second)) {
                return first.compareTo(second); // 오름차순
            }

              // 아 이렇게 하면 안되네 tail 에도 숫자가 나타날 수 있다네 시간초과다 망했다 33분
//            String firstNumber = s1.replaceAll("[^0-9]", ""); // 숫자만 가져온거 -> String 으로 변환
//            String secondNumber = s2.replaceAll("[^0-9]", ""); // 숫자만 가져온거 -> String 으로 변환
            int n1 = extractDigit(s1.substring(first.length()));
            int n2 =  extractDigit(s2.substring(second.length()));

            if (n1 != n2) {
                return n1 - n2;
            }

            return 0;
        });

        return result;
    }

    private static String extractHead(String s) {
        StringBuilder head = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                head.append(c);
            } else {
                break;
            }
        }
        return head.toString();
    }


    private static int extractDigit(String s) {
        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                break;
            }
        }
        return num.length() > 0 ? Integer.parseInt(num.toString()) : 0;
    }
}