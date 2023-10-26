class Solution {
    static int[] result = new int[11];
    static int[] lion = new int[11];
    static int max = Integer.MIN_VALUE;
    public int[] solution(int n, int[] info) {
        back(0, n, info);
        if(max == -1){
            return new int[]{-1};
        }
        return lion;
    }
    
    
    private static void back(int depth, int n, int[] info){
        if(depth == n){
            int diff = score(info);
            if(max <= diff){
                max = diff;
                lion = result.clone();
            }
            return;
        }
        
        for(int i=0; i<info.length && result[i] <= info[i]; i++){
            result[i] += 1;
            back(depth + 1, n, info);
            result[i] -= 1;
        }
    }
    
    private static int score(int[] info){
        int apeach = 0, lion = 0;
        
        for(int i=0; i<result.length; i++){
            
            if(info[i] == 0 && result[i] == 0) continue;
            if(info[i] >= result[i]) apeach += (10 - i);
            else lion += (10 - i);
        }
        int diff = lion - apeach;
        if(diff <= 0) return -1;
        return diff;
    }
}