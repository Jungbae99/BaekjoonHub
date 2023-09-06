import java.util.*;
class Solution {
    static List<String> s;
    static String[] list;
    public int solution(String word) {
        int answer = 0;
          list = new String[]{"A", "E", "I", "O", "U"};
        s = new ArrayList<>();
        
        dfs("", 0);
        
        for(int i=0; i<s.size(); i++){
            if(word.equals(s.get(i))){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private static void dfs(String str, int depth){
        s.add(str);
        if(depth == 5){
            return;
        }
        for(int i=0; i<list.length; i++){
            dfs(str + list[i], depth+1);
        }
    }
}