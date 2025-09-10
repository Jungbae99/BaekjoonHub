import java.util.*;

class Solution {
    public int solution(int[][] routes) {
      Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int count = 1;
        int lastCamera = routes[0][1]; // 첫 번째 구간의 끝점에 카메라 설치
        
        for (int i = 1; i < routes.length; i++) {
            // 현재 카메라가 이 구간을 커버하지 못하면
            if (routes[i][0] > lastCamera) {
                count++;
                lastCamera = routes[i][1]; // 새 구간의 끝점에 카메라 설치
            }
        }
        
        return count;
    }
}