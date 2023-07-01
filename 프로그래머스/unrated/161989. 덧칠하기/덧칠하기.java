class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        for (int i = 0; i < n; i++) {
            wall[i] = i+1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < section.length; j++) {
                if (wall[i] == section[j]) {
                    i = section[j]-1 + m-1;
                    answer ++;
                    break;
                }
            }
        }
        
        return answer;
    }
}