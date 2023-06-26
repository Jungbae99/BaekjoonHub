import java.util.*;

class Solution {
    public int solution(int[] nums) {
   
        int n = nums.length / 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == n) break;
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        
        
        return list.size();
    }
}