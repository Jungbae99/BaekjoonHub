class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, numbers, target, 0);
        
        return answer;
    }
    
    private static void dfs(int depth, int[]numbers, int target, int sum){
        
        if(depth == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }
        
        dfs(depth+1, numbers, target, sum+numbers[depth]);
        dfs(depth+1, numbers, target, sum-numbers[depth]);
        
    }
}