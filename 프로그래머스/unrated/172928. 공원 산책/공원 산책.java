import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int h = park.length;
        int w = park[0].length();
        int[] answer = new int[2];
        
        
        int[][] arr = new int[park.length][park[0].length()];

        int x = 0;
        int y = 0;


        int tmp = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'O') {
                    arr[i][j] = 0;
                } else if (park[i].charAt(j) == 'X') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 2;
                    y = i;
                    x = j;
                }
            }
        }
//        String[] routes = {"E 2", "S 2", "W 1"};
        for (int i = 0; i < routes.length; i++) {
            int distance = Character.getNumericValue(routes[i].charAt(routes[i].length() - 1));
            if (routes[i].charAt(0) == 'E') {
                tmp = x;
                for (int j = 0; j <distance; j++) {
                    if (x < w-1 && arr[y][x+1] != 1) {
                        x++;
                        continue;
                    } else {
                        x = tmp;
                        break;
                    }
                }
            } else if (routes[i].charAt(0) == 'S') {
                tmp = y;
                for (int j = 0; j < distance; j++ ) {
                    if (y < h-1 && arr[y+1][x] != 1) {
                        y++;
                        continue;
                    } else {
                        y = tmp;
                        break;
                    }
                }
            } else if (routes[i].charAt(0) == 'W') {
                tmp = x;

                for (int j = 0; j < distance; j++ ) {
                    if (x > 0 && arr[y][x-1] != 1) {
                        x--;
                        continue;
                    } else {
                        x = tmp;
                        break;
                    }

                }
            } else {
                tmp = y;
                for (int j = 0; j < distance; j++ ) {
                    if (y > 0 && arr[y-1][x] != 1) {
                        y--;
                        continue;
                    } else {
                        y = tmp;
                        break;
                    }

                }
            }
        }


        answer[0] = y;
        answer[1] = x;

        return answer;
    }
}