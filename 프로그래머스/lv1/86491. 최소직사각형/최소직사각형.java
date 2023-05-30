class Solution {
    public int solution(int[][] sizes) {
        
        int x = 0;
        int y = sizes[0][0];
        
        //가로는 최대, 세로는 최소로 초기화
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<sizes[0].length; j++){
                x = Math.max(sizes[i][j], x);
                y = Math.min(sizes[i][1], y);
            }
        }
        // 세로를 조금씩 올려나가는 방식
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<sizes[0].length; j++){
                if(sizes[i][1] > y){
                    if(sizes[i][0] > y) y=Math.min(sizes[i][1], sizes[i][0]);
                }
            }
        }
        int answer = x * y;
        return answer;
    }
}