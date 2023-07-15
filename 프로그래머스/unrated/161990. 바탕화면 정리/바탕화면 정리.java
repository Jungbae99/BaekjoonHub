class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
                int start1 = 0;
        int end1 = 0;
        int start2 = wallpaper[0].length();
        int end2 = 0;
        boolean start = false;

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                end1 = i+1;
                if (start == false) {
                    start1 = i;
                    start = true;
                }
            }

            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    start2 = Math.min(start2, j);
                    end2 = Math.max(end2, j);
                }
            }
        }
        end2 ++;
        
        answer[0] = start1;
        answer[1] = start2;
        answer[2] = end1;
        answer[3] = end2;
        return answer;
    }
}