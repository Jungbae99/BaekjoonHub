class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i< triangle.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; // 최좌측
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; // 최우측
            
            // 예를 들어 i가 4라면 4,5,2,6,5 중에 인덱스 1,2,3만해당
            for(int j = 1; j< i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) +  triangle[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
            
            
        }
        
        return answer;
    }
}