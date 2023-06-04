import java.util.Scanner;

import java.util.Arrays;


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int bin = 0;
        String answer[] = new String[n];

        for (int i = 0; i < n; i++) {
            String str = "";
            bin = (arr1[i] | arr2[i]);
            int tmp = bin;
            while (bin > 0) { 
                if(bin % 2 == 1) str = "#" + str;
                else str = " " + str;
                bin /= 2;
            }
            while (str.length() < n) {
                str = " " + str;
            }
            
            answer[i] = str;
        }
        return answer;
    }
}