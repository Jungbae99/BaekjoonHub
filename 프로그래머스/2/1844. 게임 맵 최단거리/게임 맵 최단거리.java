import java.util.*;

class Solution {
   static int[] dx = {-1, 1, 0, 0};
static int[] dy = {0, 0, -1, 1};
 
    
   public static int solution(int[][] maps){
    int n = maps.length;
    int m = maps[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0,0,1});

    while(!queue.isEmpty()){
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int depth = current[2];
      
      if(x == n - 1 && y == m - 1) { return depth; } //끝까지 갔으면 return
      for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if(maps[nx][ny] == 1) {
            maps[nx][ny] = 0; 
            queue.offer(new int[]{nx, ny, depth + 1});
          }
        }
      }
    } return -1 ;
}
}