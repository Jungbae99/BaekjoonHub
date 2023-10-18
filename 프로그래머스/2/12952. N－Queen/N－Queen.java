class Solution {
    static int[] board;
    static int count = 0;
    
    public int solution(int n) {
        
        board = new int[n];
        backTracking(n, 0);
        return count;
    }
    
    
    private static void backTracking(int n , int row){
        if(row == n){
            count ++;
            return;
        }
        
        for(int i=0; i<n; i++){
            board[row] = i;
            if(possible(row)){
                backTracking(n, row+1);
            }
        }
    }
    
    private static boolean possible(int row){
        for(int i = 0 ; i <row; i++){
            if(board[i] == board[row]){
                return false;
            }
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])){
                return false;
            } 
        }
        
        return true;
    }
}