import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static List<Integer> list;
    public int[] solution(String[] maps) {
        list = new ArrayList<>();
        
        String[][] mapSecond = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i=0; i<mapSecond.length; i++){
            String[] split = maps[i].split("");
            for(int j= 0; j<mapSecond[0].length; j++){
                mapSecond[i][j] = split[j];
            }
        }
        
        for (int i = 0; i < mapSecond.length; i++) {
            for (int j = 0; j < mapSecond[i].length; j++) {
                if (!mapSecond[i][j].equals("X") && !visited[i][j]) {
                    int maxStay = go(mapSecond, visited, i, j);
                    list.add(maxStay);
                }
            }
        }
        
        if(list.size()==0) return new int[]{-1};
         list = list.stream().sorted((o1, o2) -> Integer.compare(o1, o2)).collect(Collectors.toList());

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
        
    }
    
    public static int go(String[][]mapSecond, boolean[][]visited, int x, int y){
        if(x < 0 || x >= mapSecond.length || y < 0 || y >= mapSecond[0].length || mapSecond[x][y].equals("X") || visited[x][y]){
            return 0;
        }
        visited[x][y] = true;
        
        
        int sum = Integer.parseInt(mapSecond[x][y]);
        
        int down = go(mapSecond, visited, x+1, y);
        int up = go(mapSecond, visited, x-1, y);
        int left = go(mapSecond, visited, x, y-1);
        int right = go(mapSecond, visited, x, y+1);
        
        return sum + down + up + right + left;
        
    }
}