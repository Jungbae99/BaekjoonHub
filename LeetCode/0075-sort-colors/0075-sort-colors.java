class Solution {

     public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length;

        while (mid < right) {
            if (nums[mid] < 1) {
                int temp = nums[left];

                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if (nums[mid] > 1) {
                right--;
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
            } else {
                mid++;
            }
        }
    }


}