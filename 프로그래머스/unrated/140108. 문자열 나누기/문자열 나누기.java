class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] charArray1 = s.toCharArray();

        char fc = 'a';
        int  fi = 0;
        int ei = 0;
        for (int i = 0; i < charArray1.length; i++) {
            fc = charArray1[i];
            fi = 1;
            ei = 0;
            if (i == charArray1.length-1) answer++;
            for (int j = i+1; j < charArray1.length; j++) {
                if (charArray1[j] == fc) {
                    fi++;
                }

                else ei ++;
                if (fi == ei || (fi != ei && j==charArray1.length-1) ) {
                    answer++;
                    i = j;
                    break;
                }

            }
        }
        
        
        return answer;
    }
}