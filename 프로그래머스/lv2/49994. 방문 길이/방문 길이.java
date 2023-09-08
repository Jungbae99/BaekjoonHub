import java.util.*;
class Solution {
    static int dr[] = {-1 , 0, 1, 0};
    static int dc[] = {0 , -1, 0, 1};
    
    public int solution(String dirs) {
        int answer = 0;
        int map[][] = new int[11][11];
        boolean visit[][][] = new boolean[11][11][4];
        int r = 5, c = 5;
        for(int i=0; i<dirs.length(); i++){
            char cc = dirs.charAt(i);
            int d = 0;
            if(cc == 'U') d = 0;
            if(cc == 'L') d = 1;
            if(cc == 'D') d = 2;
            if(cc == 'R') d = 3;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= 11 || nc >= 11) continue;
            if(!visit[nr][nc][d]){
                visit[nr][nc][d] = true;
                d = (d % 2 == 0 )? 2 - d : 4 - d ;
                visit[r][c][d] = true;
                answer ++;
            }
            r = nr;
            c = nc;
            
        }
        return answer;
            
    }
}