class Solution {
    public int solution(int[] num_list) {
        
        int sum = 0;
        for(int i=0; i<num_list.length; i++){
            sum += num_list[i];
        }

        int mul = 1;
        for(int i=0; i<num_list.length; i++){
            mul *= num_list[i];
        }
        
        if(num_list.length>=11) {
            return sum;
        }
        return mul;
    }
}