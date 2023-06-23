class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int tmp = 0;
        while(n >= a){
            
            tmp = n%a;
            n = n/a*b;
            answer += n;
            n += tmp;
        }
         
        return answer;
    }
}