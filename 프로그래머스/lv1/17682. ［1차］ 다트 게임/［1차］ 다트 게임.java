class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
         char[] drc = dartResult.toCharArray();

        int[] scores = new int[3];
        int count = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if (drc[i] == '#') {
                if (count == 1) scores[count - 1] *= -1;
                if (count == 2) scores[count - 1] *= -1;
                if (count == 3) scores[count - 1] *= -1;
            } else if (drc[i] == '*') {
                if (count == 1) {
                    scores[count - 1] *= 2;
                } else if (count == 2) {
                    scores[count - 1] *= 2;
                    scores[count - 2] *= 2;
                } else if (count == 3) {
                    scores[count - 1] *= 2;
                    scores[count - 2] *= 2;
                }
            } else if (drc[i] == 'S' || drc[i] == 'D' || drc[i] == 'T') {
                int num = Character.getNumericValue(drc[i - 1]);
                if (i-2 >= 0 && drc[i-2] == '1') num = 10;


                if (drc[i] == 'D') {
                    scores[count] = (int) Math.pow(num, 2);
                } else if (drc[i] == 'T') {
                    scores[count] = (int) Math.pow(num, 3);
                } else {
                    scores[count] = num;
                }
                count++;
            }
        }

        answer = scores[0] + scores[1] + scores[2];
        return answer;
    }
}