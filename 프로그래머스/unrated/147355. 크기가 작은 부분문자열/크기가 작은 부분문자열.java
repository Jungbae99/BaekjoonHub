class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i=0; i<=t.length() - p.length(); i++){
            
            // if(p.length() == 1 || t.length() == p.length() ){
            //     return answer;                
            // }
            
            if (Long.parseLong(t.substring(i, i+p.length())) <= Long.parseLong(p) ){
                answer ++;
            }
        }
        return answer;
    }
}